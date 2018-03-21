package sudoku.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StandardCellTest {

    @Test
    public void shouldCreateCell() {

        Cell cell = new StandardCell();

        assertThat(cell.isSolved())
                .isFalse();
    }

    @Test
    public void shouldRemovePossibleValue() {

        StandardCell cell = new StandardCell();

        cell.removePossibility(1);

        assertThat(cell.getPossibilities())
                .containsExactlyInAnyOrder(2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void shouldSolveWhenRemovingAllOtherPossibilities() {

        Cell cell = new StandardCell();

        removePossibilities(cell, 1, 2, 3, 4, 5, 6, 7, 8);

        assertThat(cell.isSolved())
                .isTrue();

        assertThat(cell.getPossibilities())
                .as("No possibilities should exist")
                .isEmpty();
    }

    @Test
    public void shouldNotifyWhenCellHasBeenSolved() {

        CellSolvedListener mockNotifyListener = mock(CellSolvedListener.class);

        Cell cell = new StandardCell();
        cell.addListener(mockNotifyListener);

        removePossibilities(cell, 1, 2, 3, 4, 5, 6, 7, 8);

        verify(mockNotifyListener).cellSolved(9);

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotBeAbleToRemoveAllPossibilities() {

        Cell cell = new StandardCell();

        removePossibilities(cell, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void shouldSolveInstantly() {

        CellSolvedListener mockNotifyListener = mock(CellSolvedListener.class);
        Cell cell = new StandardCell();
        cell.addListener(mockNotifyListener);

        cell.solve(1);

        verify(mockNotifyListener).cellSolved(1);

        assertThat(cell.isSolved())
                .isTrue();
    }

    private void removePossibilities(Cell cell, Integer... possibilities) {

        for (Integer possibility : possibilities) {
            cell.removePossibility(possibility);
        }

    }
}
