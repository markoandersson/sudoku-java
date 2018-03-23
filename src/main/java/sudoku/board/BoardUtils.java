package sudoku.board;

import sudoku.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardUtils {

    public static List<Row> buildRows(List<List<Cell>> board) {
        List<Row> rows = new ArrayList<>();
        for (List<Cell> rowOfCells : board) {
            rows.add(new StandardRow(rowOfCells));
        }

        return rows;
    }

    public static List<Column> buildColumns(List<List<Cell>> board) {
        List<Column> columns = new ArrayList<>();

        for (int i = 0; i < board.size(); i++) {

            List<Cell> columnOfCells = new ArrayList<>();
            for (List<Cell> rowOfCells : board) {

                columnOfCells.add(rowOfCells.get(i));
            }
            columns.add(new StandardColumn(columnOfCells));
        }

        return columns;

    }

    public static List<Grid> buildGrids(List<List<Cell>> board) {
        List<Grid> grids = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < 9; rowIndex+=3) {

            List<List<Cell>> rows = board.subList(rowIndex, rowIndex+3);

            for (int colIndex = 0; colIndex < 9; colIndex += 3) {
                grids.add(getGridCells(rows, colIndex));

            }
        }

        return grids;
    }

    private static Grid getGridCells(List<List<Cell>> rows, int colIndex) {

        List<Cell> cells = new ArrayList<>();
        for (List<Cell> row : rows) {

            List<Cell> rowCells = row.subList(colIndex, colIndex + 3);
            cells.addAll(rowCells);
        }

        return new StandardGrid(cells);

    }

    public static String printBoard(StandardBoard standardBoard) {
        StringBuilder sb = new StringBuilder();

        sb.append(createHorizonalSeparator()).append("\n");

        List<Row> rows = standardBoard.getRows();

        for (int i = 1; i <= rows.size(); i++) {

            Row row = rows.get(i-1);

            sb.append("|").append(row.toString("|")).append("\n");

            if (i % 3 == 0) {
                sb.append(createHorizonalSeparator()).append("\n");
            }
        }

        return sb.toString();

    }

    private static String createHorizonalSeparator() {
        char[] chars = new char[19];
        Arrays.fill(chars, '-');
        return new String(chars);
    }
}
