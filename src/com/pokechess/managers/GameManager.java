package com.pokechess.managers;

import com.pokechess.gui.CharacterSelectScreen;
import com.pokechess.gui.Frame;

public class GameManager {
    BoardManager mainGame = new BoardManager();
    PokemonSelectManager pokemonSelectManager = new PokemonSelectManager(mainGame);
    ComputerManager computerManager = new ComputerManager(mainGame);

    private Frame frame;

    public GameManager(){
        this.frame = new Frame(1280, 720);
    }

    public void startGame(){
        pokemonSelectManager.askName();
        pokemonSelectManager.showPokemonSelect();
        computerManager.selectPokemon();
        mainGame.setupGame();
        mainGame.runBoard();
    }

    public void run(){
        this.showTitleScreen();
    }

    public void showTitleScreen(){
        TitleScreenManager titleManager =  new TitleScreenManager(this.frame);
        this.frame.setScreen(titleManager.getGui());

    }
    public void showCharSelect(){
        CharSelScreenManager cssManager = new CharSelScreenManager(this.frame);
        this.frame.setScreen(cssManager.getGui());
    }
}
