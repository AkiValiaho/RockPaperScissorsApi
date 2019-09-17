package com.valiaho.rockpaperscissors.domain;

import java.util.Set;

/**
 * Created by akivv on 16.9.2019.
 */
public class Paper extends GameEntity {

    private Set<GameEntityType> beats = Set.of(GameEntityType.ROCK);

    @Override
    public boolean beats(GameEntity gameEntity) {
        return beats.contains(gameEntity.getType());
    }

    @Override
    public String getName() {
        return "paper";
    }

    @Override
    public GameEntityType getType() {
        return GameEntityType.PAPER;
    }
}
