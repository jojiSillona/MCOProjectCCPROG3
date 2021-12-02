package com.pokechess.managers;

import com.pokechess.board.Board;
import com.pokechess.player.Player;
import com.pokechess.player.Pokemon;

public class BoardManager {
    private Board board;
    public Player player = new Player();

    public BoardManager(){

        this.board = new Board();
    }

    public void runBoard(){
        this.player = player;

        Player player1 = new Player();
        board.createBoard();
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