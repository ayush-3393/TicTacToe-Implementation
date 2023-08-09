package org.example.Strategies.BotStrategies;

import org.example.Models.Board;
import org.example.Models.Move;
import org.example.Models.Player;

public interface BotPlayingStrategy {
    Move makeBotMove(Player player, Board board);
}
