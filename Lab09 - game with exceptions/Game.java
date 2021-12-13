

import java.util.*;

public class Game {
    private Logic logic;
    private int nx;
    private int ny;
    private double p;

    public void play(int nx) {
        // this.readInput(args);
        this.nx = nx;
        logic = new Logic();
        logic.showOptions();
        logic.createBoard(nx, nx, 0.3);
        logic.printBoard();


        char inputChar = 'a';
        while (logic.isGameContinued(inputChar)) {
            try {
                inputChar = logic.validateInput();
                logic.makeMove(inputChar);
                if (logic.checkWin()) {
                    break;
                }
            } catch (OptionNotRecognizedException e) {
                System.out.println("Wybrano zla opcje");
            }
        }

        if (inputChar == Option.RESET.getSign()) {
            this.play(nx);
        }

    }


}




