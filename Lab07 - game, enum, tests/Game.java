import org.junit.Test;

import java.util.*;

public class Game {
    private Logic logic;
    private int nx;
    private int ny;
    private double p;

    public void play(String[] args) {
        this.readInput(args);
        logic = new Logic();
        logic.showOptions();
        logic.createBoard(nx, ny, p);
        logic.printBoard();
        Scanner sc = new Scanner(System.in);
        char inputChar;
        inputChar = sc.next().charAt(0);

        while (logic.isGameContinued(inputChar)) {
            logic.makeMove(inputChar);
            if (logic.checkWin()) {
                break;
            }
            inputChar = sc.next().charAt(0);
        }

        if (inputChar == Option.RESET.getSign()) {
            this.play(new String[]{String.valueOf(nx), String.valueOf(nx), String.valueOf(p)});
        }
        sc.close();
    }

    private void readInput(String[] args) {
        if (args.length == 3) {
            this.nx = Integer.parseInt(args[0]);
            this.ny = Integer.parseInt(args[1]);
            this.p = Double.parseDouble(args[2]);
        } else {
            System.out.println("Zla ilosc argumentow, ustawiono domyslnie 10x10");
            this.nx = 10;
            this.ny = 10;
            this.p = 0.3;
        }
    }

}



