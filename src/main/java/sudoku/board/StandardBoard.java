package sudoku.board;

import sudoku.domain.*;
import sudoku.solver.SolveCellAction;

import java.util.*;
import java.util.stream.Collectors;

public class StandardBoard implements Board {

    private final List<Row> rows;
    private final List<Column> columns;
    private final List<Grid> grids;
    private final List<Cell> cells;

    StandardBoard(String[][] board) {

        if (board.length != 9) {
            throw new IllegalArgumentException("Exactly nine rows expected");
        }

        List<List<Cell>> cells = BoardUtils.buildCells();
        this.rows = BoardUtils.buildRows(cells);
        this.columns = BoardUtils.buildColumns(cells);
        this.grids = BoardUtils.buildGrids(cells);

        this.cells = cells.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        setValues(cells, board);
    }

    private void setValues(List<List<Cell>> cells, String[][] board) {

        for (int i = 0; i < cells.size(); i++) {
            for (int j = 0; j < cells.get(i).size(); j++) {
                String number = board[i][j];
                Cell cell = cells.get(i).get(j);

                solveIfNumber(number, cell);
            }
        }
    }

    private void solveIfNumber(String number, Cell cell) {
        if (!Objects.isNull(number) && Character.isDigit(number.charAt(0))) {
            if (!"0".equals(number)) {
                accept(new SolveCellAction(cell, Integer.parseInt(number)));
            }
        }
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

    @Override
    public void accept(SudokuVisitor visitor) {

        this.rows.forEach(row -> row.accept(visitor));
        this.columns.forEach(column -> column.accept(visitor));
        this.grids.forEach(grid -> grid.accept(visitor));
        this.cells.forEach(cell -> cell.accept(visitor));
    }

    @Override
    public boolean isSolved() {

        return this.cells.stream().allMatch(Cell::isSolved);
    }
}
