package sudoku.solver;

import org.apache.commons.math3.stat.Frequency;
import sudoku.domain.Cell;
import sudoku.domain.StandardColumn;
import sudoku.domain.StandardGrid;
import sudoku.domain.StandardRow;

import java.util.Collection;
import java.util.Iterator;

/**
 * Solver which checks for each cell if there is some cell that alone contains single possible value. As there is no other cell for where this possibility could exist, cell in question should be resolved using that possibility.
 *
 * <pre>
 * Example:
 *
 * Possibilities for cell 1: 1,2,3,4
 * Possibilities for cell 2: 1,2,3,4,5
 * Possibilities for cell 3: 1,2,3,4
 *
 * Cell 2 could be solved with number 5
 * </pre>
 */
public class ScanningSolverVisitor extends SolverVisitorAdapter {


    @Override
    public void solve(StandardRow row) {
        solve(row.getCells());
    }

    @Override
    public void solve(StandardColumn column) {
        solve(column.getCells());
    }

    @Override
    public void solve(StandardGrid grid) {
        solve(grid.getCells());
    }

    private void solve(Collection<Cell> cells) {

        Frequency freq = calculateFrequencyForPossibilitiesInCells(cells);

        solveCellWithFrequencyOne(cells, freq);
    }

    /**
     * Solve those cells which contain some possible value alone.
     */
    private void solveCellWithFrequencyOne(Collection<Cell> cells, Frequency freq) {
        Iterator<Comparable<?>> iterator = freq.valuesIterator();

        while (iterator.hasNext()) {
            Long number = (Long) iterator.next();

            long frequency = freq.getCount(number);

            if (frequency == 1) {
                solveCellWithPossibility(cells, number);
            }

        }
    }

    private void solveCellWithPossibility(Collection<Cell> cells, Long number) {

        cells.stream()
                .filter(cell -> cell.containsPossibility(number.intValue()))
                .forEach(cell -> cell.solve(number.intValue()));
    }

    /**
     * Calculates how frequently possible values exist in cells
     */
    private Frequency calculateFrequencyForPossibilitiesInCells(Collection<Cell> cells) {

        return cells.stream()
                .map(cell -> calculatePossibilityFrequency(cell.getPossibilities()))
                .reduce(new Frequency(), (frequency, frequency2) -> {
                    frequency.merge(frequency2);
                    return frequency;
                });

    }

    private Frequency calculatePossibilityFrequency(Collection<Integer> possibilities) {

        Frequency frequency = new Frequency();
        possibilities.forEach(frequency::addValue);
        return frequency;
    }
}
