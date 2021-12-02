package com.pokechess.board;

public class Position {
    protected int alphabet, number;

    public Position(int number, int alphabet){

        this.number = number;
        this.alphabet = alphabet;
    }

    public int getNumber(){
        return number;
    }
    public int getAlphabet(){
        return alphabet;
    }

}