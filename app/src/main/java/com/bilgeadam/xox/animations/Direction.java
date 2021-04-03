package com.bilgeadam.xox.animations;

enum Direction {
    Left,
    Right,
    Up,
    Bottom;

    static Direction generateRandomDirection(){
        Direction[] directions=Direction.values();
        int index = (int) Math.round(Math.random() * (directions.length-1));

        return directions[index];
    }
}
