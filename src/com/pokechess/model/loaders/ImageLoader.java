package com.pokechess.model.loaders;

import com.pokechess.gui.PokemonNames;

import javax.swing.*;
import java.awt.*;
import java.net.URL;


public class ImageLoader {

    //FRAME-RELATED IMAGES
    public static final String ICON = "/com/pokechess/gui/images/frame/star.png";

    //TITLE SCREEN-RELATED IMAGES
    public static final String LOGO = "/com/pokechess/gui/images/titles/logo.png";
    public static final String BG_TITLE = "/com/pokechess/gui/images/bg/background-1.jpg";

    //CHARACTER SELECT SCREEN-RELATED IMAGES
    public static final String BG_CSS = "/com/pokechess/gui/images/bg/background-2.jpg";

    //BUTTONS
    public static final String BUTTON_IDLE = "/com/pokechess/gui/images/button/button-1.png";
    public static final String BUTTON_HOVER = "/com/pokechess/gui/images/button/button-1-selected.png";


    public static final Image loadImage(String path){
        URL resource = ImageLoader.class.getResource(path);
        Image image = Toolkit.getDefaultToolkit().getImage(resource);
        return image;
    }

    public static final ImageIcon loadImageIcon(String path){
        Image image = loadImage(path);
        ImageIcon imageIcon = new ImageIcon(image);
        return imageIcon;
    }

    public static Image loadImage(String path, int width, int height){
        Image image = loadImage(path);
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return image;
    }

    public static ImageIcon loadImageIcon(String path, int width, int height){
        Image image = loadImage(path, width, height);
        ImageIcon imageIcon = new ImageIcon(image);
        return imageIcon;
    }

    public static Image loadImage(String path, int width){
        Image image = loadImage(path);
        ImageIcon imageIcon = new ImageIcon(image);
        float origWidth = imageIcon.getIconWidth();
        float origHeight = imageIcon.getIconHeight();

        float ratio = width / origWidth;
        int height = (int)(origHeight * ratio);

        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return image;
    }

    public static ImageIcon loadImageIcon(String path, int width){
        Image image = loadImage(path, width);
        ImageIcon imageIcon = new ImageIcon(image);
        return imageIcon;
    }

    public static ImageIcon loadImageIcon(PokemonNames name, int width){
        String path = "/com/pokechess/gui/images/pokemonselect/cards/card-";

        path = path + name.name().toLowerCase() + ".png";
        Image image = loadImage(path, width);
        ImageIcon imageIcon = new ImageIcon(image);
        return imageIcon;
    }

}
