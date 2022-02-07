package com.pokechess.managers;

import com.pokechess.gui.CharacterSelectScreen;
import com.pokechess.gui.Frame;

import java.awt.*;

public class CharSelScreenManager {
    private GameManager manager;
    private CharacterSelectScreen gui;

    public CharSelScreenManager(GameManager manager, Frame frame){
        this.manager = manager;
        this.gui = new CharacterSelectScreen(this, frame);

    }

    public CharacterSelectScreen getGui() {
        return gui;
    }
}
