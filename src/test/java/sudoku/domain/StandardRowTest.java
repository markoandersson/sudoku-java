package sudoku.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

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
}