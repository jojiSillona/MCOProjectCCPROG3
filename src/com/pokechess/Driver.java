package com.pokechess;

import com.pokechess.managers.GameManager;

// import javax.swing.*;
// import java.awt.*;

public class Driver {
    private static void main(String[] args){
        GameManager gameManager = new GameManager();
        gameManager.run();
    }
    // 1st column = purple
    // 2nd - 6th = white
    // 7th = orange
}