package com.pokechess.board;

import com.pokechess.player.Pokemon;

public final class Board {

    private Pokemon[] homeTeam = new Pokemon[5];
    private Pokemon[] computerTeam = new Pokemon[5];

    public Tile[][] board;
    char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};

    // @param x = number
    // @param y = alphabet

    // alphabet = lowest row position
    // numbers = rightest column position

    public Board() {
        createBoard();
    }

    // Blank board template
    public void createBoard() {
        board = new Tile[5][7];
        //System.out.println("-----------------------------------");
        for (int i = 0; i < 5; i++) {
            //System.out.print(i);
            for (int j = 0; j < 7; j++) {
                board[i][j] = new Tile(i, j);
            }
            //System.out.println();
            //System.out.println("------------------------------");
        }
    }

    // Adds pokemons on respective zones
    public void setZones(Pokemon[] homePokemon, Pokemon[] computerPokemon) {
        int i;
        for(i = 0; i < 5; i++){
            board[i][0].setCurrPosition(homePokemon[i]);
            board[i][0].setStartingTilePosition(homePokemon[i]);
        }

        for(i = 0; i < 5; i++){
            board[i][6].setCurrPosition(computerPokemon[i]);
            board[i][6].setStartingTilePosition(computerPokemon[i]);
        }
    }

    public void movePokemon(Tile current, Tile destinationTile){
        destinationTile.setCurrPosition(current.getCurrPosition());
        current.removePokemon();
    }

    // Prints out game screen
    public void printBoard(Pokemon[] homePokemon, Pokemon[] computerPokemon) {
        for(int x = 0; x < 5; x++){
            System.out.println("----------------------------------------------------");
            for (int y = 0; y < 7; y++){
                Pokemon pokeOnTile = board[x][y].getCurrPosition();
                if(pokeOnTile.getName() != "non"){
                    System.out.print("|" + pokeOnTile.getName() + "\t");
                }
                else {
                    System.out.print("| " + board[x][y].getAlphabet() + board[x][y].getNumber());
//                    if(board[x][y].moveTrue())
//                        System.out.print("!");
//                    System.out.print("\t");
                }
            }
            System.out.print("\n");
        }
        System.out.println("----------------------------------------------------");
    }

    // Checks if spot is empty on gameboard
    public boolean emptyTile(int x, int y){
        if(board[x][y].getCurrentPokemonName() == "non"){
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

    public void tileIDToPos(int tileID){
        int x;
        int y;
        switch(tileID){
            case 0 -> {
                x = 0;
                y = 0;
            }
        }
    }

}

