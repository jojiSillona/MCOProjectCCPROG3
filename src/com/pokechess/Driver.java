package com.pokechess;

import com.pokechess.board.Board;
import com.pokechess.managers.BoardManager;
import com.pokechess.managers.GameManager;

public class Driver {
    public static void main(String[] args){
        GameManager gameManager = new GameManager();
        gameManager.showTitleScreen();
        gameManager.showBoard();
    }
}