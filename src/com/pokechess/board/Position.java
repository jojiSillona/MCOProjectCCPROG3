package com.pokechess.board;

public class Position {
    protected int alphabet, number;

    public Position(int number, int alphabet){
        /*
        PLEASE REMEMBER THE FOLLOWING
        -ALPHABET CORRESPONDS TO X POSITION
        -NUMBER CORRESPONDS TO Y POSITION
        -JOBERT
         */
        this.number = number;
        this.alphabet = alphabet;
    }

    public void setAlphabet(int alb){
        this.alphabet = alb;
    }

    public void setNumber(int num){
        this.number = num;
    }

    public int getNumber(){
        return number;
    }
    public int getAlphabet(){
        return alphabet;
    }

}