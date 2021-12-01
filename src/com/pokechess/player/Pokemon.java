package com.pokechess.player;

import com.pokechess.board.Tile;

import java.util.*;
public class Pokemon {
    private String name;
    private String battleType = "non";
    private boolean move = true;

    private int xPos;
    private int yPos;

    private int health;

    private float attack;
    private float defense;
    private int speed;
    private float hpRegen;
    private int revivalRate;

    private int startTile;
    private int position;

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

    public void setPosition(Tile position){
        this.position = position;
    }

    public int getPosition(){

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
    public void setPosition(int posX, int posY){
        this.xPos = posX;
        this.yPos = posY;
    }

    public String getName(){
        return name;
    }

    public String getBattleType(){
        return Objects.requireNonNullElse(this.battleType, "non");
    }

//    public boolean pokemonCanHeal(){
//        return heal;
//
//    }

}