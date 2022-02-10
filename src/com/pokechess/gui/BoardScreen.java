package com.pokechess.gui;

import com.pokechess.board.Board;
import com.pokechess.board.Position;
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

import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;

public class BoardScreen extends JPanel{
    private BoardManager bManager;
    public final BoardPanel boardPanel;
    public Board board;


    private Tile sourceTile;
    private Tile destinationTile;
    private Pokemon humanActionPiece;

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

    public class BoardPanel extends JPanel{
        final List<TilePanel> boardtiles;

        BoardPanel(){
            super(new GridLayout(5,7));
            this.boardtiles = new ArrayList<>();
            for(int i = 0; i < 35; i++){
                TilePanel tilePanel = new TilePanel(this, i);
                this.boardtiles.add(tilePanel);

                add(tilePanel);
            }

            setPreferredSize(BOARD_DIMENSION);
            validate();
        }

        public void drawBoard(Board board){
            removeAll();
            for(final TilePanel tilePanel : boardtiles){
                tilePanel.drawTile(board);
                add(tilePanel);
            }
            validate();
            repaint();
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
            assignPokemonToTile(board);

            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //Right mouse clicks will allow the player to cancel their Pokemon Selection
                    if(isRightMouseButton(e)){
                        sourceTile = null;
                        destinationTile = null;
                        humanActionPiece = null;
                    } else if(isLeftMouseButton(e)){
                        if(sourceTile == null){
                            sourceTile = board.getTile(tileID / 7, tileID % 7);
                            humanActionPiece = sourceTile.getCurrPosition();
                            if(humanActionPiece == null){
                                sourceTile = null;
                            }
                        } else {
                            destinationTile = board.getTile(tileID / 7, tileID % 7);
                            bManager.castPossibleMove(sourceTile.getCurrPosition());
                            int i = 0;
                            while(i < bManager.possibleMoves.size()){
                                if(bManager.possibleMoves.get(i).getAlphabet() == destinationTile.getAlphabet() &&
                                bManager.possibleMoves.get(i).getNumber() == destinationTile.getNumber()){
                                    Position P = new Position(destinationTile.getAlphabet(), destinationTile.getNumber());
                                    bManager.board.movePokemon(sourceTile, destinationTile);
                                    break;
                                } else {
                                    i++;
                                }
                            }
                            sourceTile = null;
                            destinationTile = null;
                            humanActionPiece = null;
                        }
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                removeAll();
                                drawTile(board);
                                repaint();
                            }
                        });
                    }
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
            });

            validate();
        }

        public void drawTile(Board board){
            assignTileColor();
            assignPokemonToTile(board);
            validate();
            repaint();
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

