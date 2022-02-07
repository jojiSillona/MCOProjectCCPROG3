package com.pokechess.managers;

import com.pokechess.gui.Frame;
import com.pokechess.gui.TitleScreen;

public class TitleScreenManager {
    private GameManager gameManager;
    private TitleScreen gui;

    public TitleScreenManager(GameManager manager, Frame frame){
        this.gameManager = manager;
        this.gui = new TitleScreen(this, frame);
    }

    public void openCharacterSelect(){

        this.gameManager.showCharSelect();
    }

    public TitleScreen getGui() {
        return gui;
    }
}
