package sudoku.board;

import sudoku.solver.ScanningSolverVisitor;

public interface Board {
    void accept(ScanningSolverVisitor solverVisitor);

    boolean isSolved();
}
