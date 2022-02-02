package com.pokechess.managers;

import com.pokechess.gui.CharacterSelectScreen;
import com.pokechess.gui.Frame;

import java.awt.*;

public class CharSelScreenManager {

    private CharacterSelectScreen gui;

    public CharSelScreenManager(Frame frame){
        this.gui = new CharacterSelectScreen(frame);

    }

    public CharacterSelectScreen getGui() {
        return gui;
    }
}
