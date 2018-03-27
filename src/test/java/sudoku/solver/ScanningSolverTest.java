package sudoku.solver;

import org.junit.Test;
import sudoku.CellBuilder;
import sudoku.board.Board;
import sudoku.board.TestBoards;
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

        row.accept(new ScanningSolverVisitor());

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

        row.accept(new ScanningSolverVisitor());

        assertThat(firstCellWithAllPossibilities.isSolved())
                .isFalse();

        assertThat(secondCellWithAllPossibilities.isSolved())
                .isFalse();

    }

    @Test
    public void shouldScanAndSolve() {

        Board medium = TestBoards.medium();
        ScanningSolverVisitor scanningSolverVisitor = new ScanningSolverVisitor();

        assertThat(medium.isSolved())
                .isFalse();

        medium.accept(scanningSolverVisitor);

        assertThat(medium.isSolved())
                .isFalse();

        medium.accept(scanningSolverVisitor);

        assertThat(medium.isSolved())
                .isTrue();
    }
}
