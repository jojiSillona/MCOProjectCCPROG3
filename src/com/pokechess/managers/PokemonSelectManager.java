package com.pokechess.managers;
import com.pokechess.player.Pokemon;

public class PokemonSelectManager {

    private BoardManager boardManager;

    public PokemonSelectManager(){
        this.boardManager = new BoardManager();
    }
    public void run(){
        this.displayScreen();

    }
    private boolean isValid(String input){
        return true;
    }
    private void processInput(String input){

    }
    public void displayScreen(){
        System.out.println("\n\n\nCHARACTER SELECT\n\n\n");

    }
}
