package com.valiaho.rockpaperscissors.playaround;

import com.valiaho.rockpaperscissors.domain.GameEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by akivv on 16.9.2019.
 */
@RestController("/api/v1")
@SwaggerDefinition(info = @Info(
        title = "game api", version = "1", description = "Allows for a round of rock paper scissors, i18n enabled with the lang property (eg. ?lang=en"))
class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping("/play")
    public GameService.RoundResponse playARound(GameEntity.GameEntityType gameEntity) {
        return gameService.playARound(gameEntity);
    }

}
