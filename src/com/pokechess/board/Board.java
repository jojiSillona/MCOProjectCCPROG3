package com.pokechess.board;

import com.pokechess.player.Pokemon;

public class Board {

    private Pokemon[] homeTeam = new Pokemon[5];
    private Pokemon[] computerTeam = new Pokemon[5];

    private Tile[][] board;
    char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};

    // @param x = number
	 // @param y = alphabet

    // alphabet = lowest row position
    // numbers = rightest column position

    public Board() {
        this.homeTeam = homeTeam;
        this.computerTeam = computerTeam;

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
    public void setZones(Pokemon homePokemon, Pokemon computerPokemon) {

        board[0][0].setCurrPosition(homePokemon);
        board[1][0].setCurrPosition(homePokemon);
        board[2][0].setCurrPosition(homePokemon);
        board[3][0].setCurrPosition(homePokemon);
        board[4][0].setCurrPosition(homePokemon);

        board[0][0].setStartingTilePosition(homePokemon);
        board[1][0].setStartingTilePosition(homePokemon);
        board[2][0].setStartingTilePosition(homePokemon);
        board[3][0].setStartingTilePosition(homePokemon);
        board[4][0].setStartingTilePosition(homePokemon);


        board[0][6].setCurrPosition(computerPokemon);
        board[1][6].setCurrPosition(computerPokemon);
        board[2][6].setCurrPosition(computerPokemon);
        board[3][6].setCurrPosition(computerPokemon);
        board[4][6].setCurrPosition(computerPokemon);

        board[0][6].setStartingTilePosition(homePokemon);
        board[1][6].setStartingTilePosition(homePokemon);
        board[2][6].setStartingTilePosition(homePokemon);
        board[3][6].setStartingTilePosition(homePokemon);
        board[4][6].setStartingTilePosition(homePokemon);
    }

    // Prints out game screen
    public void printBoard(Pokemon[] homePokemon, Pokemon[] computerPokemon) {
        boolean isdisplayed;

        for (int i = 1; i < 36; i++) {
            isdisplayed = false;
            for (int j = 0; j < 5; j++) {
                Pokemon tempP = board[i][j].getCurrPosition();
                if (tempP == null) {
                    if (homePokemon[j].getPosition() == i) {
                        System.out.print("| " + homePokemon[j].getName());
                        isdisplayed = true;
                    }
                    if (computerPokemon[j].getPosition() == i) {
                        System.out.print("| " + computerPokemon[j].getName());
                        isdisplayed = true;
                    }
                }
            }
            if (!isdisplayed) {
                System.out.println("| " + i + " ");
            }
        }
        /* Prints out alphabet */
        for (int i = 0; i < 7; i++) {
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

        if(board[x][y].removePokemon() == null){
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

