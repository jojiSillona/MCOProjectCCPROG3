package com.pokechess.managers;

import com.pokechess.player.Player;

import java.util.Locale;
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
                batTypeDisp = "atk";
                h = 75;
                at = (float) 0.4;
                de = (float) 0.15;
                sp = 2;
                hR = (float) 0.05;
                rR = 2;
            }
            case "spd" -> {
                batTypeDisp = "spd";
                h = 50;
                at = (float) 0.4;
                de = (float) 0.05;
                sp = 3;
                hR = (float) 0.05;
                rR = 2;
            }
            case "alr" -> {
                batTypeDisp = "alr";
                h = 75;
                at = (float) 0.3;
                de = (float) 0.15;
                sp = 2;
                hR = (float) 0.1;
                rR = 3;
            }
        }
        player.addPokemon(i, name, batTypeDisp, h, at, de, sp, hR, rR);
    }



    public String identifyBattleType(String input){
        String battleType = "";
        switch (input.toUpperCase(Locale.ROOT)) {
            case "SYLVEON", "GARDEVOIR", "PIKACHU" -> battleType = "atk";
            case "ZERAORA", "TALONFLAME", "ABSOL" -> battleType = "spd";
            case "CHARIZARD", "LUCARIO", "MACHAMP" -> battleType = "alr";
            default -> System.out.println("ERROR: Game does not recognize " + input + ". Please try again.");
        }
        return battleType;
    }

    public boolean hasMaxType(String input, int size){
        int i = 0;
        int count = 0;

        while(i < size || count < 2){
            if(Objects.equals(identifyBattleType(input), player.getType(i)))
                count++;
            i++;
        }
        return count == 2;
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

            boolean loop = true;
            do{
                System.out.print("Input Pokemon #" + i + ": ");
                input = scn.nextLine();
                if(!Objects.equals(identifyBattleType(input), "non")){
                    if(!hasExistPokemon(input, i)) {
                        if (i > 1) {
                            if (hasMaxType(input, i))
                                System.out.println("You cannot add this!");
                             else
                                loop = false;
                        }
                        else
                            loop = false;
                    }
                }
                else
                    loop = false;
            } while(loop);

            addPokemonToTeam(i, input, identifyBattleType(input.toUpperCase(Locale.ROOT)));
        }
    }
    public void askName(){
        System.out.print("Type your name: ");
        input = scn.nextLine();
        player.setName(input);
    }
}
