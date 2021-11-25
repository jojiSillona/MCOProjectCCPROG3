package com.pokechess.managers;


import java.util.Scanner;

public class GameManager {
    Scanner scn = new Scanner(System.in);
    private String input;
    private boolean loop = true;

    PokemonSelectManager pokemonSelectManager = new PokemonSelectManager();

    public void startGame(){
        pokemonSelectManager.askName();
        pokemonSelectManager.showPokemonSelect();
    }

    public void showTitleScreen(){
        System.out.println("POKECHESS UNITE");
        do {
            System.out.print("Type \"START\" to begin: ");
            input = scn.nextLine();
            if (input != "start") {
                System.out.println("ERROR: Game does not recognize input. Try again.");
            } else
                loop = false;
        } while (loop);
        startGame();
    }
}
