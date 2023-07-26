package org.example.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.Models.Enums.CellState;
@AllArgsConstructor
@Getter
@Setter
public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellState cellState;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
