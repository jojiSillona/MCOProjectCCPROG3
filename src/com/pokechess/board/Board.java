package com.pokechess.board;

public class Board {
    // private Tile[][] tiles = new Tile[5][7];
    private char[][] board;

    public Board() {
        board = new char[5][7];
        initialization();
    }

    public void initialization() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {

        System.out.println("-----------------------------------");
        for (int i = 0; i < 5; i++) {
            System.out.print("| ");
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("------------------------------");
        }
    }
}

