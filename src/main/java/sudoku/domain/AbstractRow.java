package sudoku.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.unmodifiableCollection;

/**
 * Abstract row which contains generic functionality for row, not dependent on exact type of game board.
 */
public abstract class AbstractRow implements Row {

    private final List<Cell> cells;

    AbstractRow(List<Cell> cells) {

        this.cells = new ArrayList<>(cells);
        cells.forEach(cell -> cell.addListener(this));

    }

    public void cellSolved(int resolvedNumber) {

        cells.stream()
                .filter(cell -> !cell.isSolved())
                .forEach(cell -> cell.removePossibility(resolvedNumber));
    }

    @Override
    public void solve(GroupOfCellsSolver solver) {

        solver.solve(unmodifiableCollection(this.cells));
    }
}
