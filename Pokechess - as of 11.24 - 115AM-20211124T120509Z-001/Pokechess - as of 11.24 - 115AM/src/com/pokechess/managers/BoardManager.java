package com.pokechess.managers;

import com.pokechess.board.Board;
// import com.pokechess.board.Tile;
// import com.pokechess.player.Pokemon;
import com.pokechess.player.Player;

public class BoardManager {
    private Board board;
    private Player player;
    private Player computer;
    private int turn;

    public BoardManager(){

        this.board = new Board();


    }

    public void run(Player player){

        Player player1 = new Player();

    }

    private void pause(int milliseconds){

    }
    private boolean isValid(String input){
        return true;
    }

    public void displayBoard(){
        System.out.println( "o---o---o---o---o---o---o---o\n" +
                            "|   |   |   |   |   |   |   |\n" +
                            "o---o---o---o---o---o---o---o\n" +
                            "|   |   |   |   |   |   |   |\n" +
                            "o---o---o---o---o---o---o---o\n" +
                            "|   |   |   |   |   |   |   |\n" +
                            "o---o---o---o---o---o---o---o\n" +
                            "|   |   |   |   |   |   |   |\n" +
                            "o---o---o---o---o---o---o---o\n" +
                            "|   |   |   |   |   |   |   |\n" +
                            "o---o---o---o---o---o---o---o");
    }
}
