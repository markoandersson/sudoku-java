package sudoku.board;

import sudoku.domain.*;
import sudoku.solver.ScanningSolverVisitor;

import java.util.Collections;
import java.util.List;

public class StandardBoard {

    private final List<Row> rows;
    private final List<Column> columns;
    private final List<Grid> grids;

    /**
     * Sudoku board is constructed with 9 rows, each containing 9 cells.
     */
    StandardBoard(List<List<Cell>> board) {

        if (board.size() != 9) {
            throw new IllegalArgumentException("Exactly nine rows expected");
        }
        this.rows = BoardUtils.buildRows(board);
        this.columns = BoardUtils.buildColumns(board);
        this.grids = BoardUtils.buildGrids(board);
    }

    @Override
    public String toString() {

        return BoardUtils.printBoard(this);
    }

    public static StandardBoardBuilder builder() {
        return new StandardBoardBuilder();
    }

    List<Row> getRows() {
        return Collections.unmodifiableList(this.rows);
    }

    List<Column> getColumns() {
        return Collections.unmodifiableList(this.columns);
    }

    public void accept(ScanningSolverVisitor solverVisitor) {

        this.rows.forEach(row -> row.accept(solverVisitor));
        this.columns.forEach(column -> column.accept(solverVisitor));
        this.grids.forEach(grid -> grid.accept(solverVisitor));
    }
}
