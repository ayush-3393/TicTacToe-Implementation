package org.example.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.Models.Enums.CellState;
import org.example.Models.Enums.PlayerType;

import java.util.Scanner;

@AllArgsConstructor
@Getter
@Setter
public class Player {
    private String name;
    private Character symbol;
    private PlayerType playerType;

    public Move decideMove(Board board){
        Scanner scanner = new Scanner(System.in);
        System.out.println("PLease enter the row for the move");
        int row = scanner.nextInt();
        System.out.println("PLease enter the col for the move");
        int col = scanner.nextInt();
        Cell currCell = new Cell(row, col, this, CellState.FILLED);
        return new Move(this, currCell);
    }

}
