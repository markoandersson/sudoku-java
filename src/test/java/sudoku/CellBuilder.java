package sudoku;

import sudoku.domain.Cell;
import sudoku.domain.StandardCell;

import java.util.ArrayList;
import java.util.List;

public class CellBuilder {

    private final List<Cell> cells = new ArrayList<>();

    public static CellBuilder builder() {
        return new CellBuilder();
    }

    private CellBuilder() {

        for (int i = 0; i < 9; i++) {
            this.cells.add(new StandardCell());
        }
    }

    public List<Cell> build() {
        return cells;
    }

    public CellBuilder withCell(Cell cell) {

        return withCells(cell);
    }

    /**
     * Removes possibility from all generated cells
     */
    public CellBuilder withoutPossibility(Integer number) {
        this.cells.forEach(cell -> cell.removePossibility(number));
        return this;
    }

    public CellBuilder withCells(Cell... cells) {

        for (int i = 0; i < cells.length; i++) {
            this.cells.set(i, cells[i]);
        }

        return this;
    }
}
