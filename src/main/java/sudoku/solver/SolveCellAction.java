package sudoku.solver;

import sudoku.domain.Cell;
import sudoku.domain.StandardCell;

import java.util.Objects;

/**
 * Action which will solve the given cell with given number.
 */
public class SolveCellAction extends AbstractSudokuAction {

    private final Cell cell;
    private final int number;

    public SolveCellAction(final Cell cell, final int number) {

        this.cell = cell;
        this.number = number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SolveCellAction that = (SolveCellAction) o;
        return number == that.number &&
                Objects.equals(cell, that.cell);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cell, number);
    }

    @Override
    public void visit(final StandardCell cell) {

        if (this.cell.equals(cell)) {
            cell.solve(number);
        }
    }
}
