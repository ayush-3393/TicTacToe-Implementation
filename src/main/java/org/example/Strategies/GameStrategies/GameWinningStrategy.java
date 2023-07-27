package org.example.Strategies.GameStrategies;

import org.example.Models.Board;
import org.example.Models.Cell;
import org.example.Models.Player;

public interface GameWinningStrategy {
    boolean checkWinner(Board board, Player playerToMove, Cell cell);
}
