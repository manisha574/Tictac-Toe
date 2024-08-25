package Controllers;

import exceptions.MoreThanOneBotException;
import exceptions.PlayerCountMismatchException;
import models.Game;
import models.GameState;
import models.Player;
import strategies.winningstrategy.WinningStrategy;

import java.util.List;

// Controllers are stateless.
public class GameController {

    public Game startGame(int dimensionsOfBoard,
                          List<Player> players,
                          List<WinningStrategy> winningStrategies) throws PlayerCountMismatchException, MoreThanOneBotException {
        return Game
                .getBuilder()
                .setPlayers(players)
                .setDimension(dimensionsOfBoard)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public GameState checkState(Game game) {
        return game.getGameState();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }

    public void undo(Game game) {
        game.undo();
    }
}