package com.pokechess.gui;

import com.pokechess.managers.ComputerManager;
import com.pokechess.model.loaders.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ShowcasePokemon extends JPanel implements MouseListener {

    private ComputerManager compManager;
    private JLabel background;
    private JLabel[] allyCards = new JLabel[5];
    private JLabel[] enemyCards = new JLabel[5];
    private Button startGame;
    private JLabel startText;

    public ShowcasePokemon(ComputerManager manager, Frame frame){
        this.compManager = manager;

        this.compManager.selectPokemon();

        this.setVisible(true);
        this.setLayout(null);
        this.setSize(frame.getSize());

        this.initComponents();
        for(int i = 0; i < 5; i++){
            this.add(allyCards[i]);
        }
        for(int j = 0; j < 5; j++){
            this.add(enemyCards[j]);
        }

        this.add(startText);
        this.add(startGame);
        this.add(background);
    }

    public void initComponents(){
        String bgPath = ImageLoader.BG_BATTLE;
        String buttonIcon = ImageLoader.BUTTON_IDLE;

        ImageIcon bg = ImageLoader.loadImageIcon(bgPath, 1400);
        this.background = new JLabel(bg);
        this.background.setVisible(true);
        this.background.setSize(bg.getIconWidth(), bg.getIconHeight());
        Guide.centerHorizontally(this, this.background);

        ImageIcon button = ImageLoader.loadImageIcon(buttonIcon, 300);
        this.startGame = new Button(button, this);
        this.startGame.setVisible(true);
        this.startGame.setLocation(this.startGame.getX(), 500);
        Guide.centerHorizontally(this, this.startGame);

        String path = "/com/pokechess/gui/images/cards/pokemoncards/card-";

        String allyPath1 = path + compManager.ally.getName(0) + ".png";
        ImageIcon ally1 = ImageLoader.loadImageIcon(allyPath1, 120);
        this.allyCards[0] = new JLabel(ally1);
        this.allyCards[0].setVisible(true);
        this.allyCards[0].setSize(ally1.getIconWidth(), ally1.getIconHeight());
        System.out.println(ally1.getIconHeight());
        this.allyCards[0].setLocation(100, 80);

        String allyPath2 = path + compManager.ally.getName(1) + ".png";
        ImageIcon ally2 = ImageLoader.loadImageIcon(allyPath2, 120);
        this.allyCards[1] = new JLabel(ally2);
        this.allyCards[1].setVisible(true);
        this.allyCards[1].setSize(ally2.getIconWidth(), ally2.getIconHeight());
        this.allyCards[1].setLocation(100, 260);

        String allyPath3 = path + compManager.ally.getName(2) + ".png";
        ImageIcon ally3 = ImageLoader.loadImageIcon(allyPath3, 120);
        this.allyCards[2] = new JLabel(ally3);
        this.allyCards[2].setVisible(true);
        this.allyCards[2].setSize(ally3.getIconWidth(), ally3.getIconHeight());
        this.allyCards[2].setLocation(100, 440);

        String allyPath4 = path + compManager.ally.getName(3) + ".png";
        ImageIcon ally4 = ImageLoader.loadImageIcon(allyPath4, 120);
        this.allyCards[3] = new JLabel(ally4);
        this.allyCards[3].setVisible(true);
        this.allyCards[3].setSize(ally4.getIconWidth(), ally4.getIconHeight());
        this.allyCards[3].setLocation(230, 165);

        String allyPath5 = path + compManager.ally.getName(4) + ".png";
        ImageIcon ally5 = ImageLoader.loadImageIcon(allyPath5, 120);
        this.allyCards[4] = new JLabel(ally5);
        this.allyCards[4].setVisible(true);
        this.allyCards[4].setSize(ally3.getIconWidth(), ally3.getIconHeight());
        this.allyCards[4].setLocation(230, 345);

        String enemyPath1 = path + compManager.computer.getName(0) + ".png";
        System.out.println(enemyPath1);
        ImageIcon enemy1 = ImageLoader.loadImageIcon(enemyPath1, 120);
        this.enemyCards[0] = new JLabel(enemy1);
        this.enemyCards[0].setVisible(true);
        this.enemyCards[0].setSize(enemy1.getIconWidth(), enemy1.getIconHeight());
        this.enemyCards[0].setLocation(1060, 80);

        String enemyPath2 = path + compManager.computer.getName(1) + ".png";
        System.out.println(enemyPath2);
        ImageIcon enemy2 = ImageLoader.loadImageIcon(enemyPath2, 120);
        this.enemyCards[1] = new JLabel(enemy2);
        this.enemyCards[1].setVisible(true);
        this.enemyCards[1].setSize(enemy2.getIconWidth(), enemy2.getIconHeight());
        this.enemyCards[1].setLocation(1060, 260);

        String enemyPath3 = path + compManager.computer.getName(2) + ".png";
        System.out.println(enemyPath3);
        ImageIcon enemy3 = ImageLoader.loadImageIcon(enemyPath3, 120);
        this.enemyCards[2] = new JLabel(enemy3);
        this.enemyCards[2].setVisible(true);
        this.enemyCards[2].setSize(enemy3.getIconWidth(), enemy3.getIconHeight());
        this.enemyCards[2].setLocation(1060, 440);

        String enemyPath4 = path + compManager.computer.getName(3) + ".png";
        System.out.println(enemyPath4);
        ImageIcon enemy4 = ImageLoader.loadImageIcon(enemyPath4, 120);
        this.enemyCards[3] = new JLabel(enemy4);
        this.enemyCards[3].setVisible(true);
        this.enemyCards[3].setSize(enemy4.getIconWidth(), enemy4.getIconHeight());
        this.enemyCards[3].setLocation(930, 165);

        String enemyPath5 = path + compManager.computer.getName(4) + ".png";
        System.out.println(enemyPath5);
        ImageIcon enemy5 = ImageLoader.loadImageIcon(enemyPath5, 120);
        this.enemyCards[4] = new JLabel(enemy5);
        this.enemyCards[4].setVisible(true);
        this.enemyCards[4].setSize(enemy5.getIconWidth(), enemy5.getIconHeight());
        this.enemyCards[4].setLocation(930, 345);

        this.startText = new JLabel("Start", SwingConstants.CENTER);
        Font f = new Font("Arial", Font.BOLD, 20);
        this.startText.setFont(f);
        this.startText.setForeground(Color.WHITE);
        this.startText.setVisible(true);
        this.startText.setSize(100, 30);
        Guide.centerHorizontally(this, this.startText);
        this.startText.setLocation(this.startText.getX(), 535);

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
        this.startGame.changeImageIcon(ImageLoader.loadImageIcon(ImageLoader.BUTTON_HOVER, 300));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.startGame.changeImageIcon(ImageLoader.loadImageIcon(ImageLoader.BUTTON_IDLE, 300));
    }

    public void processMouseClicks(Object source){
        if(source == this.startGame){
            this.compManager.gameManager.showBoardScreen();
        }
    }
}
