package com.pokechess.managers;

import com.pokechess.board.Board;
import com.pokechess.board.Position;
import com.pokechess.gui.BoardScreen;
import com.pokechess.gui.Frame;
import com.pokechess.player.Player;
import com.pokechess.player.Pokemon;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BoardManager {
    public Board board = new Board();
    public Player player = new Player();
    public Player computer = new Player();

    public BoardScreen gui;

    public BoardManager(Frame frame){
        this.gui = new BoardScreen(this, frame, this.board);
    }

    //PLAYER: turn % 2 == 0
    //COMPUT: turn % 2 != 0
    private int turn;
    private int battleCommand;

    Scanner scn = new Scanner(System.in);
    int choice;

    public void setupGame(){
        board.setZones(player.getPokemonTeam(), computer.getPokemonTeam());

    }

    public void runBoard(){
        for(turn = 0; turn < 20; turn++){
            if(turn % 2 == 0){
                System.out.println("IT'S YOUR TURN!");
                board.printBoard(this.player.getPokemonTeam(), this.computer.getPokemonTeam());
                System.out.print("SELECT A POKEMON (use 0 - 4): ");
                choice = scn.nextInt();

                Pokemon selectedPokemon = this.player.getPokemon(choice);
                System.out.println("COMMANDS:");
                System.out.println("1. MOVE\n2. INITIATE BATTLE\n3. DUNK\n4. HEAL");
                System.out.print("PICK A COMMAND:");
                choice = scn.nextInt();

                switch(choice){
                    case 1:
                        castPossibleMove(selectedPokemon);
                        board.printBoard(this.player.getPokemonTeam(), this.computer.getPokemonTeam());
                        break;
                    case 2:
                        System.out.println("No battle action here but yeah cool.");
                        break;
                    case 3:
                        System.out.println("No dunk action here but yeah cool.");
                        break;
                    case 4:
                        if(selectedPokemon.getBattleType() == "sup")
                            heal(selectedPokemon);
                }
            }
        }
    }


    // Translates a alpha-number move to a move that would
    // work with a 2D array
    public int[] translatePosition(String move){

        if(move.charAt(0) < 'a' || move.charAt(0) > 'g'){
            throw new IllegalArgumentException();
        }

        int[] alpha = new int[2];
        switch(move.charAt(0)){
            case 'a':
                alpha[1] = 0;
                break;
            case 'b':
                alpha[1] = 1;
                break;
            case 'c':
                alpha[1] = 2;
                break;
            case 'd':
                alpha[1] = 3;
                break;
            case 'e':
                alpha[1] = 4;
                break;
            case 'f':
                alpha[1] = 5;
                break;
            case 'g':
                alpha[1] = 6;
                break;
        }

        try{
            alpha[0] = Integer.parseInt(move.substring(1));
            if(alpha[0] < 1 || alpha[0] > 6)
                throw new IllegalArgumentException();

            alpha[0] = alpha[0] - 1;
        }catch(NumberFormatException d){
            throw new IllegalArgumentException();
        }

        return alpha;
    }

    public void castPossibleMove(Pokemon targetPokemon){
        int movement = targetPokemon.getSpeed();
        Position playerPos = targetPokemon.getPosition();
        int x = playerPos.getAlphabet();
        int y = playerPos.getNumber();

        Position [] availPos = new Position[1];
        int i;

        //FORWARD MOVEMENT
        for(i = 0; i < movement; i++){
            availPos = Arrays.copyOf(availPos, availPos.length + 1);

            if(!board.outOfRange(x + movement, y) && board.emptyTile(x + movement, y)) {
                availPos[availPos.length - 1].setAlphabet(x + movement);
                availPos[availPos.length - 1].setNumber(y);
            }
        }

        //BACKWARD MOVEMENT
        for(i = 0; i < movement; i++){
            availPos = Arrays.copyOf(availPos, availPos.length + 1);

            if(!board.outOfRange(x - movement, y) && board.emptyTile(x - movement, y)) {
                availPos[availPos.length - 1].setAlphabet(x - movement);
                availPos[availPos.length - 1].setNumber(y);
            }
        }

        //UPWARD MOVEMENT
        for(i = 0; i < movement; i++){
            availPos = Arrays.copyOf(availPos, availPos.length + 1);

            if(!board.outOfRange(x, y + movement) && board.emptyTile(x, y + movement)) {
                availPos[availPos.length - 1].setAlphabet(x);
                availPos[availPos.length - 1].setNumber(y + movement);
            }
        }

        //DOWNWARD MOVEMENT
        for(i = 0; i < movement; i++){
            availPos = Arrays.copyOf(availPos, availPos.length + 1);

            if(!board.outOfRange(x, y - movement) && board.emptyTile(x, y - movement)) {
                availPos[availPos.length - 1].setAlphabet(x);
                availPos[availPos.length - 1].setNumber(y - movement);
            }
        }

        //DIAGONAL UP FORWARD MOVEMENT
        for(i = 0; i < movement; i++){
            availPos = Arrays.copyOf(availPos, availPos.length + 1);

            if(!board.outOfRange(x + movement, y + movement) && board.emptyTile(x + movement, y + movement)) {
                availPos[availPos.length - 1].setAlphabet(x + movement);
                availPos[availPos.length - 1].setNumber(y + movement);
            }
        }

        //DIAGONAL DOWN FORWARD MOVEMENT
        for(i = 0; i < movement; i++){
            availPos = Arrays.copyOf(availPos, availPos.length + 1);

            if(!board.outOfRange(x + movement, y - movement) && board.emptyTile(x + movement, y - movement)) {
                availPos[availPos.length - 1].setAlphabet(x + movement);
                availPos[availPos.length - 1].setNumber(y - movement);
            }
        }

        //DIAGONAL UP BACKWARD MOVEMENT
        for(i = 0; i < movement; i++){
            availPos = Arrays.copyOf(availPos, availPos.length + 1);

            if(!board.outOfRange(x - movement, y + movement) && board.emptyTile(x - movement, y + movement)) {
                availPos[availPos.length - 1].setAlphabet(x - movement);
                availPos[availPos.length - 1].setNumber(y + movement);
            }
        }

        //DIAGONAL DOWN BACKWARD MOVEMENT
        for(i = 0; i < movement; i++){
            availPos = Arrays.copyOf(availPos, availPos.length + 1);

            if(!board.outOfRange(x - movement, y - movement) && board.emptyTile(x - movement, y - movement)) {
                availPos[availPos.length - 1].setAlphabet(x - movement);
                availPos[availPos.length - 1].setNumber(y - movement);
            }
        }

        for(i = 0; i < availPos.length; i++){
            this.board.board[availPos[i].getAlphabet()][availPos[i].getNumber()].showTileMovePossible();
        }
    }

    public void initiateBattle(Board board, Pokemon player, Pokemon enemy){
        //check if battle is feasible if not prompt player no one is fighting them
        Random rnd = new Random();
        int probability = rnd.nextInt(1);

        System.out.println("We haven't implemented battle so we randomly choose who wins");
        //Player wins if probability is 0
        //Enemy wins if probability is 1
        if(probability == 0) {
            System.out.println(player.getName() + "wins!");
            //remove enemy pokemon on tile
        }
        else {
            System.out.println(enemy.getName() + "wins!");
            //remove player pokemon on tile
        }
    }

    public void dunk(Player target, int index){
        //check if player is beside the goal zone
        //check if player has a point
        //if there is a defender inside, he must defeat him first.
        //if none then
        if(target.getPokemon(index).getPosition().getAlphabet() == 5) {
            int temp = target.getPokemon(index).getCarriedPoints();
            target.getPokemon(index).setCarriedPoints(0);
            target.setPoints(temp);
        }
    }

    public void heal(Pokemon target){
        boolean heal = target.pokemonHeal();
        int health = target.getMaxHp();
        Position playerPos = target.getPosition();
        int x = playerPos.getAlphabet();
        int y = playerPos.getNumber();

        Position [] healthPos = new Position[1];

        System.out.print("Choose a pokemon to heal: ");
        // Scanner must be a supporter battle type
        // Pokemon must be beside
        // Can only heal one ally at a time

        if(heal == true){
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
