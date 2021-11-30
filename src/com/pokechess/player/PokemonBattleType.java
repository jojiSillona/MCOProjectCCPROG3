package com.pokechess.player;

public class PokemonBattleType {
    private String battleType;

    private int hp;
    private float hpRegen;
    private int speed;
    private boolean heal;


    public PokemonBattleType(String battleType, int hp, float hpRegen, int speed, boolean heal){
        this.battleType = battleType;
        this.hp = hp;
        this.hpRegen = hpRegen;
        this.speed = speed;
        this.heal = heal;
    }

    public String getBattleType(){
        return this.battleType;
    }

    public int getHp() {
        return hp;
    }

    public boolean pokemonCanHeal(){
        return heal;

    }

}
