package com.valiaho.rockpaperscissors.domain;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Set;

/**
 * Created by akivv on 16.9.2019.
 */
public class Scissors extends GameEntity {
    private Set<GameEntityType> beats = Set.of(GameEntityType.PAPER);
    private MessageSource messageSource;

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public boolean beats(GameEntity gameEntity) {
        return beats.contains(gameEntity.getType());
    }

    @Override
    public String getName() {
        return messageSource.getMessage("scissors", null, LocaleContextHolder.getLocale());
    }

    @Override
    public GameEntityType getType() {
        return GameEntityType.SCISSORS;
    }
}
