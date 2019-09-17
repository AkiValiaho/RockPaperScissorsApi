package com.valiaho.rockpaperscissors.playaround;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by akivv on 16.9.2019.
 */
@Route
@PreserveOnRefresh
public class MainView extends HorizontalLayout {
    private final List<Paragraph> latestMessages = new ArrayList<>();
    private final GameService gameService;
    private final VerticalLayout messageLayout;
    private Button submitButton;

    public MainView(@Autowired GameService gameService) {
        this.gameService = gameService;

        Label welcomeMessage = new Label("Rock Paper Scissors game");

        Select<String> selectWhatToPlay = createSelectComponent();

        this.submitButton = new Button("Submit");

        Label winsBanner = new Label("Wins: ");
        Label wins = new Label("0");
        Label drawsBanner = new Label("Draws: ");
        Label draws = new Label("0");
        Label lossesBanner = new Label("Losses: ");
        Label losses = new Label("0");

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(welcomeMessage, selectWhatToPlay, this.submitButton, winsBanner, wins, drawsBanner, draws, lossesBanner, losses);
        verticalLayout.setMaxWidth("20%");
        add(verticalLayout);


        messageLayout = new VerticalLayout();
        add(messageLayout);

        this.submitButton.addClickListener(clickEvent -> playRound(selectWhatToPlay.getValue(), wins, losses, draws));
    }

    private void playRound(String playedHand, Label wins, Label losses, Label draws) {
        GameService.Tuple<String, GameService.GameResult> roundResult = gameService.processRound(playedHand);
        GameService.GameResult gameResult = roundResult.getright();
        updateLeaderboard(wins, losses, draws, gameResult);
        refreshlatestMessages(roundResult);
    }

    private void refreshlatestMessages(GameService.Tuple<String, GameService.GameResult> roundResult) {
        messageLayout.removeAll();
        Paragraph paragraph = new Paragraph(roundResult.getleft());
        latestMessages.add(paragraph);
        if (latestMessages.size() > 5) {
            latestMessages.remove(0);
        }
        messageLayout.removeAll();
        for (Paragraph latestMessage : latestMessages) {
            messageLayout.add(latestMessage);
        }
    }

    private void updateLeaderboard(Label wins, Label losses, Label draws, GameService.GameResult gameResult) {
        if (gameResult.equals(GameService.GameResult.DRAW)) {
            draws.setText(String.valueOf(Integer.parseInt(draws.getText()) + 1));
        }
        if (gameResult.equals(GameService.GameResult.LOSS)) {
            losses.setText(String.valueOf(Integer.parseInt(losses.getText()) + 1));
        }
        if (gameResult.equals(GameService.GameResult.WIN)) {
            wins.setText(String.valueOf(Integer.parseInt(wins.getText()) + 1));
        }
    }

    private Select<String> createSelectComponent() {
        Select<String> selectWhatToPlay = new Select<>();
        selectWhatToPlay.setLabel("Make your choice");
        selectWhatToPlay.setItems("Rock", "Paper", "Scissors");
        return selectWhatToPlay;
    }

}
