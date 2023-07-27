package org.example.Strategies.GameStrategies;

import org.example.Models.Board;
import org.example.Models.Cell;
import org.example.Models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostOptimalGameWinningStrategy implements GameWinningStrategy {

    private final int dimension;
    private final List<Map<Character, Integer>> listOfMapsOfEachRow = new ArrayList<>();
    private final List<Map<Character, Integer>> listOfMapsOfEachCol = new ArrayList<>();
    private final Map<Character, Integer> mapOfPrimaryDiagonal = new HashMap<>();
    private final Map<Character, Integer> mapOfSecondaryDiagonal = new HashMap<>();

    public MostOptimalGameWinningStrategy(int dimension){
        this.dimension = dimension;
        // the count of maps in each row anc in each column will be same as the dimension
        for (int i=0; i<this.dimension; i++){
            listOfMapsOfEachRow.add(new HashMap<>());
            listOfMapsOfEachCol.add(new HashMap<>());
        }
    }
    private boolean isCellOnPrimaryDiagonal(Cell cell){
        if (cell.getRow() == cell.getCol()){
            return true;
        }
        return false;
    }

    private boolean isCellOnSecondaryDiagonal(Cell cell){
        if (cell.getRow() + cell.getCol() - 1 == this.dimension){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkWinner(Board board, Player playerToMove, Cell cell) {
        // In the cell where the current move is made check the count of characters
        // in the row, col and both diagonals(if the cell is on either of them)
        Character symbol = playerToMove.getSymbol();
        int row = cell.getRow();
        int col = cell.getCol();

        Map<Character, Integer> rowMap = listOfMapsOfEachRow.get(row);
        rowMap.put(symbol, rowMap.getOrDefault(symbol, 0)+1);
        if (rowMap.get(symbol) == this.dimension){
            return true;
        }

        Map<Character, Integer> colMap = listOfMapsOfEachCol.get(col);
        colMap.put(symbol, colMap.getOrDefault(symbol, 0)+1);
        if (colMap.get(symbol) == this.dimension){
            return true;
        }

        if (isCellOnPrimaryDiagonal(cell)){
            mapOfPrimaryDiagonal.put(symbol, mapOfPrimaryDiagonal.getOrDefault(symbol, 0)+1);
            if (mapOfPrimaryDiagonal.get(symbol) == this.dimension){
                return true;
            }
        }
        if (isCellOnSecondaryDiagonal(cell)){
            mapOfSecondaryDiagonal.put(symbol, mapOfSecondaryDiagonal.getOrDefault(symbol, 0)+1);
            if (mapOfSecondaryDiagonal.get(symbol) == this.dimension){
                return true;
            }
        }

        return false;
    }
}
