package com.pokechess.gui;

import com.pokechess.model.loaders.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.MouseListener;
import com.pokechess.managers.BattleScreenManager;
import java.awt.event.MouseEvent;
import java.util.concurrent.ThreadLocalRandom;


public class BattleScreen extends JPanel implements MouseListener{

    private BattleScreenManager bsManager;
    private Button attackButton;
    private Button defendButton;
    private Button healButton;
    private Button runButton;
    private JLabel background;
    private JLabel playerPokemon;
    private JLabel enemyPokemon;
    private JProgressBar playerHealthBar;
    private JProgressBar enemyHealthBar;
    private JLabel commentator;
    private Button proceedButton;
    private JLabel proceedText;

    private int playerHealth = 100;
    private int enemyHealth = 100;



    public BattleScreen(BattleScreenManager bsManager, Frame frame) {
        this.bsManager = bsManager;
        bsManager.getRandomPokemons();
        this.setVisible(true);
        this.setSize(frame.getSize());
        this.setLayout(null);

        setPokemonIcons();
        this.initComponents();
        this.add(proceedText);
        this.add(proceedButton);
        this.add(commentator);
        this.add(playerHealthBar);
        this.add(enemyHealthBar);
        this.add(this.attackButton);
        this.add(this.defendButton);
        this.add(this.healButton);
        this.add(this.runButton);
        this.add(this.playerPokemon);
        this.add(this.enemyPokemon);
        this.add(this.background);
    }

    private void initComponents(){
        String path1 = ImageLoader.BUTTON_ATTACK;
        String path2 = ImageLoader.BUTTON_DEFEND;
        String path3 = ImageLoader.BUTTON_HEAL;
        String path4 = ImageLoader.BUTTON_RUN;
        String path5 = ImageLoader.BG_BATTLESCREEN;
        String path6 = ImageLoader.BUTTON_IDLE;
        String path7 = ImageLoader.BUTTON_HOVER;

        this.proceedText = new JLabel("PROCEED", SwingConstants.CENTER);
        Font f = new Font("Arial", Font.BOLD, 20);
        this.proceedText.setFont(f);
        this.proceedText.setForeground(Color.WHITE);
        this.proceedText.setVisible(false);
        this.proceedText.setSize(100, 30);
        Guide.centerHorizontally(this, this.proceedText);
        this.proceedText.setLocation(this.proceedText.getX(), 576);

        ImageIcon imageIcon6 = ImageLoader.loadImageIcon(path6, 300);
        this.proceedButton = new Button(imageIcon6, this);
        this.proceedButton.setVisible(false);
        Guide.centerHorizontally(this, this.proceedButton);
        this.proceedButton.setLocation(this.proceedButton.getX(), 540);

        this.commentator = new JLabel("Let the battle begin!", SwingConstants.CENTER);
        this.commentator.setVisible(true);
        this.commentator.setSize(300, 100);
        this.commentator.setOpaque(true);
        this.commentator.setBackground(Color.white);
        Guide.centerHorizontally(this, this.commentator);

        // ATTACK BUTTON
        ImageIcon imageIcon1 = ImageLoader.loadImageIcon(path1, 250);
        this.attackButton = new Button(imageIcon1, this);
        this.attackButton.setVisible(true);
        this.attackButton.setSize(imageIcon1.getIconWidth(), imageIcon1.getIconHeight());
        this.attackButton.setLocation(125,550);

        // DEFEND BUTTON
        ImageIcon imageIcon2 = ImageLoader.loadImageIcon(path2, 250);
        this.defendButton = new Button(imageIcon2, this);
        this.defendButton.setVisible(true);
        this.defendButton.setSize(imageIcon2.getIconWidth(), imageIcon2.getIconHeight());
        this.defendButton.setLocation(385, 550);

        // HEAL BUTTON
        ImageIcon imageIcon3 = ImageLoader.loadImageIcon(path3, 250);
        this.healButton = new Button(imageIcon3, this);
        this.healButton.setVisible(true);
        this.healButton.setSize(imageIcon3.getIconWidth(), imageIcon3.getIconHeight());
        this.healButton.setLocation(645, 550);

        // RUN BUTTON
        ImageIcon imageIcon4 = ImageLoader.loadImageIcon(path4, 250);
        this.runButton = new Button(imageIcon4, this);
        this.runButton.setVisible(true);
        this.runButton.setSize(imageIcon3.getIconWidth(), imageIcon3.getIconHeight());
        this.runButton.setLocation(905, 550);

        // BACKGROUND
        ImageIcon imageIcon5 = ImageLoader.loadImageIcon(path5, 1400);
        this.background = new JLabel(imageIcon5);
        this.background.setVisible(true);
        this.background.setSize(imageIcon5.getIconWidth(), imageIcon5.getIconHeight());
        Guide.centerHorizontally(this, this.background);

        this.playerHealthBar = new JProgressBar(SwingConstants.VERTICAL);
        this.playerHealthBar.setVisible(true);
        this.playerHealthBar.setSize(20, 300);
        this.playerHealthBar.setForeground(Color.GREEN);
        this.playerHealthBar.setBackground(Color.RED);
        this.playerHealthBar.setStringPainted(false);
        this.playerHealthBar.setLocation(50,200);

        this.enemyHealthBar = new JProgressBar(SwingConstants.VERTICAL);
        this.enemyHealthBar.setVisible(true);
        this.enemyHealthBar.setSize(20, 300);
        this.enemyHealthBar.setForeground(Color.GREEN);
        this.enemyHealthBar.setBackground(Color.RED);
        this.enemyHealthBar.setStringPainted(false);
        this.enemyHealthBar.setLocation(1050,200);

        bsManager.getCommentator();
        showProceedHideActions();
        setHealthBars();
    }

