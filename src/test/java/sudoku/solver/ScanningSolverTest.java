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

        ScanningSudokuVisitor solver = new ScanningSudokuVisitor();

        row.accept(solver);

        assertThat(solver.getActions())
                .hasSize(1)
                .contains(new SolveCellAction(cellWithAllPossibilities, 5));
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

        ScanningSudokuVisitor solver = new ScanningSudokuVisitor();

        row.accept(solver);

        assertThat(solver.getActions())
                .isEmpty();

        assertThat(firstCellWithAllPossibilities.isSolved())
                .isFalse();

        assertThat(secondCellWithAllPossibilities.isSolved())
                .isFalse();

    }

    @Test
    public void shouldScanAndSolve() {

        Board medium = TestBoards.medium();
        ScanningSudokuVisitor scanningSolverVisitor = new ScanningSudokuVisitor();

        assertThat(medium.isSolved())
                .isFalse();

        medium.accept(scanningSolverVisitor);

        assertThat(scanningSolverVisitor.getActions())
                .hasSize(13);
    }

    @Test
    public void solveMediumBoardWithThreePasses() {

        Board board = TestBoards.medium();
        ScanningSudokuVisitor visitor = new ScanningSudokuVisitor();

        board.accept(visitor);
        visitor.getActions().execute(board);

        board.accept(visitor);
        visitor.getActions().execute(board);

        board.accept(visitor);
        visitor.getActions().execute(board);

        assertThat(board.isSolved())
                .as("Three scans should solve the board")
                .isTrue();
    }
}
