package com.pokechess.board;

public class Position {
    protected int x, y;
    //X IS COLUMN
    //Y IS ROW

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

    //ROW
    public int getRow(){
        return y;
    }
    //COLUMN
    public int getColumn(){
        return x;
    }

}