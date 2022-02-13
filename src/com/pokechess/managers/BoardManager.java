package com.pokechess.managers;

import com.pokechess.board.Board;
import com.pokechess.board.Position;
import com.pokechess.gui.BattleScreen;
import com.pokechess.gui.BoardScreen;
import com.pokechess.gui.Frame;
import com.pokechess.player.Player;
import com.pokechess.player.Pokemon;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class BoardManager {
    public Board board = new Board(this);
    public Player player = new Player();
    public Player computer = new Player();
    public Frame frame;

    public BoardScreen gui;
    public BattleScreen battleScreen;
    public BattleScreenManager battleScreenManager;
    public ArrayList <Position> possibleMoves = new ArrayList<>();

    public BoardManager(Frame frame){
        this.frame = frame;
    }

    public void initGui(){
        this.gui = new BoardScreen(this, frame, this.board);
    }

    //PLAYER: turn % 2 == 0
    //COMPUT: turn % 2 != 0
    private int turn;
    private int battleCommand;

    public void setupGame(){
        board.setZones(player.getPokemonTeam(), computer.getPokemonTeam());

    }

    public void castPossibleMove(Pokemon targetPokemon){
        int movement = targetPokemon.getSpeed();
        Position playerPos = targetPokemon.getPosition();
        int column = playerPos.getColumn();
        int row = playerPos.getRow();
        int i;

        //FORWARD MOVEMENT
        for(i = 1; i <= movement; i++){
            Position P = new Position(column,row);

            if(!board.outOfRange(column + i, row) && (this.board.emptyTile(column + i, row, this.board) ||
                    !this.board.board[row][column + i].getCurrPosition().getIsEnemy())) {
                P.setAlphabet(column + i);
                P.setNumber(row);
                possibleMoves.add(P);
            }
        }

        //BACKWARD MOVEMENT
        for(i = 1; i <= movement; i++){
            Position P = new Position(column,row);

            if(!board.outOfRange(column - i, row) && (this.board.emptyTile(column - i, row, this.board) ||
                    !this.board.board[row][column - i].getCurrPosition().getIsEnemy())) {
                P.setAlphabet(column - i);
                P.setNumber(row);
                possibleMoves.add(P);
            }
        }

        //UPWARD MOVEMENT
        for(i = 1; i <= movement; i++){
            Position P = new Position(column,row);

            if(!board.outOfRange(column, row - i) && (this.board.emptyTile(column, row - i, this.board) ||
                    !this.board.board[row - i][column].getCurrPosition().getIsEnemy())) {

                P.setAlphabet(column);
                P.setNumber(row - movement);
                possibleMoves.add(P);
            }
        }

        //DOWNWARD MOVEMENT
        for(i = 1; i <= movement; i++){
            Position P = new Position(column,row);

            if(!board.outOfRange(column, row + i) && (this.board.emptyTile(column, row + i, this.board) ||
                    !this.board.board[row + i][column].getCurrPosition().getIsEnemy())) {
                P.setAlphabet(column);
                P.setNumber(row + i);

                possibleMoves.add(P);
            }
        }

        //DIAGONAL UP FORWARD MOVEMENT
        for(i = 1; i <= movement; i++){
            Position P = new Position(column,row);

            if(!board.outOfRange(column + i, row - i) && (this.board.emptyTile(column + i, row - i, this.board) ||
                    !this.board.board[row - i][column + i].getCurrPosition().getIsEnemy())) {
                P.setAlphabet(column + i);
                P.setNumber(row - i);
                possibleMoves.add(P);
            }
        }

        //DIAGONAL DOWN FORWARD MOVEMENT
        for(i = 1; i <= movement; i++){
            Position P = new Position(column,row);

            if(!board.outOfRange(column + i, row + i) && (this.board.emptyTile(column + i, row + i, this.board) ||
                    !this.board.board[row + i][column + i].getCurrPosition().getIsEnemy())) {

                P.setAlphabet(column + i);
                P.setNumber(row + i);
                possibleMoves.add(P);
            }
        }

        //DIAGONAL UP BACKWARD MOVEMENT
        for(i = 1; i <= movement; i++){
            Position P = new Position(column,row);

            if(!board.outOfRange(column - i, row - i) && (this.board.emptyTile(column - i, row - i, this.board) ||
                    !this.board.board[row - i][column - i].getCurrPosition().getIsEnemy())) {
                P.setAlphabet(column - i);
                P.setNumber(row - i);
                possibleMoves.add(P);
            }
        }

        //DIAGONAL DOWN BACKWARD MOVEMENT
        for(i = 1; i <= movement; i++){
            Position P = new Position(column,row);

            if(!board.outOfRange(column - i, row + i) && (this.board.emptyTile(column - i, row + i, this.board) ||
                    !this.board.board[row + i][column - i].getCurrPosition().getIsEnemy())) {
                P.setAlphabet(column - i);
                P.setNumber(row + i);
                possibleMoves.add(P);
            }
        }
    }

    public void initiateBattle(){
        this.battleScreen = new BattleScreen(battleScreenManager, frame);
    }

    public void dunk(Player target, int index){
        //check if player is beside the goal zone
        //check if player has a point
        //if there is a defender inside, he must defeat him first.
        //if none then
        if(target.getPokemon(index).getPosition().getColumn() == 5) {
            int temp = target.getPokemon(index).getCarriedPoints();
            target.getPokemon(index).setCarriedPoints(0);
            target.setPoints(temp);
        }
    }

    public void heal(Pokemon target){
        boolean heal = target.pokemonHeal();
        int health = target.getMaxHp();
        Position playerPos = target.getPosition();
        int x = playerPos.getColumn();
        int y = playerPos.getRow();

        Position [] healthPos = new Position[1];

        System.out.print("Choose a pokemon to heal: ");
        // Scanner must be a supporter battle type
        // Pokemon must be beside
        // Can only heal one ally at a time

        if(heal){
            for(int i = 0; i < health; i++){
                healthPos = Arrays.copyOf(healthPos, healthPos.length + 1);

                // forward heal
                healthPos[healthPos.length - 1].setAlphabet(x + health);
                healthPos[healthPos.length - 1].setNumber(y);

                // backward heal
                healthPos[healthPos.length - 1].setAlphabet(x - health);
                healthPos[healthPos.length - 1].setNumber(y);

                // upward heal
                healthPos[healthPos.length - 1].setAlphabet(x);
                healthPos[healthPos.length - 1].setNumber(y + health);

                // downward heal
                healthPos[healthPos.length - 1].setAlphabet(x);
                healthPos[healthPos.length - 1].setNumber(y - health);

                // diagonal up heal
                healthPos[healthPos.length - 1].setAlphabet(x - health);
                healthPos[healthPos.length - 1].setNumber(y + health);

                // diagonal down heal
                healthPos[healthPos.length - 1].setAlphabet(x - health);
                healthPos[healthPos.length - 1].setNumber(y - health);

                health += 20;
                System.out.println(target.getName() + " has recovered 20 energy points.");
            }
        }
        else {
            System.out.println(target.getName() + " cannot be healed.");
        }
    }

    private void pause(int milliseconds){

    }
    private boolean isValid(String input){
        return true;
    }


    private void displayScreen(){
        System.out.println("\n\n\n\n\n POKECHESS BOARD SCREEN \n\n\n\n\n");
        // Print board

    }

    public BoardScreen getGui(){
        return gui;
    }


}
