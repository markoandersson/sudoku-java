package sudoku.domain;

import java.util.List;

/**
 * Abstract row which contains generic functionality for row, not dependent on exact type of game board.
 */
public class AbstractRow implements Row {

    private final List<Cell> cells;

    AbstractRow(List<Cell> cells) {

        cells.forEach(cell -> cell.addListener(this));

        this.cells = cells;
    }

    public void cellSolved(int resolvedNumber) {

        cells.stream()
                .filter(cell -> !cell.isSolved())
                .forEach(cell -> cell.removePossibility(resolvedNumber));
    }
}
