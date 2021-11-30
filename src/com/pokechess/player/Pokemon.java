package com.pokechess.player;

public class Pokemon {
    private String name;

    private int position;
    private int homeTile;
    private int enemyTile

    private PokemonBattleType battleType;


    public Pokemon(String name, PokemonBattleType battleType) {
        this.battleType = battleType;
        this.name = name;
    }

    public String getPokemonName(){
        return name;
    }
    public int getPosition{
        return position;
    }
    public void setHomeTile(int homeTile){
        this.homeTile = homeTile;
    }
    public void setHomeTile(int homeTile){
        this.homeTile = homeTile;
    }
    public void getHomeTile(){
        return homeTile;
    }
    public int getEnemyTile(){
        return enemyTile;
    }


}