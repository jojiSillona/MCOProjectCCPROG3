package com.pokechess.managers;

import com.pokechess.player.Player;

import java.util.Objects;
import java.util.Scanner;

public class PokemonSelectManager {
    Scanner scn = new Scanner(System.in);
    private String input;

    BoardManager mainGame = new BoardManager();
    Player player = mainGame.player;

    public void addPokemonToTeam(int i, String name, String battleType){
        String batTypeDisp = "";
        int h = 0;
        float at = 0;
        float de = 0;
        int sp = 0;
        float hR = 0;
        int rR = 0;
        switch (battleType) {
            case "atk" -> {
                batTypeDisp = "Attacker";
                h = 75;
                at = (float) 0.4;
                de = (float) 0.15;
                sp = 2;
                hR = (float) 0.05;
                rR = 2;
            }
        }
        player.addPokemon(i, name, batTypeDisp, h, at, de, sp, hR, rR);
    }

    public boolean hasMaxType(String input){
        int i = 0;
        int count = 0;

        while(!Objects.equals(player.getType(i), "") || i < 5 || count < 2){
            if(input.equals(player.getType(i)))
                count++;
            i++;
        }
        return count == 2;
    }

    public String identifyBattleType(String input){
        String battleType = "";
        switch (input) {
            case "Sylveon", "Gardevoir", "Pikachu" -> battleType = "atk";
            case "Zeraora", "Talonflame", "Absol" -> battleType = "spd";
            case "Charizard", "Lucario", "Machamp" -> battleType = "alr";
            default -> System.out.println("ERROR: Game does not recognize " + input + ". Please try again.");
        }
        return battleType;
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
            if(!hasMaxType(identifyBattleType(input))){
                addPokemonToTeam(i, input, identifyBattleType(input));
            }
        }
    }
    public void askName(){
        System.out.print("Type your name:");
        input = scn.nextLine();
        player.setName(input);
    }
}
