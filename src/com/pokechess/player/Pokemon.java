package com.pokechess.player;
package com.pokechess.division;
import com.pokechess.board.Tile;
import com.pokechess.division.Zone;

import java.util.*;
public class Pokemon {
    Zone zone;
    private String name;
    private String battleType = "non";

    private int health;

    private float attack;
    private float defense;
    private int speed;
    private float hpRegen;
    private int revivalRate;

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

//    public void setPokemon(Zone zone, String name){
//        this.name = name;
//        this.zone = zone;
//    }
    public Pokemon setPosition() {

        this.position = position;
    }

    public Zone getZone(){

        return zone;
    }

//    public void setHomeTile(int homeTile){
//        this.homeTile = homeTile;
//    }
//    public void setEnemyTile(int enemyTile){
//        this.enemyTile = enemyTile;
//    }

    public String getName(){
        return name;
    }

    public float getHpRegen() {
        return hpRegen;
    }

    public String getBattleType(){
        return Objects.requireNonNullElse(this.battleType, "non");
    }

//    public boolean pokemonCanHeal(){
//        return heal;
//
//    }
//    public int getHomeTile(){
//        return homeTile;
//    }
//    public int getEnemyTile(){
//        return enemyTile;
//    }

}