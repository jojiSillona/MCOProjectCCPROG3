package com.pokechess.managers;

import com.pokechess.player.Player;

import java.util.Random;

public class ComputerManager {

    BoardManager manager;
    PokemonSelectManager selector;
    Player computer;

    public ComputerManager(BoardManager mgr){
        this.manager = mgr;
        this.selector = new PokemonSelectManager(manager);
        this.computer = manager.computer;
    }
    public void selectPokemon(){
        String[] names = {"SYLVEON", "GARDEVOIR", "PIKACHU", "GRENINJA", "VENUSAUR", "ALOLAN NINETALES",
                "CRAMORANT", "CINDERACE", "ZERAORA", "TALONFLAME", "ABSOL", "GENGAR", "CHARIZARD", "LUCARIO",
                "MACHAMP", "GARCHOMP", "MAMOSWINE", "BLASTOISE", "SNORLAX", "CRUSTLE", "SLOWBRO", "BLISSEY",
                "ELDEGOSS", "MR. MIME", "WIGGLYTUFF"};  //25 ALL IN ALL
        Random rnd = new Random();
        int choice;


        for(int i = 0; i < 5; i++){
            boolean loop = true;
            do {
                choice = rnd.nextInt(25);
                if (!selector.hasExistPokemon(names[choice], i)) {
                    if (i > 1) {
                        if (selector.hasMaxType(names[choice], i))
                            loop = true;
                        else
                            loop = false;
                    }
                    else
                        loop = false;
                }
                else
                    loop = true;
            } while(loop);
            selector.addPokemonToTeam(i, names[choice], selector.identifyBattleType(names[choice]), computer);
        }

    }
}
