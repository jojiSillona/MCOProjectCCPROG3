package com.pokechess.managers;

import com.pokechess.board.Board;
import com.pokechess.board.Position;
import com.pokechess.board.Tile;
import com.pokechess.player.Player;
import com.pokechess.player.Pokemon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BoardManager {
    private Board board = new Board();
    public Player player = new Player();
    public Player computer = new Player();

    public void setupGame(){
        Pokemon [] team1 = this.player.getPokemonTeam();
        Pokemon [] team2 = this.computer.getPokemonTeam();
        board.setZones(team1, team2);
        board.printBoard(team1, team2);
    }

    public void runBoard(){

        Player target;
        int index;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        int i = 0;

        board.createBoard();

        while(true){
            if(i == 0){
                System.out.print("Player's move (Format - a1 a2): ");
            }
            else{
                System.out.print("Computer's move:(Format - a1 a2) : ");
            }

            try{
                line = in.readLine();
            }catch(IOException e){
                System.out.println("Error: No moved specified");
                continue;
            }
        }
        // insert move di ko gets huhu


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

    public void move(Player target, int index){
        int movement = target.getPokemon(index).getSpeed();
        Position playerPos = target.getPokemon(index).getPosition();
        int x = playerPos.getAlphabet();
        int y = playerPos.getNumber();

        Position [] availPos = new Position[1];
        int i;

        //FORWARD MOVEMENT
        for(i = 0; i < movement; i++){
            availPos = Arrays.copyOf(availPos, availPos.length + 1);
            availPos[availPos.length - 1].setAlphabet(x + movement);
            availPos[availPos.length - 1].setNumber(y);
        }

        //BACKWARD MOVEMENT
        for(i = 0; i < movement; i++){
            availPos = Arrays.copyOf(availPos, availPos.length + 1);
            availPos[availPos.length - 1].setAlphabet(x - movement);
            availPos[availPos.length - 1].setNumber(y);
        }

        //UPWARD MOVEMENT
        for(i = 0; i < movement; i++){
            availPos = Arrays.copyOf(availPos, availPos.length + 1);
            availPos[availPos.length - 1].setAlphabet(x);
            availPos[availPos.length - 1].setNumber(y + movement);
        }

        //DOWNWARD MOVEMENT
        for(i = 0; i < movement; i++){
            availPos = Arrays.copyOf(availPos, availPos.length + 1);
            availPos[availPos.length - 1].setAlphabet(x);
            availPos[availPos.length - 1].setNumber(y - movement);
        }

        //DIAGONAL UP FORWARD MOVEMENT
        for(i = 0; i < movement; i++){
            availPos = Arrays.copyOf(availPos, availPos.length + 1);
            availPos[availPos.length - 1].setAlphabet(x + movement);
            availPos[availPos.length - 1].setNumber(y + movement);
        }

        //DIAGONAL DOWN FORWARD MOVEMENT
        for(i = 0; i < movement; i++){
            availPos = Arrays.copyOf(availPos, availPos.length + 1);
            availPos[availPos.length - 1].setAlphabet(x + movement);
            availPos[availPos.length - 1].setNumber(y - movement);
        }

        //DIAGONAL UP BACKWARD MOVEMENT
        for(i = 0; i < movement; i++){
            availPos = Arrays.copyOf(availPos, availPos.length + 1);
            availPos[availPos.length - 1].setAlphabet(x - movement);
            availPos[availPos.length - 1].setNumber(y + movement);
        }

        //DIAGONAL DOWN BACKWARD MOVEMENT
        for(i = 0; i < movement; i++){
            availPos = Arrays.copyOf(availPos, availPos.length + 1);
            availPos[availPos.length - 1].setAlphabet(x - movement);
            availPos[availPos.length - 1].setNumber(y - movement);
        }
    }

    public void heal(Player target, int index){
        boolean heal = target.getPokemon(index).pokemonHeal();
        int health = target.getPokemon(index).getMaxHp();
        Position playerPos = target.getPokemon(index).getPosition();
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
                System.out.printf("%s has recovered 20 energy points\n", target.getPokemon(index).setHp(health));
            }
        }
        else {
            System.out.printf(" Sorr %s cannot be healed\n");
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

}
