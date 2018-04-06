package sudoku.solver;

import sudoku.board.Board;
import sudoku.domain.SudokuAction;

abstract class AbstractSudokuAction extends SudokuVisitorAdapter implements SudokuAction {

    @Override
    public void execute(final Board board) {
        board.accept(this);
    }



}
