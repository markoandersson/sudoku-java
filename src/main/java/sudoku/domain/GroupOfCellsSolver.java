package sudoku.domain;

import java.util.Collection; /**
 * Interface for solvers which solve numbers for cells in {@link GroupOfCells}, aka. rows, columns or grids.
 */
public interface GroupOfCellsSolver {

    void solve(Collection<Cell> cells);
}