    public void setHealthBars(){
        this.playerHealthBar.setValue(playerHealth);
        this.enemyHealthBar.setValue(enemyHealth);
    }

    public void setPokemonIcons(){
        //POKEMONS
        String pokemonPath = "/com/pokechess/gui/images/pokemonselect/rightface/full-";
        pokemonPath = pokemonPath + bsManager.player.getPokemon(0).getName() + ".png";
        System.out.println(pokemonPath);
        ImageIcon playerPokemon = ImageLoader.loadImageIcon(pokemonPath, 300);
        this.playerPokemon = new JLabel(playerPokemon);
        this.playerPokemon.setVisible(true);
        this.playerPokemon.setSize(playerPokemon.getIconWidth(), playerPokemon.getIconHeight());
        this.playerPokemon.setLocation(100, 250);

        String enemyPath = "/com/pokechess/gui/images/pokemonselect/leftfaces/full-enemy-";
        enemyPath = enemyPath + bsManager.enemy.getPokemon(0).getName() + ".png";
        ImageIcon enemyPokemon = ImageLoader.loadImageIcon(enemyPath, 200);
        System.out.println(enemyPath);
        this.enemyPokemon = new JLabel(enemyPokemon);
        this.enemyPokemon.setVisible(true);
        this.enemyPokemon.setSize(enemyPokemon.getIconWidth(), enemyPokemon.getIconHeight());
        this.enemyPokemon.setLocation(800, 220);
    }

    public void showProceedHideActions(){
        if(bsManager.turn % 2 == 1){
            this.proceedButton.setVisible(true);
            this.proceedText.setVisible(true);

            this.attackButton.setVisible(false);
            this.defendButton.setVisible(false);
            this.healButton.setVisible(false);
            this.runButton.setVisible(false);
        } else {
            this.proceedButton.setVisible(false);
            this.proceedText.setVisible(false);

            this.attackButton.setVisible(true);
            this.defendButton.setVisible(true);
            this.healButton.setVisible(true);
            this.runButton.setVisible(true);
        }
    }

    public void redrawHealth(){
        playerHealth = (bsManager.player.getPokemon(0).getCurrentHealth() * 100) /
                bsManager.player.getPokemon(0).getMaxHp();
        enemyHealth = (bsManager.enemy.getPokemon(0).getCurrentHealth() * 100) /
                bsManager.enemy.getPokemon(0).getMaxHp();
//        remove(playerHealthBar);
//        remove(enemyHealthBar);
        this.commentator.setText(bsManager.getCommentator());
        showProceedHideActions();
        setHealthBars();
        revalidate();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Object source = e.getSource();
        this.processMouseClicks(source);
        revalidate();
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        if(source == attackButton)
            this.attackButton.changeImageIcon(ImageLoader.loadImageIcon(ImageLoader.SELECTEDBUTTON_ATTACK, 250));
        else if(source == defendButton)
            this.defendButton.changeImageIcon(ImageLoader.loadImageIcon(ImageLoader.SELECTEDBUTTON_DEFEND, 250));
        else if(source == healButton)
            this.healButton.changeImageIcon(ImageLoader.loadImageIcon(ImageLoader.SELECTEDBUTTON_HEAL, 250));
        else if(source == runButton)
            this.runButton.changeImageIcon(ImageLoader.loadImageIcon(ImageLoader.SELECTEDBUTTON_RUN, 250));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();
        if(source == attackButton)
            this.attackButton.changeImageIcon(ImageLoader.loadImageIcon(ImageLoader.BUTTON_ATTACK, 250));
        else if(source == defendButton)
            this.defendButton.changeImageIcon(ImageLoader.loadImageIcon(ImageLoader.BUTTON_DEFEND, 250));
        else if(source == healButton)
            this.healButton.changeImageIcon(ImageLoader.loadImageIcon(ImageLoader.BUTTON_HEAL, 250));
        else if(source == runButton)
            this.runButton.changeImageIcon(ImageLoader.loadImageIcon(ImageLoader.BUTTON_RUN, 250));
    }

    private void processMouseClicks(Object source){

        if(source == this.attackButton){
            bsManager.battle(1);
        } else if(source == defendButton)
            bsManager.battle(2);
        else if(source == healButton) {
            bsManager.battle(3);
            JOptionPane.showMessageDialog(this, "Heal command is not properly implemented in this game. Sorry!", "This is embarrassing :/", JOptionPane.INFORMATION_MESSAGE);
        }else if(source == runButton)
            bsManager.battle(4);
        else if(source == proceedButton){
            bsManager.battle(ThreadLocalRandom.current().nextInt(1, 5));
        }
        bsManager.getCommentator();
        redrawHealth();


    }

    @Override
    protected void paintChildren(Graphics g){
        super.paintChildren(g);
        this.repaint();
    }

}
