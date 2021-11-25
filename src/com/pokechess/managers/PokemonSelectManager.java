package com.pokechess.managers;

import com.pokechess.player.Player;

import java.util.Scanner;

public class PokemonSelectManager {
    Scanner scn = new Scanner(System.in);
    private String input;

    private Player player;

    public void addPokemonToTeam(String name, String battleType){
        //switch (battleType)
    }

    public boolean hasMaxType(String input){
        String battleType = "";
        int i = 0;
        int count = 0;


        switch(input){
            case "Sylveon", "Gardevoir", "Pikachu":
                battleType = "atk";
            default:
                System.out.println("ERROR: Game does not recognize "+ input + ". Please try again.");
        }
        while(player.getType(i) != "" || i < 5){
            if(battleType == player.getType(i))
                count++;
        }
        if(count == 2)
            return true;
        else
            return false;
    }

    public void showPokemonSelect(){
        System.out.println("SELECT YOUR POKEMON:");
        System.out.println("ATTACKERS:");
        System.out.println("1. Sylveon\n2.Gardevoir\n3.Pikachu");
        System.out.println("SPEEDSTERS:");
        System.out.println("1. Zeraora\n2.Talonflame\n3.Absol");
        System.out.println("ALL-ROUNDERS:");
        System.out.println("1. Charizard\n2.Lucario\n3.Machamp");
        for(int i = 0; i < 5; i++){
            System.out.print("Input their name:");
            input = scn.nextLine();
            if(!hasMaxType(input)){

            }

        }

    }
    public void askName(){
        System.out.print("Type your name:");
        input = scn.nextLine();
        player.setName(input);
    }
}
