package com.pokechess.gui;

import com.pokechess.managers.CharSelScreenManager;
import com.pokechess.model.loaders.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CharacterSelectScreen extends JPanel implements MouseListener {
    private CharSelScreenManager selectManager;
    private ScrollablePane scrollablePane;
    private JLabel background;
    private PokemonNames[] pokemonNames = PokemonNames.values();

    public CharacterSelectScreen(CharSelScreenManager manager, Frame frame){

        this.selectManager = manager;
        this.setVisible(true);
        this.setLayout(null);
        this.setSize(frame.getSize());
        this.initComponents();
        this.add(background);
    }

    public void initComponents(){
        String path1 = ImageLoader.BG_CSS;

        this.scrollablePane = new ScrollablePane(this.getWidth() - 80, 150);
        Guide.centerHorizontally(this, this.scrollablePane);
        this.scrollablePane.setLocation(this.scrollablePane.getX(), 490);

        this.add(this.scrollablePane);
        this.generateRoster();

        ImageIcon imageIcon1 = ImageLoader.loadImageIcon(path1, 1400);
        this.background = new JLabel(imageIcon1);
        this.background.setVisible(true);
        this.background.setSize(imageIcon1.getIconWidth(), imageIcon1.getIconHeight());
        Guide.centerHorizontally(this, this.background);



    }

    public void generateRoster(){
        ImageIcon imageIcon;

        Button button;

        for(int i = 0; i < this.pokemonNames.length; i++){
            PokemonNames name;
            name = this.pokemonNames[i];
            imageIcon = ImageLoader.loadImageIcon(name, 130);
            imageIcon.setDescription(name.toString());
            button = new Button(imageIcon, this);

            this.scrollablePane.addItem(button);
        }
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
        Object source = e.getSource();
        if(source instanceof Button) {
            String path = ((Button) source).getImageIcon().getDescription();
            String pathToPic = "/com/pokechess/gui/images/pokemonselect/buttonselect/card-";
            pathToPic = pathToPic + path.toLowerCase() + "-selected.png";

            Image selected = ImageLoader.loadImage(pathToPic, 130);
            ((Button) source).getImageIcon().setImage(selected);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();
        if(source instanceof Button) {
            String path = ((Button) source).getImageIcon().getDescription();
            String pathToPic = "/com/pokechess/gui/images/pokemonselect/cards/card-";
            pathToPic = pathToPic + path.toLowerCase() + ".png";

            Image selected = ImageLoader.loadImage(pathToPic, 130);
            ((Button) source).getImageIcon().setImage(selected);
        }
    }

    private void processMouseClicks(Object source){
        if(source instanceof Button){
            String path = ((Button) source).getImageIcon().getDescription();
            String pathToPic = "/com/pokechess/gui/images/pokemonselect/buttonclicked/card-";
            pathToPic = pathToPic + path.toLowerCase() + "-clicked.png";

            Image selected = ImageLoader.loadImage(pathToPic, 130);
            ((Button) source).getImageIcon().setImage(selected);

            //INSERT POKEMON
        }
    }

}
