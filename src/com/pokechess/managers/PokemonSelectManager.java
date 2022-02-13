package com.pokechess.managers;

import com.pokechess.player.Player;

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class PokemonSelectManager {
    Scanner scn = new Scanner(System.in);
    private String input;


    public BoardManager mainGame;
    public Player player;

    public PokemonSelectManager(BoardManager manager){
        this.mainGame = manager;
        player = mainGame.player;
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
        target.addPokemon(i, name, batTypeDisp, h, at, de, sp, hR, rR, user, true);
    }

    public void addPokemonToTeam(String name, String battleType, Player target, int user){
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
        target.addPokemon(name, batTypeDisp, h, at, de, sp, hR, rR, user, true);
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

    public void showPokemonSelect(){

        System.out.println("SELECT YOUR POKEMON:");
        System.out.println("ATTACKERS:");
        System.out.println("1. Sylveon\n2. Gardevoir\n3. Pikachu\n4. Greninja\n5. Venusaur\n6. Alolan Ninetales\n7. Cramorant\n8. Cinderace");
        System.out.println("SPEEDSTERS:");
        System.out.println("1. Zeraora\n2. Talonflame\n3. Absol\n4. Gengar");
        System.out.println("ALL-ROUNDERS:");
        System.out.println("1. Charizard\n2. Lucario\n3. Machamp\n4. Garchomp");
        System.out.println("DEFENDERS:");
        System.out.println("1. Mamoswine\n2. Blastoise\n3. Snorlax\n4. Crustle\n5. Slowbro");
        System.out.println("SUPPORTERS:");
        System.out.println("1. Blissey\n2. Eldegoss\n3. Mr. Mime\n4. Wigglytuff");
      
        for(int i = 0; i < 5; i++){
            boolean loop = true;
            do{
                System.out.print("Input Pokemon #" + (i + 1) + ": ");
                input = scn.nextLine();
                if(!Objects.equals(identifyBattleType(input), "non")){
                    if(!hasExistPokemon(input, i, player))
                        if(i > 1){
                            if(hasMaxType(input, i, player))
                                System.out.println("You cannot add this!");
                            else
                                loop = false;
                        } else {
                            loop = false;
                        }
                    else
                        System.out.println(input + " is already in your team! Try again");
                }
                else
                    System.out.println("ERROR: Game does not recognize " + input + ". Please try again.");
            } while(loop);

            addPokemonToTeam(i, input, identifyBattleType(input.toUpperCase(Locale.ROOT)), player, 0);
        }
    }
}
