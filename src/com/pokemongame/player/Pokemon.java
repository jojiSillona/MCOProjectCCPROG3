package com.pokemongame.player;

public class Pokemon {
    private String name;
    private String battleType;

    private int xPos;
    private int yPos;

    private int health;
    private float attack;
    private float defense;
    private int speed;
    private int hpRegen;
    private int revivalRate;

    public Pokemon(String name, String battleType){
        this.name = name;
        this.battleType = battleType;
    }

    public void move(String direction){

    }

    public void attack(){

    }
}
