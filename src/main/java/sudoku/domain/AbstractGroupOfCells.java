package sudoku.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableCollection;

/**
 * Abstract row which contains generic functionality for row, not dependent on exact type of game board.
 */
public abstract class AbstractGroupOfCells implements CellSolvedListener, GroupOfCells {

    protected final List<Cell> cells;

    AbstractGroupOfCells(List<Cell> cells) {

        if (cells.size() != 9) {
            throw new IllegalArgumentException("Exactly nine cells expected");
        }

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

    @Override
    public boolean isSolved() {
        return this.cells.stream().allMatch(Cell::isSolved);
    }

    @Override
    public String toString() {
        return this.cells.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }

}
