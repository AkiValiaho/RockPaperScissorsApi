package com.valiaho.rockpaperscissors.domain;

import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Created by akivv on 16.9.2019.
 */
public class GameEntityFactory {
    private static final Map<String, Supplier<GameEntity>> gameEntityNamesMap = Map.of("rock", Rock::new, "paper", Paper::new, "scissors", Scissors::new);
    private static final Map<Integer, Supplier<GameEntity>> gameEntityNumbersMap = Map.of(1, Rock::new, 2, Paper::new, 3, Scissors::new);

    public static GameEntity getRandomPlayed() {
        Random random = new Random();
        int randomToChoose = random.nextInt(3) + 1;
        return gameEntityNumbersMap.get(randomToChoose).get();
    }

    public static Optional<GameEntity> from(String played) {
        return Optional.ofNullable(gameEntityNamesMap.get(played.toLowerCase()).get());
    }

}
