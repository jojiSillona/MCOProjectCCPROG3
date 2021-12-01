package com.pokechess.player;

import java.util.Scanner;

public class Player {
    private String name;
    private int moves;

    private final Pokemon[] pokemonTeam = new Pokemon[5];
    private int choice;
    private boolean loop = true;

    Scanner scn = new Scanner(System.in);

    public Player(){
        for(int i = 0; i < 5; i++)
            this.pokemonTeam[i] = new Pokemon("non", 0, 0  , 0, 0, 0, 0);
    }

    public String getType(int index){
        if(pokemonTeam[index].getBattleType() == null)
            return "non";

        else
            return pokemonTeam[index].getBattleType();
    }

    public String getName(int index){
        return pokemonTeam[index].getName();
    }

    public void setName(String name){
        this.name = name;
    }

    public void addPokemon(int index, String name, String bt, int hp, float atk, float def, int spd,
                           float hpReg, int revRate, int user){
        pokemonTeam[index] = new Pokemon(name, hp, atk, def, spd, hpReg, revRate);
        pokemonTeam[index].setBattleType(bt);
        pokemonTeam[index].setPosition(user, index);
    }
}

