package com.pokechess.managers;

import com.pokechess.gui.BattleScreen;
import com.pokechess.gui.Frame;
import com.pokechess.gui.PokemonNames;
import com.pokechess.player.Player;
import com.pokechess.player.Pokemon;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class BattleScreenManager {
    private GameManager gameManager;
    private BoardManager boardManager;
    private BattleScreen gui;
    public int turn = ThreadLocalRandom.current().nextInt(0, 10);
    // 1 % 2 == 1 : ENEMY
    // 2 % 2 == 0 : PLAYER
    private boolean someoneRan = false;
    private String commentator = "";

    PokemonNames[] names = PokemonNames.values();

    public Player player = new Player(), enemy = new Player();
    public PokemonSelectManager selector;

    public BattleScreenManager(Frame frame, GameManager manager, BoardManager boardManager) {
        this.gameManager = manager;
        this.boardManager = boardManager;
        this.selector = new PokemonSelectManager(boardManager);
        this.gui = new BattleScreen(this, frame);
    }

    public void getRandomPokemons() {
        int choice = ThreadLocalRandom.current().nextInt(0, names.length);
        selector.addPokemonToTeam(names[choice].toString(), selector.identifyBattleType(names[choice].toString()), this.player, 6);
        choice = ThreadLocalRandom.current().nextInt(0, names.length);
        selector.addPokemonToTeam(names[choice].toString(), selector.identifyBattleType(names[choice].toString()), this.enemy, 6);
    }

    public void battle(int choice){
        if(player.getPokemon(0).getCurrentHealth() != 0 && enemy.getPokemon(0).getCurrentHealth() != 0 && !someoneRan){
            if(turn % 2 == 0){
                player.getPokemon(0).setProtection(false);
                System.out.println("");
                switch(choice){
                    case 1 -> attack(this.player, this.enemy);
                    case 2 -> defend(this.player);
                    case 3 -> heal(this.player);
                    case 4 -> run(this.player);
                }
            } else if(turn % 2 == 1){
                enemy.getPokemon(0).setProtection(false);
                switch(choice){
                    case 1 -> attack(this.enemy, this.player);
                    case 2 -> defend(this.enemy);
                    case 3 -> heal(this.enemy);
                    case 4 -> run(this.enemy);
                }
            }
            turn++;
        } else {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
    }

    public String getCommentator(){
        return commentator;
    }

    public void attack(Player sender, Player recipient){
        int attackDamage = (int)Math.ceil(recipient.getPokemon(0).getMaxHp() * sender.getPokemon(0).getAttack());
        int defenseBuffer = (int)Math.ceil(attackDamage * recipient.getPokemon(0).getDefense());
        int totalDamage = attackDamage - defenseBuffer;
        System.out.println(recipient.getPokemon(0).getCurrentHealth());
        if(recipient.getPokemon(0).isDefendProtected())
            recipient.getPokemon(0).setCurrentHealth(recipient.getPokemon(0).getCurrentHealth() - (int)(totalDamage * 0.8));
        else
            recipient.getPokemon(0).setCurrentHealth(recipient.getPokemon(0).getCurrentHealth() - totalDamage);
        if(recipient.getPokemon(0).getCurrentHealth() <= 0)
            recipient.getPokemon(0).setCurrentHealth(0);
        System.out.println(recipient.getPokemon(0).getCurrentHealth());
        if(recipient.getPokemon(0).getCurrentHealth() == 0)
            commentator = sender.getName(0) + " has defeated " + recipient.getName(0);
        else
            commentator = sender.getName(0) + " has attacked " + recipient.getName(0) + "!";
    }

    public void defend(Player player){
        player.getPokemon(0).setProtection(true);
        commentator = player.getName(0) + " has activated their defense!";
    }

    public boolean heal(Player sender){
        if(Objects.equals(sender.getPokemon(0).getBattleType(), "sup")) {
            System.out.println("HEAL POSSIBLE!");
            commentator = sender.getName(0) + " has healed their team!";
            return true;
        }
        commentator = sender.getName(0) + " failed to heal their teammate!";
        return false;

    }

    public void run(Player player){
        int probability = ThreadLocalRandom.current().nextInt(1, 11);
        if(probability < 4) {
            someoneRan = true;
            commentator = player.getName(0) + " ran away!";
        } else
            commentator = player.getName(0) + " tried running away, but failed!";
    }

    public BattleScreen getGui() {
        return gui;
    }

}