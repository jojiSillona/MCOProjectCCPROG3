package com.pokechess.gui;

import com.pokechess.managers.CharSelScreenManager;
import com.pokechess.managers.GameManager;
import com.pokechess.model.loaders.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CharacterSelectScreen extends JPanel implements MouseListener {
    private CharSelScreenManager selectManager;
    private GameManager gameManager;
    private ScrollablePane scrollablePane;
    private JLabel background;
    private PokemonNames[] pokemonNames = PokemonNames.values();
    private JLabel pokemonFull;
    private JLabel pokemonName;
    private JLabel attack;
    private JLabel defend;
    private JLabel unite;
    private JLabel[] cards = new JLabel[5];
    private Button cont;
    private JLabel contText;


    private int pokemonNums = 0;

    public CharacterSelectScreen(CharSelScreenManager manager, GameManager gManager, Frame frame){

        this.gameManager = gManager;
        this.selectManager = manager;
        this.setVisible(true);
        this.setLayout(null);
        this.setSize(frame.getSize());
        this.initComponents();
        this.add(pokemonFull);
        this.add(pokemonName);
        this.add(attack);
        this.add(defend);
        this.add(unite);
        for(int i = 0; i < 5; i++){
            this.add(cards[i]);
        }
        this.add(contText);
        this.add(cont);
        this.add(background);
    }

    public void initComponents(){
        String path1 = ImageLoader.BG_CSS;
        String path2 = ImageLoader.PIKACHU;
        String path3 = ImageLoader.PIKA_ATK;
        String path4 = ImageLoader.PIKA_DEF;
        String path5 = ImageLoader.PIKA_UNI;

        String idle = ImageLoader.CARD_IDLE;

        String buttonIcon = ImageLoader.BUTTON_IDLE;

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

        ImageIcon imageIcon2 = ImageLoader.loadImageIcon(path2, 490);
        this.pokemonFull = new JLabel(imageIcon2);
        this.pokemonFull.setVisible(true);
        this.pokemonFull.setSize(imageIcon2.getIconWidth(), imageIcon2.getIconHeight());
        this.pokemonFull.setLocation(50, 50);

        this.pokemonName = new JLabel("PIKACHU", SwingConstants.RIGHT);
        this.pokemonName.setFont(new Font("Arial", Font.BOLD, 80));
        this.pokemonName.setVisible(true);
        this.pokemonName.setSize(600, 100);
        this.pokemonName.setLocation(600, 100);

        ImageIcon attack = ImageLoader.loadImageIcon(path3, 50);
        this.attack = new JLabel(attack);
        this.attack.setVisible(true);
        this.attack.setSize(attack.getIconWidth(), attack.getIconHeight());
        this.attack.setLocation(1015,185);

        ImageIcon defend = ImageLoader.loadImageIcon(path4, 50);
        this.defend = new JLabel(defend);
        this.defend.setVisible(true);
        this.defend.setSize(attack.getIconWidth(), attack.getIconHeight());
        this.defend.setLocation(1080,185);

        ImageIcon unite = ImageLoader.loadImageIcon(path5, 50);
        this.unite = new JLabel(unite);
        this.unite.setVisible(true);
        this.unite.setSize(attack.getIconWidth(), attack.getIconHeight());
        this.unite.setLocation(1145,185);

        ImageIcon[] cards = new ImageIcon[5];
        for(int i = 0; i < 5; i++){
            cards[i] = ImageLoader.loadImageIcon(idle, 100);
        }
        this.cards[0] = new JLabel(cards[0]);
        this.cards[0].setVisible(true);
        this.cards[0].setSize(cards[0].getIconWidth(), cards[0].getIconHeight());
        this.cards[0].setLocation(660, 260);

        this.cards[1] = new JLabel(cards[1]);
        this.cards[1].setVisible(true);
        this.cards[1].setSize(cards[1].getIconWidth(), cards[1].getIconHeight());
        this.cards[1].setLocation(770, 260);

        this.cards[2] = new JLabel(cards[2]);
        this.cards[2].setVisible(true);
        this.cards[2].setSize(cards[2].getIconWidth(), cards[2].getIconHeight());
        this.cards[2].setLocation(880, 260);

        this.cards[3] = new JLabel(cards[3]);
        this.cards[3].setVisible(true);
        this.cards[3].setSize(cards[3].getIconWidth(), cards[3].getIconHeight());
        this.cards[3].setLocation(990, 260);

        this.cards[4] = new JLabel(cards[4]);
        this.cards[4].setVisible(true);
        this.cards[4].setSize(cards[4].getIconWidth(), cards[4].getIconHeight());
        this.cards[4].setLocation(1100, 260);

        ImageIcon button = ImageLoader.loadImageIcon(buttonIcon, 200);
        this.cont = new Button(button, this);
        this.cont.setVisible(false);
        this.cont.setLocation(1010, 410);

        this.contText = new JLabel("Confirm", SwingConstants.CENTER);
        Font f = new Font("Arial", Font.BOLD, 20);
        this.contText.setFont(f);
        this.contText.setForeground(Color.WHITE);
        this.contText.setVisible(false);
        this.contText.setSize(100, 30);
        this.contText.setLocation(1059, 428);
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
        if(source == this.cont){
            this.cont.changeImageIcon(ImageLoader.loadImageIcon(ImageLoader.BUTTON_HOVER, 200));
        } else if(source instanceof Button) {
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
        if(source == this.cont){
            this.cont.changeImageIcon(ImageLoader.loadImageIcon(ImageLoader.BUTTON_IDLE, 200));
        } else if(source instanceof Button) {
            String path = ((Button) source).getImageIcon().getDescription();
            String pathToPic = "/com/pokechess/gui/images/pokemonselect/cards/card-";
            pathToPic = pathToPic + path.toLowerCase() + ".png";

            Image selected = ImageLoader.loadImage(pathToPic, 130);
            ((Button) source).getImageIcon().setImage(selected);
        }
    }

    private void processMouseClicks(Object source){
        if(source == this.cont){
            this.gameManager.showCasePokemon();
        } else if(source instanceof Button){
            String path = ((Button) source).getImageIcon().getDescription();
            String pathToPic = "/com/pokechess/gui/images/pokemonselect/buttonclicked/card-";
            pathToPic = pathToPic + path.toLowerCase() + "-clicked.png";

            Image selected = ImageLoader.loadImage(pathToPic, 130);
            ((Button) source).getImageIcon().setImage(selected);

            pathToPic = "/com/pokechess/gui/images/pokemonselect/rightface/full-";
            pathToPic = pathToPic + path + ".png";
            ImageIcon fullSelect = ImageLoader.loadImageIcon(pathToPic, 490);
            this.pokemonFull.setIcon(fullSelect);

            this.pokemonName.setText(path);

            pathToPic = "/com/pokechess/gui/images/skill/";
            pathToPic = pathToPic + path + "-attack.png";
            ImageIcon atkSel = ImageLoader.loadImageIcon(pathToPic, 50);
            this.attack.setIcon(atkSel);

            pathToPic = "/com/pokechess/gui/images/skill/";
            pathToPic = pathToPic + path + "-defend.png";
            ImageIcon defSel = ImageLoader.loadImageIcon(pathToPic, 50);
            this.defend.setIcon(defSel);

            pathToPic = "/com/pokechess/gui/images/skill/";
            pathToPic = pathToPic + path + "-unite.png";
            ImageIcon uniSel = ImageLoader.loadImageIcon(pathToPic, 50);
            this.unite.setIcon(uniSel);

            switch(selectManager.addPokemon(path, pokemonNums)){
                case 1 -> JOptionPane.showMessageDialog(this, "Pokemon already exist!");
                case 2 -> JOptionPane.showMessageDialog(this, "You have exceeded the maximum battle type!");
                default -> {
                    pathToPic = "/com/pokechess/gui/images/cards/pokemoncards/card-";
                    pathToPic = pathToPic + path.toLowerCase() + ".png";
                    System.out.println(pathToPic);
                    ImageIcon pickedPokemon = ImageLoader.loadImageIcon(pathToPic, 100);
                    this.cards[pokemonNums].setIcon(pickedPokemon);
                    pokemonNums++;
                    break;
                }

            }

            if(pokemonNums == 5){
                this.cont.setVisible(true);
                this.contText.setVisible(true);
            }
        }
    }

}
