package com.pokechess.gui;

import com.pokechess.managers.TitleScreenManager;
import com.pokechess.model.loaders.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TitleScreen extends JPanel implements MouseListener {

    private TitleScreenManager programManager;
    private JLabel logo;
    private Button startButton;
    private JLabel background;
    private JLabel startText;

    public TitleScreen(TitleScreenManager programManager, Frame frame){
        this.programManager = programManager;
        this.setVisible(true);
        this.setSize(frame.getSize());
        this.setLayout(null);

        this.initComponents();
        this.add(this.startText);
        this.add(this.startButton);
        this.add(this.logo);
        this.add(this.background);
    }

    private void initComponents(){
        String path1 = ImageLoader.LOGO;
        String path2 = ImageLoader.BUTTON_IDLE;
        String path3 = ImageLoader.BG_TITLE;

        this.startText = new JLabel("Start", SwingConstants.CENTER);
        Font f = new Font("Arial", Font.BOLD, 20);
        this.startText.setFont(f);
        this.startText.setForeground(Color.WHITE);
        this.startText.setVisible(true);
        this.startText.setSize(100, 30);
        Guide.centerHorizontally(this, this.startText);
        this.startText.setLocation(this.startText.getX(), 433);

        ImageIcon imageIcon1 = ImageLoader.loadImageIcon(path1, 500);
        this.logo = new JLabel(imageIcon1);
        this.logo.setVisible(true);
        this.logo.setSize(imageIcon1.getIconWidth(), imageIcon1.getIconHeight());
        Guide.centerHorizontally(this, this.logo);
        this.logo.setLocation(this.logo.getX(),100);

        ImageIcon imageIcon2 = ImageLoader.loadImageIcon(path2, 300);
        this.startButton = new Button(imageIcon2, this);
        Guide.centerHorizontally(this, this.startButton);
        this.startButton.setLocation(this.startButton.getX(), 400);

        ImageIcon imageIcon3 = ImageLoader.loadImageIcon(path3, 1400);
        this.background = new JLabel(imageIcon3);
        this.background.setVisible(true);
        this.background.setSize(imageIcon3.getIconWidth(), imageIcon3.getIconHeight());
        Guide.centerHorizontally(this, this.background);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        this.processMouseClicks(source);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.startButton.changeImageIcon(ImageLoader.loadImageIcon(ImageLoader.BUTTON_HOVER, 300));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.startButton.changeImageIcon(ImageLoader.loadImageIcon(ImageLoader.BUTTON_IDLE, 300));
    }

    private void processMouseClicks(Object source){
        if(source == this.startButton){
            this.programManager.openCharacterSelect();
        }
    }

}
