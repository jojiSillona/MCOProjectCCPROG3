package com.pokechess.managers;

import java.util.Scanner;

public class GameManager {
    private PokemonSelectManager pokemonSelectManager;

    public GameManager(){
        this.pokemonSelectManager = new PokemonSelectManager();

    }
    /*
        Title screen input loop (will reprint title screen and ask for a valid user input)
    */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String input;
        do{
            this.displayScreen();
            input = scanner.nextLine();
            input = input.toUpperCase();
        } while(!this.isValid(input));
        this.processInput(input);
        // this.pokemonSelectManager.run();
    }

    /*
       Returns true if the input contains "START" or "EXIT"
       and returns false if not
    */
    private boolean isValid(String input){

        switch(input) {
            case "START":
            case "EXIT GAME":
                return true;
            default:
                return false;
        }
    }
    /*
        Processes input and launches pokemon select screen
     */
    private void processInput(String input){

        switch(input) {
            case "START":
                this.pokemonSelectManager.run();
                break;
            case "EXIT GAME":
                System.exit(0);
                break;
        }
    }
    private void displayScreen(){
        System.out.println("\n\n\n POKECHESS GAME \n\n\n");
        System.out.println("\n\n\n [USER INPUT]:  ");

    }

}
