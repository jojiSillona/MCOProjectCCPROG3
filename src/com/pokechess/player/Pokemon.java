package com.pokechess.player;

import com.pokechess.board.Position;

import java.util.*;
public class Pokemon {
    private String name;
    private String battleType = "non";
    private boolean move = true;

    private int maxHealth;
    private int currentHealth;

    private boolean pokemonHeal;
    private float attack;
    private float defense;
    private int speed;
    private float hpRegen;
    private int revivalRate;
    private boolean isEnemy;
    private boolean defendProtected = false;

    private int carriedPoints;

    private Position position;

    public Pokemon(String name, int health, float attack, float defense, int speed, float hpRegen,
                   int revivalRate, boolean isEnemy) {
        this.name = name;
        this.maxHealth = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.hpRegen = hpRegen;
        this.revivalRate = revivalRate;
        this.isEnemy = isEnemy;
        this.currentHealth = maxHealth;
    }

    public boolean getIsEnemy(){
        return isEnemy;
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

    public float getHpRegen() {

        return hpRegen;
    }

    public int getMaxHp() {

        return maxHealth;
    }
    public int getCurrentHealth(){
        return currentHealth;
    }

    public boolean pokemonHeal(){
        return pokemonHeal;
    }

    public void setProtection(boolean toggle){
        this.defendProtected = toggle;
    }

    public boolean isDefendProtected(){
        return defendProtected;
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

    public int getCarriedPoints(){
        return carriedPoints;
    }

    public void setCarriedPoints(int addPoint){
        this.carriedPoints = addPoint;
    }

    public float getAttack(){
        return attack;
    }

    public float getDefense(){
        return defense;
    }

    public void setCurrentHealth(int health){
        this.currentHealth = health;
    }


}