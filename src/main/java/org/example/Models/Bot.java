package org.example.Models;

import lombok.Getter;
import lombok.Setter;
import org.example.Factories.BotPlayingStrategyFactory;
import org.example.Models.Enums.BotDifficultyLevel;
import org.example.Models.Enums.PlayerType;
import org.example.Strategies.BotStrategies.BotPlayingStrategy;

public class Bot extends Player{
    @Getter
    @Setter
    BotDifficultyLevel botDifficultyLevel;
    BotPlayingStrategy botPlayingStrategy;
    public Bot(String name, Character symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    public Move decideMove(Board board){
        return botPlayingStrategy.makeBotMove(this, board);
    }

}
