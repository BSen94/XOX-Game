package com.bilgeadam.xox.game;

public enum Players {
    X(1),
    O(2);

    private final int value;


    Players(int value) {
        this.value=value;
    }

    protected int getValue() {
        return value;
    }

    Players getNextPlayer(){
        return this.ordinal() == X.ordinal() ? O : X;
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
