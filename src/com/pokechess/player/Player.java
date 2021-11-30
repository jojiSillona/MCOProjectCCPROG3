
package com.pokechess.player;
import java.util.Scanner;


public class Player {
    private Pokemon[] pokemonTeam = new Pokemon[5];
    private int choice;
    private boolean loop = true;

    Scanner scan = new Scanner(System.in);

    public Player(){
        for(int i = 0; i < pokemonTeam.length; i++){
            pokemonTeam[i] = new Pokemon(name: " ", new PokemonBattleType(battleType: " ", hp: 0 )
        }
    }
}

