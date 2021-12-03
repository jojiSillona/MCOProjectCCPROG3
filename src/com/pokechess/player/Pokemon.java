package com.pokechess.player;

import com.pokechess.board.Position;

import java.util.*;
public class Pokemon {
    private String name;
    private String battleType = "non";
    private boolean move = true;

    private int health;

    private boolean pokemonHeal;
    private float attack;
    private float defense;
    private int speed;
    private float hpRegen;
    private int revivalRate;

    private int startTile;
    private Position position;

    public Pokemon(String name, int health, float attack, float defense, int speed, float hpRegen,
                   int revivalRate) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.hpRegen = hpRegen;
        this.revivalRate = revivalRate;
    }

    public void setBattleType(String bt){
        this.battleType = bt;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public Position getPosition(){
        return position;
    }

    public void setStartingTile(int startTile){
        this.startTile = startTile;
    }
    public int getStartingTile(int startTile){
        return startTile;
    }

    public float getHpRegen() {

        return hpRegen;
    }

    public int getMaxHp() {

        return health;
    }

    public boolean pokemonHeal(){
        return pokemonHeal;
    }

    public String getName(){
        return name;
    }

    public String getBattleType(){
        return Objects.requireNonNullElse(this.battleType, "non");
    }

    public int getSpeed(){
        return speed;
    }

//    public boolean pokemonCanHeal(){
//        return heal;
//
//    }

}