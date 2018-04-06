package sudoku.solver;

import org.junit.Test;
import sudoku.domain.StandardCell;

import static org.assertj.core.api.Assertions.assertThat;

public class SudokuVisitorAdapterTest {

    @Test
    public void shouldPreventDuplicates() {

        SudokuVisitorAdapter adapter = new SudokuVisitorAdapter();

        SolveCellAction action = new SolveCellAction(new StandardCell(), 5);

        adapter.addAction(action);
        adapter.addAction(action);

        assertThat(adapter.getActions())
                .as("Same action should be added only once")
                .hasSize(1);

    }
}
