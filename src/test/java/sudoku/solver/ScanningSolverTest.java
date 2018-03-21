package sudoku.solver;

import org.junit.Test;
import sudoku.CellBuilder;
import sudoku.domain.Cell;
import sudoku.domain.Row;
import sudoku.domain.StandardCell;
import sudoku.domain.StandardRow;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ScanningSolverTest {

    @Test
    public void shouldSolveCell() {

        Cell cellWithAllPossibilities = new StandardCell();

        List<Cell> cells = CellBuilder.builder()
                .withoutPossibility(5)
                .withCell(cellWithAllPossibilities)
                .build();

        Row row = new StandardRow(cells);

        row.solve(new ScanningSolver());

        assertThat(cellWithAllPossibilities.isSolved())
                .as("Cell should be solved as it's the only cell having number 5 as possibility")
                .isTrue();

    }

    @Test
    public void shouldNotSolveCells() {


        Cell firstCellWithAllPossibilities = new StandardCell();
        Cell secondCellWithAllPossibilities = new StandardCell();

        List<Cell> cells = CellBuilder.builder()
                .withoutPossibility(5)
                .withCells(firstCellWithAllPossibilities, secondCellWithAllPossibilities)
                .build();

        Row row = new StandardRow(cells);

        row.solve(new ScanningSolver());

        assertThat(firstCellWithAllPossibilities.isSolved())
                .isFalse();

        assertThat(secondCellWithAllPossibilities.isSolved())
                .isFalse();

    }
}
