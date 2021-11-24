package com.pokechess.managers;
import com.pokechess.player.Pokemon;

import java.util.Scanner;

public class PokemonSelectManager {

    private String choice;
    Scanner scn = new Scanner(System.in);
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
        System.out.print("Type the Pokemon's name to add to your team: ");
        choice = scn.nextLine();
    }
    public void displayScreen(){
        System.out.println("SELECT CHARACTER");
        System.out.println("====ATTACKERS====");
        System.out.println("1.SYLVEON\n2.GARDEVOIR\n3.PICACHU");
        System.out.println("====SPEEDSTERS====");
        System.out.println("1.ZERAORA\n2.TALONFLAME\n3.ABSOL");
        System.out.println("====ALL-ROUNDERS====");
        System.out.println("1.CHARIZARD\n2.LUCARIO\n3.MACHAMP");

    }
}
