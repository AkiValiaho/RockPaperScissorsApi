package com.valiaho.rockpaperscissors.playaround;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.valiaho.rockpaperscissors.playaround.domain.GameEntity;
import com.valiaho.rockpaperscissors.playaround.domain.GameEntityFactory;

/**
 * Created by akivv on 16.9.2019.
 */
@SpringComponent
class GameService {
    Tuple<String, GameResult> processRound(String played) {
        GameEntity randomPlayed = GameEntityFactory.getRandomPlayed();
        GameEntity playersChoice = GameEntityFactory.from(played).orElseThrow(() -> new RuntimeException("Game entity not recognized"));
        if (randomPlayed.beats(playersChoice)) {
            return new Tuple<>("The computer picked " + randomPlayed.getName() + ", you lose", GameResult.LOSS);
        }
        if (playersChoice.beats(randomPlayed)) {
            return new Tuple<>("You beat computer who chose: " + randomPlayed.getName() + "!", GameResult.WIN);
        }
        return new Tuple<>("It's a draw! Computer picked " + randomPlayed.getName(), GameResult.DRAW);
    }

    public enum GameResult {
        WIN, LOSS, DRAW
    }

    static class Tuple<T, T1> {
        private final T1 secondParam;
        private final T firstParam;

        Tuple(T firstParam, T1 secondParam) {
            this.firstParam = firstParam;
            this.secondParam = secondParam;
        }

        T getleft() {
            return firstParam;
        }

        T1 getright() {
            return secondParam;
        }
    }
}
