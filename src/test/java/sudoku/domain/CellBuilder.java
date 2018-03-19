package sudoku.domain;

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

        this.cells.set(0, cell);
        return this;
    }
}
