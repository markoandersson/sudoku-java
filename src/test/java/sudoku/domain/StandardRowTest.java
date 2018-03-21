package sudoku.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import sudoku.CellBuilder;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class StandardRowTest {

    @Test
    public void shouldAllowNineCells() {

        List<Cell> cells = CellBuilder.builder()
                .build();

        Row row = new StandardRow(cells);

        assertThat(row)
                .isNotNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExecptionWithEightCells() {

       new StandardRow(Collections.nCopies(8, new StandardCell()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWithTenCells() {

        new StandardRow(Collections.nCopies(10, new StandardCell()));
    }

    @Test
    public void shouldAllListenerToCell() {

        Cell cell = Mockito.mock(Cell.class);

        List<Cell> cells = CellBuilder.builder()
                .withCell(cell)
                .build();

        StandardRow row = new StandardRow(cells);

        Mockito.verify(cell).addListener(row);
    }

    @Test
    public void shouldNotifyOtherCellsWhenOneResolves() {

        Cell cell = Mockito.mock(Cell.class);

        List<Cell> cells = CellBuilder.builder()
                .withCell(cell)
                .build();

        StandardRow row = new StandardRow(cells);

        cells.get(2).solve(5);

        Mockito.verify(cell).removePossibility(5);
    }

    @Test
    public void shouldBeSolved() {

        List<Cell> cells = CellBuilder.builder()
                .build();
        StandardRow row = new StandardRow(cells);

        assertThat(row.isSolved())
                .isFalse();

        cells.get(0).solve(1);
        cells.get(1).solve(2);
        cells.get(2).solve(3);
        cells.get(3).solve(4);
        cells.get(4).solve(5);
        cells.get(5).solve(6);
        cells.get(6).solve(7);
        cells.get(7).solve(8);
        cells.get(8).solve(9);

        assertThat(row.isSolved())
                .isTrue();
    }
}
