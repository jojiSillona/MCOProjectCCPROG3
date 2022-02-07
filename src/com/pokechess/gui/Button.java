package com.pokechess.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class Button extends JButton {

    private ImageIcon buttonImage;

    public Button(ImageIcon buttonImage, MouseListener listener){

        this.setVisible(true);
        this.setContentAreaFilled(false);
        this.setBorder(null);
        this.setOpaque(false);
        this.setMargin(new Insets(0, 0, 0 ,0));

        this.buttonImage = buttonImage;
        this.setIcon(this.buttonImage);

        this.setSize(this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
        this.addMouseListener(listener);
    }

    public void changeImageIcon(ImageIcon altButtonImage){
        this.buttonImage = altButtonImage;
        this.setIcon(this.buttonImage);
    }

    public ImageIcon getImageIcon(){
        return this.buttonImage;
    }
}
