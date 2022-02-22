package com.pokechess.managers;

import com.pokechess.gui.Frame;

public class GameManager {
    private Frame frame;
    BoardManager mainGame;
    BattleScreenManager battleScreenManager;



    public GameManager(){
        this.frame = new Frame(1280, 720);
        mainGame = new BoardManager(this.frame);
    }

    public void run(){
        this.showTitleScreen();
    }

    public void showTitleScreen(){
        TitleScreenManager titleManager =  new TitleScreenManager(this, this.frame);
        this.frame.setScreen(titleManager.getGui());

    }
    public void showCharSelect(){
        CharSelScreenManager cssManager = new CharSelScreenManager(this, this.mainGame, this.frame);
        this.frame.setScreen(cssManager.getGui());
    }

    public void showCasePokemon(){
        ComputerManager compManager = new ComputerManager(this, this.mainGame, this.frame);
        this.frame.setScreen(compManager.getGui());
    }

    public void showBoardScreen(){
        mainGame.setupGame();
        mainGame.initGui();
        this.frame.setScreen(mainGame.getGui());
    }

    public void showBattleScreen(){
        battleScreenManager = new BattleScreenManager(this.frame, this.mainGame);
        battleScreenManager.getRandomPokemons();
        this.frame.setScreen(battleScreenManager.getGui());
    }

}
