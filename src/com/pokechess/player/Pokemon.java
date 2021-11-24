package com.pokechess.player;

public class Pokemon {
    private String name;
    private String battleType;

    private int xPos;
    private int yPos;

    private int health;
    private int maxHealth;
    private float attack;
    private float totalDamage, attackDamage;

    private float defense, defenseBuffer;
    private int speed;
    private int rHP, rNewHP;



    private int revivalRate;

    public Pokemon(String name, String battleType, float attack, int hp, int speed, float defense, int) {
        this.name = name;
        this.battleType = battleType;

        this.attack = attack;

        this.totalDamage = attackDamage - defenseBuffer;

        // this.rNewHP = rHP - totalDamage; // Receiver's new HP from attack

        this.rNewHP = rHP - (totalDamage * 0.8); // Receiver's new HP from defend




        //rNewHP = rHP - ⌈(totalDamage * 0.8)⌉
        // this.rHP = rNewHP // current health of pokemon
        // totalDamage = attackDamage - defenseBuffer
        // attackDamage = ⌈(rHP * aAttack%)⌉
        // defenseBuffer = ⌈(attackDamage * rDefense%)⌉





    }
    public void move(String direction){


    }
    public void setAttacker(String direction){


    }
    public void setSpeedster(String direction){


    }
    public void setDefender(String direction){


    }
    public void run(String direction){


    }





//    public String getName(){
//        return name;
//    }
//    public int getXpos(){
//        return xPos;
//    }
//    public int getYpos(){
//        return yPos;
//    }
//

}
