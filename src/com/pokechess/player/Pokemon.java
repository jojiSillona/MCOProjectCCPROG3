package com.pokechess.player;
import java.util.*;

public class Pokemon {
    private String name;
    private String battleType;

    private boolean move = true;

    private int xPos;
    private int yPos;

    private int health;
    private int maxHealth;
    private float aAttack;
    private float totalDamage, attackDamage;

    private float defense, defenseBuffer, rDefense;
    private int speed;
    private float rHP, rNewHP, dRNewHP;



    private int revivalRate;

    public Pokemon(String name, String battleType, float rHP, float rNewHP,
                   float dRNewHP, int speed, float rDefense, ArrayList<int>aAttacks) {

        this.name = name;
        this.battleType = battleType;

        this.aAttack = aAttack; // Attack stat of the attacker
        this.defense = rDefense; // Defense stat of the receiver

        this.totalDamage = attackDamage - defenseBuffer;

        this.attackDamage = (rHP * aAttack%);
        this.defenseBuffer = (attackDamage * rDefense%);

        this.rHP = rHP; // HP stat of the receiver

        this.rNewHP = rHP - totalDamage; // Receiver's new HP from attack,

        this.dRNewHP = rHP - (totalDamage * 0.8); // Receiver's new HP from defend


        //rNewHP = rHP - ⌈(totalDamage * 0.8)⌉
        // this.rHP = rNewHP // current health of pokemon
        // totalDamage = attackDamage - defenseBuffer
        // attackDamage = ⌈(rHP * aAttack%)⌉
        // defenseBuffer = ⌈(attackDamage * rDefense%)


    }
    public int move(String direction){
        // int yata to


    }


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
    public void setSpeedster(String direction){


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

}