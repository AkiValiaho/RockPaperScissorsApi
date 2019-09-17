package com.valiaho.rockpaperscissors.playaround.domain;

import java.util.Set;

/**
 * Created by akivv on 16.9.2019.
 */
class Rock extends GameEntity {
    private Set<GameEntityType> beats = Set.of(GameEntityType.SCISSORS);

    @Override
    public boolean beats(GameEntity gameEntity) {
        return beats.contains(gameEntity.getType());
    }

    @Override
    public String getName() {
        return "rock";
    }

    @Override
    public GameEntityType getType() {
        return GameEntityType.ROCK;
    }
}
