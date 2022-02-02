package com.pokechess.managers;

import com.pokechess.gui.Frame;
import com.pokechess.gui.TitleScreen;

public class TitleScreenManager {
    private TitleScreen gui;

    public TitleScreenManager(Frame frame){
        this.gui = new TitleScreen(frame);
    }

    public TitleScreen getGui() {
        return gui;
    }
}
