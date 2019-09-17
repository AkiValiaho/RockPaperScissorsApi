package com.valiaho.rockpaperscissors.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Created by akivv on 16.9.2019.
 */
@Component
public class GameEntityFactory {
    private static final Map<String, Supplier<GameEntity>> gameEntityNamesMap = Map.of("rock", Rock::new, "paper", Paper::new, "scissors", Scissors::new);
    private static final Map<Integer, Supplier<GameEntity>> gameEntityNumbersMap = Map.of(1, Rock::new, 2, Paper::new, 3, Scissors::new);
    @Autowired
    private MessageSource messageSource;

    public GameEntity getRandomPlayed() {
        Random random = new Random();
        int randomToChoose = random.nextInt(3) + 1;
        GameEntity gameEntity = gameEntityNumbersMap.get(randomToChoose).get();
        gameEntity.setMessageSource(messageSource);
        return gameEntity;
    }

    public Optional<GameEntity> from(GameEntity.GameEntityType played) {
        Optional<GameEntity> gameEntity = Optional.ofNullable(gameEntityNamesMap.get(played.name().toLowerCase()).get());
        gameEntity.ifPresent(entity -> entity.setMessageSource(messageSource));
        return gameEntity;
    }

}
