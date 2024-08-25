package strategies.winningstrategy;

import models.Board;
import models.Move;
import models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagWinningStrategy implements WinningStrategy {
    private Map<Symbol, Integer> leftDiag = new HashMap<>();
    private Map<Symbol, Integer> rightDiag = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(row == col) {
            if(!leftDiag.containsKey(symbol)) {
                leftDiag.put(symbol, 0);
            }

            leftDiag.put(symbol, leftDiag.get(symbol) + 1);
        }

        // right diag
        if(row + col == board.getSize() - 1) {
            if(!rightDiag.containsKey(symbol)) {
                rightDiag.put(symbol, 0);
            }

            rightDiag.put(symbol, rightDiag.get(symbol) + 1);
        }

        if(row == col) {
            if(leftDiag.get(symbol) == board.getSize()) {
                return true;
            }
        }

        if(row + col == board.getSize() - 1) {
            if(rightDiag.get(symbol) == board.getSize()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(row == col) {
            leftDiag.put(symbol, leftDiag.get(symbol) - 1);
        }

        if(row + col == board.getSize() - 1) {
            rightDiag.put(symbol, rightDiag.get(symbol) - 1);
        }
    }
}