package com.pokechess.player;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Player {
    private String name;
    private int points;
    private int boardCommands;

    private final Pokemon[] pokemonTeam = new Pokemon[5];
    private boolean loop = true;


    public Player(){
        for(int i = 0; i < 5; i++)
            this.pokemonTeam[i] = new Pokemon("non", 0, 0  , 0, 0, 0, 0, false);
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

    public int getPoints(){
        return points;
    }

    public void setPoints(int addPoint){
        this.points = addPoint;
    }

    public String getPlayerName(){
        return name;
    }

    public int getBoardCommands(){
        return boardCommands;
    }

    public void addPokemon(int index, String name, String bt, int hp, float atk, float def, int spd,
                           float hpReg, int revRate, int user, boolean isEnemy){
        pokemonTeam[index] = new Pokemon(name.toUpperCase(Locale.ROOT), hp, atk, def, spd, hpReg, revRate, isEnemy);
        pokemonTeam[index].setBattleType(bt);
    }

    public void addPokemon(String name, String bt, int hp, float atk, float def, int spd,
                           float hpReg, int revRate, int user, boolean isEnemy){
        pokemonTeam[0] = new Pokemon(name.toUpperCase(Locale.ROOT), hp, atk, def, spd, hpReg, revRate, isEnemy);
        pokemonTeam[0].setBattleType(bt);
    }

    public Pokemon[] getPokemonTeam(){
        return Arrays.copyOf(pokemonTeam, pokemonTeam.length);
    }
    public Pokemon  getPokemon(int index){
        return pokemonTeam[index];
    }
}

