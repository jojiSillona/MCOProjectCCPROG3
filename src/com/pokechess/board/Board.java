package com.pokechess.board;

import com.pokechess.managers.BoardManager;
import com.pokechess.player.Player;
import com.pokechess.player.Pokemon;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private BoardManager manager;
    private Pokemon[] homeTeam = new Pokemon[5];
    public Pokemon[] computerTeam = new Pokemon[5];

    public Tile[][] board;

    // @param x / ROW = number
    // @param y / COLUMN= alphabet

    // alphabet = lowest row position
    // numbers = rightest column position

    public Board(BoardManager manager) {
        this.manager = manager;
        createBoard();
    }

    // Blank board template
    public void createBoard() {
        board = new Tile[5][7];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = new Tile(i, j);
            }
        }
    }

    // Adds pokemons on respective zones
    public void setZones(Pokemon[] homePokemon, Pokemon[] computerPokemon) {
        int i;
        for(i = 0; i < 5; i++){
            this.board[i][0].setCurrPosition(homePokemon[i]);
            this.board[i][0].setStartingTilePosition(homePokemon[i]);
        }

        for(i = 0; i < 5; i++){
            this.board[i][6].setCurrPosition(computerPokemon[i]);
            this.board[i][6].setStartingTilePosition(computerPokemon[i]);
        }
    }

    public void movePokemon(Tile current, Tile destinationTile){
        destinationTile.setCurrPosition(current.getCurrPosition());
        current.removePokemon();
    }

    public boolean emptyTile(int x, int y){
        if(this.board[y][x].getCurrentPokemonName().equals("non")){
            return true;
        }

        return false;
    }


    public void moveComputer(Player computer){
        int randomPokemon = ThreadLocalRandom.current().nextInt(0, 5);


        Pokemon selectedPokemon = computer.getPokemon(randomPokemon);
        Position enemyPokemonPosition = selectedPokemon.getPosition();

        manager.castPossibleMove(selectedPokemon);
        int randomPosition = ThreadLocalRandom.current().nextInt(0, manager.possibleMoves.size() - 1);
        Position destinationTile = manager.possibleMoves.get(randomPosition);

        this.board[destinationTile.getRow()][destinationTile.getColumn()].
                setCurrPosition(this.board[enemyPokemonPosition.getRow()][enemyPokemonPosition.getColumn()].getCurrPosition());
        this.board[enemyPokemonPosition.getRow()][enemyPokemonPosition.getColumn()].removePokemon();
    }



    // Checks if input is out of range
    public boolean outOfRange(int x, int y){

        if(x < 0 || x > 6)
            return true;
        if(y < 0 || y > 4)
            return true;

        return false;
    }

    // Gets the tile position
    public Tile getTile(int x, int y){

        return this.board[x][y];
    }

}

