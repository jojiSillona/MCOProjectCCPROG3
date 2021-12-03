

package com.pokechess.board;
import com.pokechess.player.Pokemon;

public class Tile {
    /*
    PLEASE REMEMBER THE FOLLOWING
    -ALPHABET CORRESPONDS TO X POSITION
    -NUMBER CORRESPONDS TO Y POSITION
     */
    Position alphaNum;
    Pokemon currPokemonPos ;
    Pokemon startTile;

    private boolean move;

    public Tile(int x, int y ){
        createPosition(x, y);
    }

    private void createPosition(int x, int y){
        alphaNum = new Position(x, y);
        currPokemonPos = null;
    }

    public void showTileMovePossible(){
        this.move = true;
    }

    public boolean moveTrue(){
        return move;
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
