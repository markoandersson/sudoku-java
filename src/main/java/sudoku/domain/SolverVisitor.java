package sudoku.domain;

/**
 * Interface for solvers which implement visitor pattern for visiting different cell structures in game board.
 */
public interface SolverVisitor {

    void solve(StandardRow row);

    void solve(StandardColumn column);

    void solve(StandardGrid grid);
}
