package sudoku.board;

public class TestBoards {

    public static Board easy() {

        return StandardBoard.builder()
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

    public static Board medium() {

        return StandardBoard.builder()
                .withRow("0,2,0|5,0,0|0,4,0")
                .withRow("0,0,5|0,0,0|7,0,8")
                .withRow("0,7,0|6,2,0|0,0,1")

                .withRow("0,0,0|3,0,0|8,6,0")
                .withRow("3,0,0|0,6,0|0,0,7")
                .withRow("0,5,8|0,0,4|0,0,0")

                .withRow("5,0,0|0,4,6|0,8,0")
                .withRow("4,0,6|0,0,0|5,0,0")
                .withRow("0,9,0|0,0,8|0,3,0")

                .build();

    }

    public static Board hard() {

        return StandardBoard.builder()
                .withRow("7,0,0|0,0,0|1,0,0")
                .withRow("3,5,0|0,0,0|0,0,0")
                .withRow("0,2,1|0,0,0|0,5,0")

                .withRow("0,0,0|0,8,6|0,4,2")
                .withRow("0,0,4|7,5,2|3,0,0")
                .withRow("6,1,0|4,9,0|0,0,0")

                .withRow("0,9,0|0,0,0|6,2,0")
                .withRow("0,0,0|0,0,0|0,7,5")
                .withRow("0,0,3|0,0,0|0,0,1")

                .build();

    }

    public static Board evil() {

        return StandardBoard.builder()
                .withRow("0,4,0|0,0,6|0,0,8")
                .withRow("0,0,1|0,0,7|0,0,9")
                .withRow("2,0,0|0,1,0|0,0,5")

                .withRow("0,8,0|0,0,9|3,0,0")
                .withRow("5,0,0|0,0,0|0,0,2")
                .withRow("0,0,9|2,0,0|0,4,0")

                .withRow("4,0,0|0,3,0|0,0,7")
                .withRow("9,0,0|7,0,0|2,0,0")
                .withRow("6,0,0|1,0,0|0,5,0")

                .build();

    }

}
