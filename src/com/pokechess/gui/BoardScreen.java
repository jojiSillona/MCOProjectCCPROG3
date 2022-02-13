package com.pokechess.gui;

import com.pokechess.board.Board;
import com.pokechess.board.Tile;
import com.pokechess.gui.graphics.Colors;
import com.pokechess.managers.BoardManager;
import com.pokechess.model.loaders.ImageLoader;
import com.pokechess.player.Player;
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
    private final BoardManager bManager;
    private final BoardPanel boardPanel;
    public Board board;

    private Tile sourceTile;
    private Tile destinationTile;
    private Pokemon humanActionPiece;
    private int playerAction = 0;

    private final static Dimension BOARD_DIMENSION = new Dimension(800,600);
    private final static Dimension TILE_DIMENSION = new Dimension(20,20);

    public BoardScreen(BoardManager bManager, Frame frame, Board board){
        this.bManager = bManager;
        this.board = board;
        this.setVisible(true);
        this.setSize(frame.getSize());

        this.boardPanel = new BoardPanel();

        this.boardPanel.setVisible(true);
        this.add(this.boardPanel, BorderLayout.CENTER);
    }

    public class BoardPanel extends JPanel{
        final List<TilePanel> boardTiles;

        BoardPanel(){
            super(new GridLayout(5,7));
            this.boardTiles = new ArrayList<>();
            for(int i = 0; i < 35; i++){
                TilePanel tilePanel = new TilePanel(this, i);
                this.boardTiles.add(tilePanel);
                add(tilePanel);
            }
            setPreferredSize(BOARD_DIMENSION);
            validate();

            setBackground(Color.decode("#8B4726"));
            repaint();
        }

        void drawBoard(final Board board){
            removeAll();
            for(final TilePanel boardTile : boardTiles){
                boardTile.drawTile(board);
                add(boardTile);
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
            assignTileColor();
            assignPokemonToTile(board);
            highlightTileBorder();
            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(final MouseEvent e) {
                    //Right mouse clicks will allow the player to cancel their Pokemon Selection
                    if (isRightMouseButton(e)) {
                        sourceTile = null;
                        humanActionPiece = null;
                    } else if (isLeftMouseButton(e)) {
                        if (sourceTile == null) {
                            sourceTile = board.getTile(tileID / 7, tileID % 7);
                            humanActionPiece = sourceTile.getCurrPosition();
                            if (humanActionPiece == null) {
                                sourceTile = null;
                            }
                        } else {
                            destinationTile = board.getTile(tileID / 7, tileID % 7);
                            bManager.castPossibleMove(sourceTile.getCurrPosition());
                            int i = 0;
                            boolean move = false;
                            while (i < bManager.possibleMoves.size()) {
                                if (bManager.possibleMoves.get(i).getColumn() == destinationTile.getAlphabet() &&
                                        bManager.possibleMoves.get(i).getRow() == destinationTile.getNumber()) {
                                    bManager.board.movePokemon(sourceTile, destinationTile);
                                    move = true;
                                    bManager.possibleMoves.clear();
                                    board.moveComputer(bManager.computer);
                                    break;
                                } else {
                                    i++;
                                }
                            }
                            if (!move)
                                dialogIllegal();
                            destinationTile = null;
                            sourceTile = null;
                            humanActionPiece = null;
                        }
                        SwingUtilities.invokeLater(() -> boardPanel.drawBoard(board));
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

            revalidate();
            repaint();

        }

        void drawTile(Board board){
            assignTileColor();
            assignPokemonToTile(board);
            highlightTileBorder();
            revalidate();
            repaint();
        }

        void dialogIllegal(){
            JOptionPane.showMessageDialog(this, "Illegal Move!");
        }

        public void assignPokemonToTile(Board board){
            removeAll();
            if(!Objects.equals(board.board[this.tileID / 7][this.tileID % 7].getCurrPosition().getName(), "non")){
                if(!board.board[this.tileID / 7][this.tileID % 7].getCurrPosition().getIsEnemy()){
                    String pokemonName = board.board[this.tileID / 7][this.tileID % 7].getCurrPosition().getName();
                    String path = "/com/pokechess/gui/images/pokemonselect/rightface/full-";
                    String pathToAlly = path + pokemonName + ".png";
                    System.out.println(pathToAlly);
                    ImageIcon icon = ImageLoader.loadImageIcon(pathToAlly, 70);
                    add(new JLabel(icon));
                } else {
                    String enemyName = board.board[this.tileID / 7][this.tileID % 7].getCurrPosition().getName();
                    String path = "/com/pokechess/gui/images/pokemonselect/leftfaces/full-enemy-";
                    String pathToEnemy = path + enemyName + ".png";
                    System.out.println(pathToEnemy);
                    ImageIcon icon = ImageLoader.loadImageIcon(pathToEnemy, 70);
                    add(new JLabel(icon));
                }
            }
        }

        private void highlightTileBorder(){
            if(humanActionPiece != null && !humanActionPiece.getIsEnemy() && humanActionPiece.getPosition().getColumn() == tileID % 7
            && humanActionPiece.getPosition().getRow() == tileID / 7){
                setBorder(BorderFactory.createLineBorder(Color.CYAN));
            } else {
                setBorder(BorderFactory.createLineBorder(Color.GRAY));
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

    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g);
        this.repaint();
    }

    boolean isPlayersTurn(Player player){
        if(player.getBoardCommands() == 2)
            return true;
        return false;
    }
}

