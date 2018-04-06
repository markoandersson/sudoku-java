package sudoku.domain;

import sudoku.board.Board;

/**
 * Interface for collection of {@link SudokuAction}-classes which can be executed for given {@link Board}
 */
public interface SudokuActions extends Iterable<SudokuAction> {

    void execute(Board board);
}
