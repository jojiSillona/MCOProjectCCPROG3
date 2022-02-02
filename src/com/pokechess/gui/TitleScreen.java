package com.pokechess.gui;

import com.pokechess.model.loaders.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class TitleScreen extends JPanel implements MouseListener {

    private BufferedImage logo;
    private Button startButton;

    public TitleScreen(Frame frame){
        this.setVisible(true);
        this.setSize(frame.getSize());
        this.setLayout(null);

        this.initComponents();

        this.add(this.startButton);
    }

    private void initComponents(){

        String path2 = ImageLoader.BUTTON_IDLE;
        ImageIcon imageIcon = ImageLoader.loadImageIcon(path2, 300);
        this.startButton = new Button(imageIcon, this);
        Guide.centerHorizontally(this, this.startButton);
        this.startButton.setLocation(this.startButton.getX(), 400);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
