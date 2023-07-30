package org.example.Models;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.Enums.CellState;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {
    private List<List<Cell>> board = new ArrayList<>();
//    private int dimension;
    public Board(int dimension){
        for (int i=0; i<dimension; i++){
            this.board.add(new ArrayList<>());
            for (int j=0; j<dimension; j++){
                this.board.get(i).add(new Cell(i, j));
            }
        }
    }

    public void displayBoard(){
//        System.out.println("Reached here");
        for (int i=0; i<board.size(); i++){
            for (int j=0; j< board.size(); j++){
                Cell currCell = board.get(i).get(j);
                if (currCell.getCellState() == CellState.EMPTY){
                    System.out.print("| |");
                }
                else {
                    System.out.print("| " + currCell.getPlayer().getSymbol() + " |");
                }
            }
            System.out.println();
        }
    }

}
