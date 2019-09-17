package com.valiaho.rockpaperscissors.domain;

import java.util.Set;

/**
 * Created by akivv on 16.9.2019.
 */
public class Scissors extends GameEntity {
    private Set<GameEntityType> beats = Set.of(GameEntityType.PAPER);

    @Override
    public boolean beats(GameEntity gameEntity) {
        return beats.contains(gameEntity.getType());
    }

    @Override
    public String getName() {
        return "scissors";
    }

    @Override
    public GameEntityType getType() {
        return GameEntityType.SCISSORS;
    }
}
