package com.pokechess.managers;

import com.pokechess.gui.Frame;
import com.pokechess.gui.ShowcasePokemon;
import com.pokechess.player.Player;

import java.util.Random;

public class ComputerManager {
    public GameManager gameManager;
    BoardManager manager;
    PokemonSelectManager selector;
    public Player computer;
    public Player ally;

    private final ShowcasePokemon gui;

    public ComputerManager(GameManager gmgr, BoardManager mgr, Frame frame){
        this.gameManager = gmgr;
        this.manager = mgr;
        this.selector = new PokemonSelectManager(manager);
        this.computer = manager.computer;
        this.ally = manager.player;

        this.gui = new ShowcasePokemon(this, frame);
    }
    public void selectPokemon(){
        String[] names = {"SYLVEON", "GARDEVOIR", "PIKACHU", "GRENINJA", "VENUSAUR", "NINETALES",
                "CRAMORANT", "CINDERACE", "ZERAORA", "TALONFLAME", "ABSOL", "GENGAR", "CHARIZARD", "LUCARIO",
                "MACHAMP", "GARCHOMP", "MAMOSWINE", "BLASTOISE", "SNORLAX", "CRUSTLE", "SLOWBRO", "BLISSEY",
                "ELDEGOSS", "MRMIME", "WIGGLYTUFF"};  //25 ALL IN ALL
        Random rnd = new Random();
        int choice;

        for(int i = 0; i < 5; i++){
            boolean loop;
            do {
                choice = rnd.nextInt(24);
                if (!selector.hasExistPokemon(names[choice], i, computer)) {
                    if (i > 1) {
                        loop = selector.hasMaxType(names[choice], i, computer);
                    }
                    else
                        loop = false;
                }
                else
                    loop = true;
            } while(loop);
            selector.addPokemonToTeam(i, names[choice], selector.identifyBattleType(names[choice]), computer, 6);
        }

    }

    public ShowcasePokemon getGui(){
        return gui;
    }


}
