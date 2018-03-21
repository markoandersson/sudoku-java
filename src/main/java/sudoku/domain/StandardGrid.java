package sudoku.domain;

import java.util.List;

public class StandardGrid extends AbstractGroupOfCells implements Grid {

    public StandardGrid(List<Cell> cells) {
        super(cells);
    }
}
