package com.bilgeadam.xox.game;

import com.bilgeadam.xox.R;

public enum Players {
    X(1, R.drawable.x),
    O(2, R.drawable.o);

    private final int value, drawable;
    private int currentTurn;


    Players(int value, int drawable) {
        this.value = value;
        this.drawable = drawable;
        currentTurn = 1;
    }

    public int getDrawable() {
        return drawable;
    }

    protected int getValue() {
        return value;
    }

    Players getNextPlayer(){
        return this.ordinal() == X.ordinal() ? O : X;
    }
    protected void incrementTurn(){
        this.currentTurn++;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    /**
     *
     * @return random player.
     */
    static Players generateRandomPlayer(){
        Players[] players= Players.values();

        return players[(int)Math.round(Math.random() * (players.length-1))];
    }
}
