package com.pokechess.gui;

import com.pokechess.board.Board;
import com.pokechess.board.Tile;
import com.pokechess.gui.graphics.Colors;
import com.pokechess.managers.BoardManager;
import com.pokechess.model.loaders.ImageLoader;
import com.pokechess.player.Pokemon;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class BoardScreen extends JPanel implements MouseListener {
    private BoardManager bManager;

    private final BoardPanel boardPanel;
    public Tile[][] board;


    private final static Dimension BOARD_DIMENSION = new Dimension(800,600);
    private final static Dimension TILE_DIMENSION = new Dimension(20,20);

    // private static Dimension OUTER_PANEL_DIMENSION = new Dimension(1500,1000);
    // private final BoardPanel boardPanel;

    public BoardScreen(BoardManager bManager, Frame frame){
        this.bManager = bManager;
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

    private class BoardPanel extends JPanel{
        final List<TilePanel> boardtiles;
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

    private class TilePanel extends JPanel {
        private final int tileID;

        TilePanel(final BoardPanel boardPanel, final int tileID){
            super(new GridBagLayout());
            this.tileID = tileID;
            setPreferredSize(TILE_DIMENSION);
            setVisible(true);
            assignTileColor();
            validate();
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
//    private class PositionPanel extends JPanel{
//        private final int tilePosition;
//
//        PositionPanel(final TilePanel tilePanel, final int tilePosition){
//            super(new GridBagLayout());
//            this.tilePosition = tilePosition;
//            setPreferredSize(TILE_DIMENSION);
//            assignTileColor();
//            validate();
//        }
//    }

}

