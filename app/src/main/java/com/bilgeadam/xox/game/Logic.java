package com.bilgeadam.xox.game;

import android.util.Log;

import java.io.Serializable;

public class Logic implements Serializable {

    private final int[][] board; //0->empty; 1->x; 2->0
    private final ScoreCalculator scoreGenerator;
    private Players currentPlayer;


    public Logic() {
        this.board = new int[3][3];
        currentPlayer = Players.generateRandomPlayer();
        currentPlayer.startTurnTime();
        scoreGenerator = new ScoreCalculator(board.length);

        Players.X.resetParameters();
        Players.O.resetParameters();

    }

    /**
     * Process current tyrn to decide next action
     * @param x - Horizontal location clicked
     * @param y - Vertical location clicked
     * @return The state of the game
     */

    public GameState processTurn(int x, int y){
        Log.i(this.getClass().getSimpleName(), String.format("Process turn for x:%d y:%d",x,y));

        board[x][y] = currentPlayer.getValue();
        currentPlayer.endTurnTime();


        //Check if someone win
        if(currentPlayer.getCurrentTurn() >= board.length &&
                (checkStraight(x, 0, true) || checkStraight(0, y,false) ||
                    checkCross(0,0, true) || checkCross(board.length-1, 0, false ))){

            currentPlayer.setScore(scoreGenerator.generateScore(currentPlayer.getCurrentTurn(), currentPlayer.getTotalTurnTime()));
            return GameState.WIN;
        }


        //Check for draw
        if (board.length * board[0].length < Players.X.getCurrentTurn() + Players.O.getCurrentTurn())
            return GameState.DRAW;


        //Game continues
        currentPlayer.incrementTurn();
        currentPlayer = currentPlayer.getNextPlayer();
        currentPlayer.startTurnTime();
        return GameState.CONTINUE;

    }

    private boolean checkStraight(int row, int column, final boolean isRowCheck){
        if (row >= board.length || column >= board.length)
            return true;
        else if (board[row][column] != currentPlayer.getValue())
            return false;
        else
            return isRowCheck ? checkStraight(row, column+1, true) : checkStraight(row+1, column, false);
    }

    private boolean checkCross(int row, int column, final boolean isSameElementCheck){
        if (row >= board.length || column >= board.length)
            return true;
        else if (board[row][column] != currentPlayer.getValue())
            return false;
        else
            return isSameElementCheck ? checkCross(row+1,column+1, true) : checkCross(row-1, column+1, false);

    }

//    private boolean checkCurrentRow(int row){
//        for (int i = 0; i < board.length; i++) {
//          if(board[row][i] != currentPlayer.getValue())
//              return false;
//        }
//        return true;
//
//    }
//    private boolean checkCurrentColumn(int column){
//        for (int i = 0; i < board.length; i++) {
//            if(board[i][column] != currentPlayer.getValue())
//                return false;
//        }
//        return true;
//
//    }
    public Players getCurrentPlayer(){
        return currentPlayer;
    }

}
