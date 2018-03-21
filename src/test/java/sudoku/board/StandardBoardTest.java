package sudoku.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import sudoku.domain.Row;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class StandardBoardTest {

    @Test
    public void shouldAllowNineRows() {

        Row row = Mockito.mock(Row.class);
        List<Row> rows = Collections.nCopies(9, row);
        new StandardBoard(rows);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowEightRows() {

        Row row = Mockito.mock(Row.class);
        List<Row> rows = Collections.nCopies(8, row);
        new StandardBoard(rows);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowTenRows() {

        Row row = Mockito.mock(Row.class);
        List<Row> rows = Collections.nCopies(10, row);
        new StandardBoard(rows);
    }

    @Test
    public void shouldPrintBoard() {

        StandardBoard board = TestBoards.easy;

        assertThat(board.toString())
                .contains("|5");
    }
}
