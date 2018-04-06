package sudoku.solver;

import sudoku.board.Board;
import sudoku.domain.SudokuAction;
import sudoku.domain.SudokuActions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class SudokuActionsCollection implements SudokuActions {

    private Collection<SudokuAction> actions = new ArrayList<>();

    @Override
    public void execute(final Board board) {

        actions.forEach(board::accept);
    }

    void add(final SudokuAction action) {

        if (!actions.contains(action)) {
            actions.add(action);
        }
    }

    @Override
    public Iterator<SudokuAction> iterator() {
        return actions.iterator();
    }
}
