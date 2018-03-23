package sudoku.board;

import org.junit.Test;
import sudoku.domain.Cell;
import sudoku.domain.StandardCell;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StandardBoardTest {

    private List<Cell> rowOfCells = Collections.nCopies(9, new StandardCell());

    @Test
    public void shouldAllowNineRows() {

        List<List<Cell>> rows = Collections.nCopies(9, rowOfCells);
        new StandardBoard(rows);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowEightRows() {

        List<List<Cell>> rows = Collections.nCopies(8, rowOfCells);
        new StandardBoard(rows);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowTenRows() {

        List<List<Cell>> rows = Collections.nCopies(10, rowOfCells);
        new StandardBoard(rows);
    }

    @Test
    public void shouldPrintBoard() {

        StandardBoard board = TestBoards.easy;

        assertThat(board.toString())
                .contains("|5");
    }

    @Test
    public void shouldMapRows() {

        StandardBoard board = TestBoards.easy;

        assertThat(board.getRows().get(0).toString())
                .contains("5")
                .contains("1")
                .contains("4");
    }

    @Test
    public void shouldMapColumns() {

        StandardBoard board = TestBoards.easy;

        assertThat(board.getColumns().get(0).toString())
                .contains("5")
                .contains("2")
                .contains("8")
                .contains("7")
                .contains("1")
        ;

    }
}
