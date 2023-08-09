package org.example.Factories;

import org.example.Models.Enums.BotDifficultyLevel;
import org.example.Strategies.BotStrategies.BotPlayingStrategy;
import org.example.Strategies.BotStrategies.EasyBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel difficultyLevel){
        if (difficultyLevel == BotDifficultyLevel.EASY){
            return new EasyBotPlayingStrategy();
        }
        return null;
    }
}
