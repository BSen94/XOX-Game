package com.bilgeadam.xox.game;

import android.util.Log;

import java.io.Serializable;

public class Logic implements Serializable {

    private final int[][] board; //0->empty; 1->x; 2->0
    private Players currentPlayer;

    public Logic() {
        this.board = new int[3][3];
        currentPlayer = Players.generateRandomPlayer();

    }
    public boolean processTurn(int x, int y){
        Log.i(this.getClass().getSimpleName(), String.format("Process turn for x:%d y:%d",x,y));

        board[x][y]=currentPlayer.getValue();

        //TODO - Check game conditions

        //Check if someone win


        //Check for draw
        if (board.length * board[0].length < Players.X.getCurrentTurn() + Players.O.getCurrentTurn())
            return false;


        //Game continues
        currentPlayer.incrementTurn();
        currentPlayer= currentPlayer.getNextPlayer();
        return true;

    }

    public Players getCurrentPlayer(){
        return currentPlayer;
    }

}
