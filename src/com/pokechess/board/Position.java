package com.pokechess.board;

public class Position {
    protected int x, y;

    public Position(int y, int x){
        this.y = y;
        this.x = x;
    }
    //get 7
    public void setAlphabet(int alb){
        this.x = alb;
    }

    //get x
    public void setNumber(int num){
        this.y = num;
    }

    public int getNumber(){
        return y;
    }
    public int getAlphabet(){
        return x;
    }

}