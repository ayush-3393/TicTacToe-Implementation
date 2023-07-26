package org.example.Models;

import lombok.Getter;
import lombok.Setter;
import org.example.Exceptions.InvalidBoardDimensionException;
import org.example.Exceptions.InvalidCountOfPlayersException;
import org.example.Models.Enums.GameStatus;

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

    private Game(){
    }

    public static  class Builder {
        private int dimension;
        private List<Player> listOfPlayers;

        public Builder(List<Player> listOfPlayers) {
            this.listOfPlayers = listOfPlayers;
        }

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
            return game;
        }

    }


}
