package com.pokechess.managers;

import com.pokechess.gui.*;
import com.pokechess.player.Player;

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
    AttackNames attackName;
    DefendNames defendName;

    public Player player = new Player(), enemy = new Player();
    public PokemonSelectManager selector;

    public BattleScreenManager(Frame frame, GameManager manager, BoardManager boardManager) {
        this.gameManager = manager;
        this.boardManager = boardManager;
        this.selector = new PokemonSelectManager(boardManager);
        getRandomPokemons();
        this.gui = new BattleScreen(this, frame);
    }

    public void getRandomPokemons() {
        int choice = ThreadLocalRandom.current().nextInt(0, names.length - 1);
        selector.addPokemonToTeam(names[choice].toString(), selector.identifyBattleType(names[choice].toString()), this.player, 6);
        System.out.println(this.player.getPokemon(0).getName());
        choice = ThreadLocalRandom.current().nextInt(0, names.length - 1);
        selector.addPokemonToTeam(names[choice].toString(), selector.identifyBattleType(names[choice].toString()), this.enemy, 6);
        System.out.println(this.enemy.getPokemon(0).getName());
    }

    public void battle(int choice){
        if(player.getPokemon(0).getCurrentHealth() != 0 && enemy.getPokemon(0).getCurrentHealth() != 0 && !someoneRan){
            if(turn % 2 == 0){          //PLAYER
                player.getPokemon(0).setProtection(false);
                System.out.println("");
                switch(choice){
                    case 1 -> attack(this.player, this.enemy);
                    case 2 -> defend(this.player);
                    case 3 -> heal(this.player);
                    case 4 -> run(this.player);
                }
            } else if(turn % 2 == 1){   //ENEMY
                enemy.getPokemon(0).setProtection(false);
                choice = ThreadLocalRandom.current().nextInt(1, 100);
                if((float)enemy.getPokemon(0).getCurrentHealth() / (float)enemy.getPokemon(0).getMaxHp() > (float) 0.80){
                    if(choice > 25)
                        attack(this.enemy, this.player);
                    else
                        defend(this.enemy);
                } else if ((float)enemy.getPokemon(0).getCurrentHealth() / (float)enemy.getPokemon(0).getMaxHp() > (float) 0.50){
                    if(choice <= 52)
                        attack(this.enemy, this.player);
                    else if(choice <= 95)
                        defend(this.enemy);
                    else{
                        if(Objects.equals(this.enemy.getPokemon(0).getBattleType(), "sup"))
                            heal(this.enemy);
                        else
                            run(this.enemy);
                    }
                } else if ((float)enemy.getPokemon(0).getCurrentHealth() / (float)enemy.getPokemon(0).getMaxHp() > (float) 0.20) {
                    if(choice <= 40)
                        attack(this.enemy, this.player);
                    else if (choice <= 83)
                        defend(this.enemy);
                    else{
                        if(Objects.equals(this.enemy.getPokemon(0).getBattleType(), "sup"))
                            heal(this.enemy);
                        else
                            run(this.enemy);
                    }
                } else {
                    if(choice <= 45)
                        defend(this.enemy);
                    else{
                        if(Objects.equals(this.enemy.getPokemon(0).getBattleType(), "sup"))
                            heal(this.enemy);
                        else
                            run(this.enemy);
                    }
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
        System.out.println("CURRENT RECIPIENT HP: " + recipient.getPokemon(0).getCurrentHealth());
        if(recipient.getPokemon(0).isDefendProtected()) {
            System.out.println("DEFENSE MECHANISMS OF POKEMON IS CURRENTLY ACTIVATED");
            recipient.getPokemon(0).setCurrentHealth(recipient.getPokemon(0).getCurrentHealth() - (int) (totalDamage * 0.8));
        }else {
            System.out.println("DEFENSE MECHANISMS OF POKEMON IS NOT ACTIVATED");
            recipient.getPokemon(0).setCurrentHealth(recipient.getPokemon(0).getCurrentHealth() - totalDamage);
        }
        if(recipient.getPokemon(0).getCurrentHealth() <= 0)
            recipient.getPokemon(0).setCurrentHealth(0);
        System.out.println("NEW RECIPIENT HP: " + recipient.getPokemon(0).getCurrentHealth());
        attackName = AttackNames.valueOf(sender.getName(0));
        System.out.println(attackName.getDisplayBattleAction());
        if(recipient.getPokemon(0).getCurrentHealth() == 0)
            commentator = sender.getName(0) + " has defeated " + recipient.getName(0) + " using " + attackName.getDisplayBattleAction();
        else
            commentator = sender.getName(0) + " has attacked " + recipient.getName(0) + " using " + attackName.getDisplayBattleAction();
    }

    public void defend(Player player){
        player.getPokemon(0).setProtection(true);
        defendName = DefendNames.valueOf(player.getName(0));
        commentator = player.getName(0) + " has activated their " + defendName.getDisplayDefendAction() +"!";
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
        int probability = ThreadLocalRandom.current().nextInt(1, 10);
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