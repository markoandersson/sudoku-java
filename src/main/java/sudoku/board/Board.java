package sudoku.board;

import sudoku.domain.SudokuVisitor;

public interface Board {
    void accept(SudokuVisitor visitor);

    boolean isSolved();
}
