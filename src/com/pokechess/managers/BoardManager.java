package com.pokechess.managers;

import com.pokechess.board.Board;
import com.pokechess.board.Position;
import com.pokechess.player.Player;
import com.pokechess.player.Pokemon;

import java.util.Arrays;

public class BoardManager {
    private Board board = new Board();
    public Player player = new Player();
    public Player computer = new Player();

    public void runBoard(){
        this.player = player;

        Player player1 = new Player();
        board.createBoard();
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

    public void addPokemonOnZones(Pokemon pokemon){

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