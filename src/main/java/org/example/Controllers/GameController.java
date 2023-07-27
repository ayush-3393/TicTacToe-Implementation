package org.example.Controllers;

import org.example.Models.Enums.GameStatus;
import org.example.Models.Game;
import org.example.Models.Player;

import java.util.List;

public class GameController {

    public Game createGame(int dimensions, List<Player> listOfPlayers){
        try {
            return Game.builder()
                    .withPlayers(listOfPlayers)
                    .withDimension(dimensions)
                    .build();
        } catch (Exception e){
            return null;
        }
    }

    public void displayBoard(Game game){
        game.displayCurrBoard();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public void executeNextMove(Game game){
        game.makeNextMove();
    }

}
