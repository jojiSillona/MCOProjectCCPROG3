package com.pokemongame.player;

public class GameManager {
    private PokemonSelectManager pokemonSelectManager;

    public GameManager(){
        this.pokemonSelectManager = new PokemonSelectManager();

    }
    public void run() {
        this.pokemonSelectManager.run();
        boolean isValid = true;

    }
    private boolean isValid(String input){
        return true;
    }
    private void processInput(String input){

    }
    private void displayScreen(){

    }
}