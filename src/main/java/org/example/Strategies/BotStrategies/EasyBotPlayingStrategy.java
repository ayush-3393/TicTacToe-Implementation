package org.example.Strategies.BotStrategies;

import org.example.Models.Board;
import org.example.Models.Cell;
import org.example.Models.Enums.CellState;
import org.example.Models.Move;
import org.example.Models.Player;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeBotMove(Player player, Board board) {
        for (int i=0; i<board.getBoard().size(); i++){
            for (int j=0; j<board.getBoard().size(); j++){
                Cell currCell = board.getBoard().get(i).get(j);
                if (currCell.getCellState() == CellState.EMPTY){
                    currCell.setPlayer(player);
                    currCell.setCellState(CellState.FILLED);
                    return new Move(player, currCell);
                }
            }
        }
        return null;
    }
}
