package com.pokechess;

import com.pokechess.managers.GameManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Driver {

    public static void main(String[] args){
        GameManager gameManager = new GameManager();
        gameManager.run();
    }
}