package org.example.Models;

import lombok.Getter;
import lombok.Setter;
import org.example.Exceptions.InvalidBoardDimensionException;
import org.example.Exceptions.InvalidCountOfPlayersException;
import org.example.Models.Enums.CellState;
import org.example.Models.Enums.GameStatus;
import org.example.Strategies.GameStrategies.GameWinningStrategy;
import org.example.Strategies.GameStrategies.MostOptimalGameWinningStrategy;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
public class Game {
    private Board board;
    private List<Player> listOfPlayers;
    private List<Move> listOfMoves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;
    private Player winner;
    private GameWinningStrategy gameWinningStrategy;

    private Game(){
    }

    public void displayCurrBoard(){
        board.displayBoard();
    }

    public void makeNextMove(){
        Player playerToMove = listOfPlayers.get(nextPlayerIndex);
//        System.out.println("NPI = " + nextPlayerIndex);
        System.out.println("It is " +
                playerToMove.getName() +
                "'s turn to move");
        Move move = playerToMove.decideMove(this.board);

        System.out.println(playerToMove.getName() +
                " is playing the move at " +
                "row = " + move.getCell().getRow() +
                " and col = " + move.getCell().getCol());

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        board.getBoard().get(row).get(col).setPlayer(playerToMove);

        this.listOfMoves.add(move);
//        System.out.println("---------");

        if (gameWinningStrategy.checkWinner(this.board, playerToMove, move.getCell())){
            this.setGameStatus(GameStatus.WIN);
            winner = playerToMove;
        }

        nextPlayerIndex += 1;
//        System.out.println("NPI2 = " + nextPlayerIndex);
        nextPlayerIndex %= listOfPlayers.size();
//        System.out.println("NPI3 = " + nextPlayerIndex);
    }


 //--------------------------Builder Class Below-----------------------------
    public static Builder builder(){
        return new Builder();
    }

    public static  class Builder {
        private int dimension;
        private List<Player> listOfPlayers;
        public Builder withDimension(int dimension){
            this.dimension = dimension;
            return this;
        }
        public Builder withPlayers(List<Player> listOfPlayers){
            this.listOfPlayers = listOfPlayers;
            return this;
        }

        private boolean isValid(){
            if (this.dimension < 3){
                throw new InvalidBoardDimensionException("Dimensions of the board should not be less than 3");
            }
            if (this.listOfPlayers.size() >= dimension){
                throw new InvalidCountOfPlayersException("Number of players should be less than the dimension");
            }
            return true;
        }

        public Game build(){
            isValid();
            Game game = new Game();
            game.board = new Board(this.dimension);
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setListOfMoves(new ArrayList<>());
            game.setNextPlayerIndex(0);
            game.listOfPlayers = this.listOfPlayers;
            game.setGameWinningStrategy(new MostOptimalGameWinningStrategy(dimension));
            return game;
        }

    }


}
