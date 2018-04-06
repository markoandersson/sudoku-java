package sudoku.domain;

import java.util.List;

/**
 * Presents single row of numbers in standard sudoku board. Accepts nine cells to be grouped as single row. If one cell resolved, other cells in this row will be notified.
 */
public class StandardRow extends AbstractGroupOfCells implements Row {

    public StandardRow(List<Cell> cells) {
        super(cells);
    }

    @Override
    public String toString(String delimiter) {

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= cells.size(); i++) {
            sb.append(cells.get(i - 1));

            if (i % 3 == 0) {
                sb.append("|");
            } else {
                sb.append(" ");
            }
        }
        return sb.toString();

    }

    @Override
    public void accept(SudokuVisitor visitor) {
        visitor.visit(this);
    }
}
