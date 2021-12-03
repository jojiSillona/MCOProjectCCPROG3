

package com.pokechess.board;
import com.pokechess.player.Pokemon;

public class Tile {
    /*
    PLEASE REMEMBER THE FOLLOWING
    -ALPHABET CORRESPONDS TO X POSITION
    -NUMBER CORRESPONDS TO Y POSITION
     */
    Position alphaNum;
    Pokemon currPokemonPos;
    Pokemon startTile;

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
        }
        alphaNum = new Position(number, ialpha);
    }

    public void setCurrPosition(Pokemon newPokemonPos){
        this.currPokemonPos = newPokemonPos;
        newPokemonPos.setPosition(alphaNum);
    }

    public Pokemon getCurrPosition(){
        return currPokemonPos;
    }

    public void setStartingTilePosition(Pokemon newStartTile){
        startTile = newStartTile;
        newStartTile.setPosition(alphaNum);
    }
    public Pokemon getStartingTilePosition(){
        return startTile;
    }

    public Pokemon removePokemon(){
        Pokemon temp = currPokemonPos;
        currPokemonPos = null;
        temp.setPosition(alphaNum);
        return temp;
    }

    public int getNumber(){
        return alphaNum.getNumber();
    }

    public int getAlphabet(){
        return alphaNum.getAlphabet();
    }
}
