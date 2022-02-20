

package com.pokechess.board;
import com.pokechess.player.Pokemon;

public class Tile {
    /*
    PLEASE REMEMBER THE FOLLOWING
    -ALPHABET CORRESPONDS TO X POSITION
    -NUMBER CORRESPONDS TO Y POSITION
     */
    public Position alphaNum;
    public Pokemon currPokemonPos ;
    public Pokemon startTile;

    private boolean move;

    public Tile(int x, int y ){
        createPosition(x, y);
        currPokemonPos = new Pokemon("non", 0, 0 ,0,0,0,0, false);
    }

    private void createPosition(int x, int y){
        alphaNum = new Position(x, y);

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

    public void removePokemon(){
        currPokemonPos = new Pokemon("non", 0, 0 ,0,0,0,0, false);
    }

    public int getNumber(){
        return alphaNum.getRow();
    }

    public int getAlphabet(){
        return alphaNum.getColumn();
    }

    public String getCurrentPokemonName(){
        return currPokemonPos.getName();
    }

    public Position getAlphaNum(){
        return alphaNum;
    }
}
