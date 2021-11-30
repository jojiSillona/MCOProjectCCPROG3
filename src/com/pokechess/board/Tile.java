package com.pokechess.board;

import com.pokechess.player.Pokemon;
import com.pokechess.player.Position;

public class Tile {

    Position alphaNum;
    Pokemon currPokemonPos;

    public Tile(int number, char alphabet){
        createPosition(number, alphabet);
        currPokemonPos = null;
    }

    private void createPosition(int number, char alphabet){

        int ialpha = 0;

        /* Char file to integer file */

        switch(alphabet) {

            case 'a':
                ialpha = 0;
                break;
            case 'b':
                ialpha = 1;
                break;
            case 'c':
                ialpha = 2;
                break;
            case 'd':
                ialpha = 3;
                break;
            case 'e':
                ialpha = 4;
                break;
            case 'f':
                ialpha = 5;
                break;
            case 'g':
                ialpha = 6;
                break;
            case 'h':
                ialpha = 7;
                break;
        }
        alphaNum = new Position(number, ialpha);
    }

    public void setPokemon(Pokemon newPokemonPos){
        currPokemonPos = newPokemonPos;
        newPokemonPos.setPosition(this);
    }

    public Pokemon getPokemon(){

        return currPokemonPos;
    }

    public Pokemon removePokemon(){
        Pokemon temp = currPokemonPos;
        currPokemonPos = null;
        temp.setPosition(null);
        return temp;
    }

    public int getNumber(){
        return alphaNum.getNumber();
    }

    public int getAlphabet(){
        return alphaNum.getAlphabet();
    }
}
