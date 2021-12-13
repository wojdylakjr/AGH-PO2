import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestClass {
    private static Board board;
    private static Logic logic;
    private static int currentPlayerRow = 2;
    private static int currentPlayerColumn = 2;
    private static int boardRowSize = 10;
    private static int boardColumnSize = 10;
    @Before
    public void init() {
        logic = new Logic();
        board = logic.createBoard(boardRowSize,boardColumnSize,0.5);
        board.setBoard();
    }

    @Test
    public void setBoard_checkEntryPosition() {
        //given
        int expectedRow  = boardRowSize - 1;
        int column = 1;

        //when
        int rowResult = board.getCurrentPosition().getRow();
        int columnResult = board.getCurrentPosition().getColumn();

        //then
        assertEquals(expectedRow, rowResult);
        assertEquals(column, columnResult);
    }

    @Test
    public void setBoard_checkExit(){
        //given
        char sign = ' ';

        //when
        char result = board.getSign(0, boardColumnSize/2);

        //then
        assertEquals(sign, result);
    }

    @Test
    public void validateNewPosition_moveDOWN(){
        System.out.println("validateNewPosition_moveDOWN");
        //given
        Direction testDirection = Direction.DOWN;
//        logic.createBoard(5,5,0.5);

        char signUnderCurrentPosition = board.getSign(currentPlayerRow + 1, currentPlayerColumn);

        //when
        board.setNewPlayerPosition(currentPlayerRow, currentPlayerColumn);
        board.print();
        boolean result = logic.validateNewPosition(testDirection);
        System.out.println("Wykonano ruch: " + result);

        //then
        if(signUnderCurrentPosition == 'X'){
            assertFalse(result);
        }
        else if (signUnderCurrentPosition == ' '){
            System.out.println(result);
        }

    }

    @Test
    public void validateNewPosition_moveUP(){
        System.out.println("validateNewPosition_moveUP");
        //given
        Direction testDirection = Direction.UP;
//        logic.createBoard(5,5,0.5);
//        int currentRow = 2;
//        int currentColumn = 2;
        char signAboveCurrentPosition = board.getSign(currentPlayerRow - 1, currentPlayerColumn);

        //when
        board.setNewPlayerPosition(currentPlayerRow, currentPlayerColumn);
        board.print();
        boolean result = logic.validateNewPosition(testDirection);
        System.out.println("Wykonano ruch: " + result);

        //then
        if(signAboveCurrentPosition == 'X'){
            assertFalse(result);
        }
        else if (signAboveCurrentPosition == ' '){
            System.out.println(result);
        }
    }

    @Test
    public void validateNewPosition_moveRIGHT(){
        System.out.println("validateNewPosition_moveRIGHT");
        //given
        Direction testDirection = Direction.RIGHT;
//        logic.createBoard(5,5,0.5);
//        int currentRow = 2;
//        int currentColumn = 2;
        char signRightCurrentPosition = board.getSign(currentPlayerRow, currentPlayerColumn + 1);

        //when
        board.setNewPlayerPosition(currentPlayerRow, currentPlayerColumn);
        board.print();
        boolean result = logic.validateNewPosition(testDirection);
        System.out.println("Wykonano ruch: " + result);

        //then
        if(signRightCurrentPosition == 'X'){
            assertFalse(result);
        }
        else if (signRightCurrentPosition == ' '){
            System.out.println(result);
        }

    }
    @Test
    public void validateNewPosition_moveLEFT(){
        System.out.println("validateNewPosition_moveLEFT");
        //given
        Direction testDirection = Direction.LEFT;
//        logic.createBoard(5,5,0.5);
//        int currentRow = 2;
//        int currentColumn = 2;
        char signLeftCurrentPosition = board.getSign(currentPlayerRow, currentPlayerColumn - 1);

        //when
        board.setNewPlayerPosition(currentPlayerRow, currentPlayerColumn);
        board.print();
        boolean result = logic.validateNewPosition(testDirection);
        System.out.println("Wykonano ruch: " + result);

        //then
        if(signLeftCurrentPosition == 'X'){
            assertFalse(result);
        }
        else if (signLeftCurrentPosition == ' '){
            System.out.println(result);
        }

    }


}
