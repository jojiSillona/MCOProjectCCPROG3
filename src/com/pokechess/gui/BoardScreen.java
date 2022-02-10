package com.pokechess.gui;

import com.pokechess.board.Board;
import com.pokechess.gui.graphics.Colors;
import com.pokechess.managers.BoardManager;
import com.pokechess.model.loaders.ImageLoader;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class BoardScreen extends JPanel implements MouseListener {
    private BoardManager bManager;

    public final BoardPanel boardPanel;
    public Board board;


    private final static Dimension BOARD_DIMENSION = new Dimension(800,600);
    private final static Dimension TILE_DIMENSION = new Dimension(20,20);

    // private static Dimension OUTER_PANEL_DIMENSION = new Dimension(1500,1000);
    // private final BoardPanel boardPanel;

    public BoardScreen(BoardManager bManager, Frame frame, Board board){
        this.bManager = bManager;
        this.board = board;
        this.setVisible(true);
        this.setSize(frame.getSize());


        this.boardPanel = new BoardPanel();
        this.boardPanel.setVisible(true);
        this.add(this.boardPanel, BorderLayout.CENTER);

        this.initComponents();

    }

    public void initComponents(){

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

    public class BoardPanel extends JPanel{
        public final List<TilePanel> boardtiles;
        BoardPanel(){
            super(new GridLayout(5,7));
            this.boardtiles = new ArrayList<>();
            for(int i = 0; i < 35; i++){
                final TilePanel tilePanel = new TilePanel(this, i);
                this.boardtiles.add(tilePanel);

                add(tilePanel);
            }

            setPreferredSize(BOARD_DIMENSION);
            validate();
        }

    }

    public class TilePanel extends JPanel {
        private final int tileID;

        TilePanel(final BoardPanel boardPanel, final int tileID){
            super(new GridBagLayout());
            this.tileID = tileID;
            setPreferredSize(TILE_DIMENSION);
            setVisible(true);

            assignTileColor();
            validate();
        }

        public void assignPokemonToTile(Board board){
            if(this.tileID % 7 == 0){
                String pokemonName = board.board[this.tileID / 7][this.tileID % 7].getCurrPosition().getName();
                String path = "/com/pokechess/gui/images/pokemonselect/rightface/full-";
                String pathToAlly = path + pokemonName + ".png";
                System.out.println(pathToAlly);
                ImageIcon icon = ImageLoader.loadImageIcon(pathToAlly, 70);
                add(new JLabel(icon));
            }
            if(this.tileID % 7 == 6){
                String enemyName = board.board[this.tileID / 7][this.tileID % 7].getCurrPosition().getName();
                String path = "/com/pokechess/gui/images/pokemonselect/leftfaces/full-enemy-";
                String pathToEnemy = path + enemyName + ".png";
                System.out.println(pathToEnemy);
                ImageIcon icon = ImageLoader.loadImageIcon(pathToEnemy, 70);
                add(new JLabel(icon));
            }
        }

        private void assignTileColor(){
            if(tileID % 7 == 0)
                setBackground(Colors.TRANSLUCENT_VIOLET);
            else if (tileID % 7 == 6)
                setBackground(Colors.TRANSLUCENT_ORANGE);
            else
                setBackground(Colors.TRANSLUCENT_WHITE);
        }
    }
}

