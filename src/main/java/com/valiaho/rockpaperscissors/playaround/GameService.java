package com.valiaho.rockpaperscissors.playaround;

import com.valiaho.rockpaperscissors.domain.GameEntity;
import com.valiaho.rockpaperscissors.domain.GameEntityFactory;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
class GameService {
    RoundResponse playARound(GameEntity.GameEntityType gameEntity) {
        GameEntity randomPlayed = GameEntityFactory.getRandomPlayed();
        GameEntity playersChoice = GameEntityFactory.from(gameEntity).orElseThrow(() -> new RuntimeException("Game entity not recognized"));
        if (randomPlayed.beats(playersChoice)) {
            return new RoundResponse("The computer picked " + randomPlayed.getName() + ", you lose", RoundResult.LOSS);
        }
        if (playersChoice.beats(randomPlayed)) {
            return new RoundResponse("You beat computer who chose: " + randomPlayed.getName() + "!", RoundResult.WIN);
        }
        return new RoundResponse("It's a draw! Computer picked " + randomPlayed.getName(), RoundResult.DRAW);
    }

    public enum RoundResult {
        WIN, LOSS, DRAW
    }

    @Data
    static class RoundResponse {
        private final String text;
        private final GameService.RoundResult result;


        RoundResponse(String secondParam, GameService.RoundResult firstParam) {
            this.text = secondParam;
            this.result= firstParam;
        }

    }
}
