package sudoku.solver;

import sudoku.domain.*;

class SudokuVisitorAdapter implements SudokuVisitor {

    private SudokuActionsCollection actions = new SudokuActionsCollection();

    @Override
    public void visit(final StandardRow row) {

    }

    @Override
    public void visit(final StandardColumn column) {

    }

    @Override
    public void visit(final StandardGrid grid) {

    }

    @Override
    public void visit(final StandardCell cell) {

    }

    @Override
    public SudokuActions getActions() {
        return actions;
    }

    void addAction(final SudokuAction action) {
        actions.add(action);
    }
}
