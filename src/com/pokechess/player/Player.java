package com.pokechess.player;

import java.util.Scanner;

public class Player {
    private String name;
    private int moves;

    private Pokemon[] pokemonTeam = new Pokemon[5];
    private int choice;
    private boolean loop = true;

    Scanner scn = new Scanner(System.in);
/*
    public void commandPokemon(){
        for(moves = 0; moves < 3; moves++){
            do {
                System.out.println("Pick a character:");
                for (int i = 0; i < 5; i++) {
                    //System.out.println((i + 1) + ": " + pokemonTeam[i].getName());
                }
                System.out.print("Select: ");
                choice = scn.nextInt();
                if (choice > 5 || choice < 0) {
                    System.out.println("Invalid Input. Please try again.");
                }
                else {
                    loop = false;
                }
            } while(loop);
        }
    }
*/
    public String getType(int index){
        if(pokemonTeam[index].getBattleType() == null)
            return "non";
        else
            return pokemonTeam[index].getBattleType();
    }

    public void setName(String name){
        this.name = name;
    }

    public void addPokemon(int index, String name, String bt, int hp, float atk, float def, int spd,
                           float hpReg, int revRate){
        pokemonTeam[index] = new Pokemon(name, hp, atk, def, spd, hpReg, revRate);
        pokemonTeam[index].setBattleType(bt);
    }
}
