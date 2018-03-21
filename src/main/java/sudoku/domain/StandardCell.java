package sudoku.domain;

import java.util.*;

/**
 * Presents single cell in basic Sudoku board which either is solved or not. In the beginning possible values for cell are 1 through 9. When cells are being solved, possibilities will be reduced.
 */
public class StandardCell implements Cell {

    private final List<Integer> possibilities;
    private Collection<CellSolvedListener> listeners = new ArrayList<>();

    public StandardCell() {
        this.possibilities = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Override
    public void removePossibility(Integer number) {

        if (isSolved()) {
            throw new IllegalArgumentException("Cell has been already solved.");
        }
        this.possibilities.remove(number);

        if (isSolved()) {
            notifyListeners();
        }
    }

    private void notifyListeners() {
        this.listeners.forEach(cellSolvedListener -> cellSolvedListener.cellSolved(getCellNumber()));
    }

    private Integer getCellNumber() {
        return this.possibilities.get(0);
    }

    @Override
    public boolean isSolved() {
        return possibilities.size() == 1;
    }

    public Collection<Integer> getPossibilities() {
        return Collections.unmodifiableCollection(this.possibilities);
    }

    @Override
    public boolean containsPossibility(Integer number) {
        return getPossibilities().contains(number);
    }

    @Override
    public void solve(int number) {

        this.possibilities.removeIf(possibility -> possibility != number);

        notifyListeners();
    }

    @Override
    public void addListener(CellSolvedListener listener) {
        this.listeners.add(listener);
    }
}
