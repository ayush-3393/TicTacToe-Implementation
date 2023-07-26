package org.example.Models;

import org.example.Models.Enums.BotDifficultyLevel;
import org.example.Models.Enums.PlayerType;
public class Bot extends Player{
    BotDifficultyLevel botDifficultyLevel;
    public Bot(String name, Character symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
    }

}
