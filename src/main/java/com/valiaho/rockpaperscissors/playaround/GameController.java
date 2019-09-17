package com.valiaho.rockpaperscissors.playaround;

import com.valiaho.rockpaperscissors.domain.GameEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by akivv on 16.9.2019.
 */
@RestController("/api/v1")
class GameController {
    @Autowired
    private GameService gameService;

    @PostMapping("/play")
    public GameService.RoundResponse playARound(GameEntity.GameEntityType gameEntity) {
        return gameService.playARound(gameEntity);
    }

}
