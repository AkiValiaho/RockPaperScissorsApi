package com.valiaho.rockpaperscissors.playaround;

import com.valiaho.rockpaperscissors.domain.GameEntity;
import com.valiaho.rockpaperscissors.domain.GameEntityFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
class GameService {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private GameEntityFactory gameEntityFactory;


    RoundResponse playARound(GameEntity.GameEntityType gameEntity) {
        GameEntity randomPlayed = gameEntityFactory.getRandomPlayed();
        GameEntity playersChoice = gameEntityFactory.from(gameEntity).orElseThrow(() -> new RuntimeException("Game entity not recognized"));
        if (randomPlayed.beats(playersChoice)) {
            return new RoundResponse(messageSource.getMessage("computerPicked", null, LocaleContextHolder.getLocale()) + randomPlayed.getName() + ", you lose", RoundResult.LOSS);
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
            this.result = firstParam;
        }

    }
}
