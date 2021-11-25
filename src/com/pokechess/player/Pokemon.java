package com.pokechess.player;
import java.util.*;

public class Pokemon {
    private String name;
    private String battleType = "";

    private boolean move = true;

    private int xPos;
    private int yPos;

    private int health;

    private float attack;
    private float defense;
    private int speed;
    private float hpRegen;
    private int revivalRate;

    public Pokemon(String name, String battleType, int health, float attack, float defense, int speed, float hpRegen,
                   int revivalRate) {
        this.name = name;
        this.battleType = battleType;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.hpRegen = hpRegen;
        this.revivalRate = revivalRate;
    }
    /*
    public int move(String direction){
        // int yata to
    }
*/
/*
    public void attack(Pokemon Player){
        // this action inflicts damage to the enemy pokemon

        ArrayList<Integer>movesExecuted = new ArrayList<Integer>(); //create ArrayList for moves still avaliable for use
        Random number = new Random();//choose random number

        for(int i = 0; i < Player.attack(); i++){
            if(attack(Player, i); == true){ // if pokemon has enough energy to perform the attack
                movesExecuted.add(i); //add avaliable attacks to list
                move = true;
            }
        }
        if(movesExecuted.size() == 0){ // if pokemon has no energy to perform any attack (pass)
            move = false;
        }
        int moveoption = number.nextInt(movesExecuted.size()); //choose random moveoptions of avaliable attacks
        return moveoption;
    }
 */
    public void setSpeedster(String direction){
        //


    }
    public void defend(String direction){
        // this action reduces the total damage a pokemon receives from an attack by 20%


    }
    public void heal(String direction){
        // this action is only available to supporters.
        // it lets them heal 20% of their max HP



    }
    public void run(String direction){
        // this action lets the pokemon run away from battle,
        // returning to its home tile, it has 40% chance to succeed


    }

    public String getBattleType(){
        if(this.battleType == null)
            return "";
        else
            return battleType;
    }

}