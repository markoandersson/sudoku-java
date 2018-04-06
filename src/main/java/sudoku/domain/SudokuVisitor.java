package sudoku.domain;

import java.util.Collection;

/**
 * Interface for visitor which implement visitor pattern for visiting different cell structures in game board.
 */
public interface SudokuVisitor {

    void visit(StandardRow row);

    void visit(StandardColumn column);

    void visit(StandardGrid grid);

    void visit(StandardCell cell);

    SudokuActions getActions();
}
