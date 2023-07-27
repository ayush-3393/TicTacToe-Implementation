package org.example;

import org.example.Controllers.GameController;
import org.example.Models.Bot;
import org.example.Models.Enums.BotDifficultyLevel;
import org.example.Models.Enums.GameStatus;
import org.example.Models.Enums.PlayerType;
import org.example.Models.Game;
import org.example.Models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! Welcome to the Tic-Tac-Toe Game...!!!");

//        System.out.println("Please enter the dimension of the board of your choice : ");
//        int dimension = scanner.nextInt();
//
//        int countOfPTotalPlayers = dimension - 1;
//
//        int countOfHumanPlayers = countOfPTotalPlayers;
//
//        List<Player> listOfPlayers = new ArrayList<>();
//
//
//        System.out.println("Will there be bots playing? y/n");
//        String areBotsPresent = scanner.next();
//
//        if (areBotsPresent.equals("y")){
//            countOfHumanPlayers = countOfHumanPlayers - 1;
//            // since there is one bot
//            System.out.println("Enter Bot Name : ");
//            String botName = scanner.next();
//            System.out.println("Enter Bot Symbol (Only one character) : ");
//            String botSymbol = scanner.next();
//            Bot bot = new Bot(botName, botSymbol.charAt(0), PlayerType.BOT, BotDifficultyLevel.EASY);
//            listOfPlayers.add(bot);
//        }
//
//        for (int i=0; i<countOfHumanPlayers; i++){
//            System.out.println("Enter " + i + "th Player's name");
//            String name = scanner.next();
//            System.out.println("Enter " + i + "th Player's Character (Only one character)");
//            String symbol = scanner.next();
//            Player player = new Player(name, symbol.charAt(0), PlayerType.HUMAN);
//            listOfPlayers.add(player);
//        }
//
//        GameController gameController = new GameController();
//        Game game = gameController.createGame(dimension, listOfPlayers);
//
//        while(game.getGameStatus() == GameStatus.IN_PROGRESS){
//            System.out.println("This is the current board : ");
//            gameController.displayBoard(game);
//            /*
//            * CREATE UNDO FUNCTIONALITY
//            */
//            gameController.executeNextMove(game);
//        }
//
//        System.out.println("Game has ended : ");
//        game.setGameStatus(GameStatus.WIN);
//        System.out.println("The winner is : ");
//        System.out.println(gameController.getWinner(game).getName());

        int dimension = 3;
        List<Player> listOfPlayers = new ArrayList<>();
        GameController gameController = new GameController();
        Game game = gameController.createGame(dimension, listOfPlayers);
        gameController.displayBoard(game);

    }
}