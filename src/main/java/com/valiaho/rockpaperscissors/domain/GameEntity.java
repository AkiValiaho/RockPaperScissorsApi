package com.valiaho.rockpaperscissors.domain;

/**
 * Created by akivv on 16.9.2019.
 */
public abstract class GameEntity {
    public abstract boolean beats(GameEntity gameEntity);

    public abstract String getName();

    public abstract GameEntityType getType();

    enum GameEntityType {
        PAPER, ROCK, SCISSORS
    }
}
