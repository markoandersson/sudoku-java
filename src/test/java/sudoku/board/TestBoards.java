package sudoku.board;

public class TestBoards {

    public static StandardBoard easy = StandardBoard.builder()
            .withRow("5,0,0|0,1,0|0,0,4")
            .withRow("2,7,4|0,0,0|6,0,0")
            .withRow("0,8,0|9,0,4|0,0,0")

            .withRow("8,1,0|4,6,0|3,0,2")
            .withRow("0,0,2|0,3,0|1,0,0")
            .withRow("7,0,6|0,9,1|0,5,8")

            .withRow("0,0,0|5,0,3|0,1,0")
            .withRow("0,0,5|0,0,0|9,2,7")
            .withRow("1,0,0|0,2,0|0,0,3")

            .build();
}
