package sudoku.domain;

/**
 * Interface for listener which will be notified when some cell's value has been solved.
 */
public interface CellSolvedListener {

    /**
     * Method which will be called when some cell's value has been resolved.
     */
    void cellSolved(int resolvedNumber);
}
