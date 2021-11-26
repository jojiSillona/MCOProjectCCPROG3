package com.pokechess.managers;


import java.util.Objects;
import java.util.Scanner;

public class GameManager {
    Scanner scn = new Scanner(System.in);
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
            String input = scn.nextLine();
            if (input.equalsIgnoreCase("START"))
                loop = false;
            else if (input.equalsIgnoreCase("EXIT"))
                System.exit(0);
            else
                System.out.println("ERROR: Game does not recognize input. Try again.");
        } while (loop);
        startGame();
    }
}
