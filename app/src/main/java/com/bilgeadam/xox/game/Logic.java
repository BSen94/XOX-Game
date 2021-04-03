package com.bilgeadam.xox.game;

import android.util.Log;

import java.io.Serializable;

public class Logic implements Serializable {
    private final int[][] board; //0->empty; 1->x; 2->0
    private Players currentPlayer;
    private int currentTurn;

    public Logic() {
        this.board = new int[3][3];
        currentTurn=1;
        currentPlayer = Players.generateRandomPlayer();

    }
    public void processTurn(int x, int y){
        Log.i(this.getClass().getSimpleName(), String.format("Process turn for x:%d y:%d",x,y));
        board[x][y]=currentPlayer.getValue();

        currentTurn++;
        currentPlayer= currentPlayer.getNextPlayer();

    }
    public String getCurrentPlayerInfo(){
        return currentPlayer.toString();
    }
    public Integer getCurrentTurn(){
        return 5; }
}
