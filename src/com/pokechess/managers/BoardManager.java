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

    public void dunk(Pokemon playerPokemon) {
        // int index
        //check if player is beside the goal zone
        //check if player has a point
        //if there is a defender inside, he must defeat him first.
        //if none then
        int tempPlayerPoints = playerPokemon.getCarriedPoints();
        int tempComputerPoints = computer.getPokemon(0).getCarriedPoints();

        if (playerPokemon.getPosition().getColumn() == 5) {
            // player beside goal zone
            if (tempPlayerPoints >= 1) {
                // this.board.board[i][6].currPokemonPos.getIsEnemy()
                if (computer.getPokemon(0).getPosition().getColumn() == 6) {
                    computer.getPokemon(0).getBattleType().equals("def");
                }
                initiateBattle();
                // battleScreenManager.player.getPokemon(0).setCarriedPoints(tempPlayerPoints +=
                // if a defender runs from a battle = defeat, player proceed with the dunk
            } else if (tempPlayerPoints < 1) {
                playerPokemon.getCarriedPoints();
                // nothing happens
            }
        }
        if (computer.getPokemon(0).getPosition().getColumn() == 0) {
            // computer beside goal zone
            if (tempComputerPoints >= 1) {
                if (playerPokemon.getPosition().getColumn() == 1) {
                    playerPokemon.getBattleType().equals("def");
                }
                initiateBattle();
                battleScreenManager.enemy.getPokemon(0).setCarriedPoints(tempComputerPoints);
            } else if (tempComputerPoints < 1) {
                playerPokemon.getCarriedPoints();
                // nothing happens
            }

        }
        //        if (playerPokemon.getPosition().getColumn() != 5){
        //            // if goal has no defender, im not sure how many points will be added tho
        //            tempPlayerPoints += ____
        //
    }

    public void heal(Pokemon target) {
        boolean tempSupporter = target.getBattleType().equals("sup");
        boolean heal = target.pokemonHeal();

        int health = target.getMaxHp();
        Position playerPos = target.getPosition();
        int x = playerPos.getColumn();
        int y = playerPos.getRow();

        Position[] healthPos = new Position[1];


        if (tempSupporter = true) {
            if (heal = true) {
                for (int i = 0; i < health; i++) {
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
