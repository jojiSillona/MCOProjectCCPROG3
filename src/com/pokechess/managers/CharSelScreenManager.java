package com.pokechess.managers;

import com.pokechess.gui.CharacterSelectScreen;
import com.pokechess.gui.Frame;
import com.pokechess.player.Player;

import java.util.Locale;
import java.util.Objects;

public class CharSelScreenManager {
    private GameManager gManager;
    private BoardManager bManager;
    private CharacterSelectScreen gui;

    public Player player;

    public CharSelScreenManager(GameManager gameManager, BoardManager boardManager, Frame frame){
        this.gManager = gameManager;
        this.bManager = boardManager;
        this.player = this.bManager.player;

        this.gui = new CharacterSelectScreen(this, gManager, frame);
    }

    public CharacterSelectScreen getGui() {
        return gui;
    }

    public void addPokemonToTeam(int i, String name, String battleType, Player target, int user){
        String batTypeDisp = "";
        int h = 0;
        float at = 0;
        float de = 0;
        int sp = 0;
        float hR = 0;
        int rR = 0;
        switch (battleType) {
            case "atk" -> {
                batTypeDisp = "atk";
                h = 75;
                at = (float) 0.4;
                de = (float) 0.15;
                sp = 2;
                hR = (float) 0.05;
                rR = 2;
            }
            case "spd" -> {
                batTypeDisp = "spd";
                h = 50;
                at = (float) 0.4;
                de = (float) 0.05;
                sp = 3;
                hR = (float) 0.05;
                rR = 2;
            }
            case "alr" -> {
                batTypeDisp = "alr";
                h = 75;
                at = (float) 0.3;
                de = (float) 0.15;
                sp = 2;
                hR = (float) 0.1;
                rR = 3;
            }
            case "def" -> {
                batTypeDisp = "def";
                h = 100;
                at = (float) 0.2;
                de = (float) 0.25;
                sp = 1;
                hR = (float) 0.05;
                rR = 4;
            }
            case "sup" -> {
                batTypeDisp = "sup";
                h = 100;
                at = (float) 0.2;
                de = (float) 0.05;
                sp = 1;
                hR = (float) 0.15;
                rR = 3;
            }
        }
        target.addPokemon(i, name, batTypeDisp, h, at, de, sp, hR, rR, user, false);
    }

    public String identifyBattleType(String input){
        String battleType;
        switch (input.toUpperCase(Locale.ROOT)) {
            case "SYLVEON", "GARDEVOIR", "PIKACHU", "GRENINJA", "VENUSAUR", "NINETALES", "CRAMORANT", "CINDERACE" -> battleType = "atk";
            case "ZERAORA", "TALONFLAME", "ABSOL", "GENGAR" -> battleType = "spd";
            case "CHARIZARD", "LUCARIO", "MACHAMP", "GARCHOMP" -> battleType = "alr";
            case "MAMOSWINE", "BLASTOISE", "SNORLAX", "CRUSTLE", "SLOWBRO" -> battleType = "def";
            case "BLISSEY", "ELDEGOSS", "MRMIME", "WIGGLYTUFF" -> battleType = "sup";
            default -> battleType = "non";
        }
        return battleType;
    }

    public boolean hasMaxType(String input, int size, Player target){
        int i = 0;
        int count = 0;

        while(i < size && count < 2){
            if(Objects.equals(identifyBattleType(input), target.getType(i)))
                count++;
            i++;
        }
        return count == 2;
    }

    public boolean hasExistPokemon(String input, int size, Player target){
        int i = 0;
        while(i <= size){
            if(Objects.equals(input, target.getName(i))) {
                return true;
            }
            i++;
        }
        return false;
    }

    public int addPokemon(String input, int i){

        //RETURN VALUES
        // 0 = adding pokemon is successful
        // 1 = pokemon already exists in the slate
        // 2 = player already has too much pokemons of the same battle type
        if(!hasExistPokemon(input, i, this.player)) {
            if (i > 1) {
                if (hasMaxType(input, i, this.player))
                    return 2;
            }
        }
        else {
            return 1;
        }

        addPokemonToTeam(i, input, identifyBattleType(input.toUpperCase(Locale.ROOT)), this.player, 0);
        return 0;
    }

}
