package sudoku.domain;

import java.util.List;

public class StandardColumn extends AbstractGroupOfCells implements Column {

    public StandardColumn(List<Cell> cells) {
        super(cells);
    }

    @Override
    public void accept(SudokuVisitor visitor) {
        visitor.visit(this);
    }
}
