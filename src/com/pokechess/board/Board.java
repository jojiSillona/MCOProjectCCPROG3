package com.pokechess.board;

import com.pokechess.board.Tile;
import com.pokechess.division.Zone;
import com.pokechess.managers.PokemonSelectManager;
import com.pokechess.player.Player;
import com.pokechess.player.Pokemon;

public class Board {
    private Tile[][] board;
    char[] alphabet = { 'a','b','c','d','e','f','g'};

    // alphabet = lowest row position
    // numbers = rightest column position

    public Board(){
        createBoard();
    }

    // Blank board template
    public void createBoard() {
        board = new Tile[5][7];
        System.out.println("-----------------------------------");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = new Tile(i, alphabet[j]);
            }
            System.out.println();
            System.out.println("------------------------------");
        }
    }

    // Adds pokemons on respective zones
    public void addPokemon(Pokemon pokemon) {
        Zone playerZone = pokemon.getZone();
        Pokemon tempP;

        if (playerZone == Zone.EnemyTile) { // No random generator yet
            for (int i = 0; i < 5; i++) {
                board[i][6].setPokemon(pokemon);
            }
        } else {
            for (int i = 0; i < 5; i++) {
                // tempP = new ___(Zone.HomeZone) // Player's selected pokemon
                board[i][0].setPokemon(pokemon);
            }
        }
    }

    // Prints out board on game screen
     public void printBoard(){

         // Prints board and numbers on rightmost column
          for(int i = 4; i > -1; i--){
               for(int j = 0; j < 7; j++){
                   Pokemon tempP = board[i][j].getPokemon();
                 if(tempP == null){
                       if(board[i][j].alphaNum = Zone.HomeTile){
                           System.out.print("   ");
                       }
                   }
                 else if((tempP == PokemonSelectManager.hasExistPokemon("SYLVEON",1))){
                        if(tempP.getZone() == Zone.EnemyTile){
                            System.out.print(" eSYL"); // Enemy's pokemon
                        }
                        else if(tempP.getZone() == Zone.HomeTile){
                            System.out.print(" hSYL"); // Home's pokemon
                        }
                    }
                 else if((tempP instanceof // insert pokemon )){
                        if(tempP.getZone() == Zone.EnemyZone){
                        System.out.print(" eNameofPokemon"); // Enemy's pokemon
                        }
                        else {
                        System.out.print(" hNameofPokemon"); // Player's pokemon
                    }
                }
                else if((tempP instanceof insert pokemon)){
                    if(tempP.getZone() == Zone.EnemyZone){
                        System.out.print(" eNameofPokemon");
                    }
                    else {
                        System.out.print(" hNameofPokemon");
                    }
                }
                else if((tempP instanceof insert pokemon)){
                    if(tempP.getZone() == Zone.EnemyZone{
                        System.out.print(" eNameofPokemon");
                    }
                    else {
                        System.out.print(" hNameofPokemon");
                    }
                }
                else if((tempP instanceof insert pokemon)){
                    if(tempP.getZone() == Zone.EnemyZone){
                        System.out.print(" eNameofPokemon");
                    }
                    else {
                        System.out.print(" hNameofPokemon");
                    }
                }
                else if((tempP instan ceof insert pokemon)){
                    if(tempP.getZone() == Zone.EnemyZone){
                        System.out.print(" eNameofPokemon");
                    }
                    else {
                        System.out.print(" hNameofPokemon");
                    }
                }
            }
            System.out.println(" " + (i + 1));
        }

        /* Prints out alphabet */
        for(int i = 0; i < 7; i++){
            System.out.print("  " + alphabet[i]);
        }
        System.out.println();
    }

    // Checks if spot is empty on gameboard
    public boolean emptyTile(int x, int y){

        if(x < 0 || x > 4)
            return true;

        if(y < 0 || y > 6)
            return true;

        if(board[x][y].getPokemon() == null){
            return true;
        }

        return false;
    }

    // Checks if input is out of range
    public boolean outOfRange(int x, int y){

        if(x < 0 || x > 4)
            return true;
        if(y < 0 || y > 6)
            return true;

        return false;
    }

    // Gets the tile position
    public Tile getTile(int x, int y){

        return board[x][y];
    }

}

