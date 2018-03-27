package sudoku.board;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StandardBoardTest {

    private String[] rowOfCells = new String[9];

    @Test
    public void shouldAllowNineRows() {

        List<String[]> rows = Collections.nCopies(9, rowOfCells);
        new StandardBoard(asArray(rows));
    }

    private String[][] asArray(List<String[]> rows) {
        return rows.toArray(new String[0][0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowEightRows() {

        List<String[]> rows = Collections.nCopies(8, rowOfCells);
        new StandardBoard(asArray(rows));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowTenRows() {

        List<String[]> rows = Collections.nCopies(10, rowOfCells);
        new StandardBoard(asArray(rows));
    }

    @Test
    public void shouldPrintBoard() {

        Board board = TestBoards.easy();

        assertThat(board.toString())
                .contains("|5");
    }

    @Test
    public void shouldMapRows() {

        StandardBoard board = (StandardBoard) TestBoards.easy();

        assertThat(board.getRows().get(0).toString())
                .contains("5")
                .contains("1")
                .contains("4");
    }

    @Test
    public void shouldMapColumns() {

        StandardBoard board = (StandardBoard) TestBoards.easy();

        assertThat(board.getColumns().get(0).toString())
                .contains("5")
                .contains("2")
                .contains("8")
                .contains("7")
                .contains("1")
        ;

    }

    @Test
    public void shouldSolveBoard() {

        Board easy = TestBoards.easy();

        assertThat(easy.isSolved())
                .isTrue();
    }

}
