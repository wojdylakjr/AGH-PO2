public class Logic {
    Board board;

    public Board createBoard(int nx, int ny, double p) {
        board = new Board(nx, ny, p);
        return board;
    }

    public void printBoard() {
        board.print();
    }

    public boolean isGameContinued(char sign) {
        if (sign == Option.EXIT.getSign()) {
            System.out.println(Option.EXIT);
            return false;
        } else if (sign == Option.RESET.getSign()) {
            System.out.println(Option.RESET);
            return false;
        } else if (this.checkWin()) {
            System.out.println("Wygrana!");
            return false;
        } else {
            return true;
        }
    }

    public void makeMove(char inputChar) {
        if (inputChar == Option.UP.getSign()) {
            makeMoveOnBoard(Option.UP.getDirection());
        } else if (inputChar == Option.RIGHT.getSign()) {
            makeMoveOnBoard(Option.RIGHT.getDirection());
        } else if (inputChar == Option.DOWN.getSign()) {
            makeMoveOnBoard(Option.DOWN.getDirection());
        } else if (inputChar == Option.LEFT.getSign()) {
            makeMoveOnBoard(Option.LEFT.getDirection());
        }

    }

    public boolean validateNewPosition(Direction direction) throws WallException {
        PlayerPosition currentPosition = board.getCurrentPosition();
        int newXposition = currentPosition.getRow() + direction.getY();
        int newYposition = currentPosition.getColumn() + direction.getX();

        if (board.getSign(newXposition, newYposition) != 'X') {
            return true;
        } else {
            throw new WallException("Nie mozna wykonac ruchu");
        }
    }

    private void makeMoveOnBoard(Direction direction) {
        PlayerPosition currentPosition = board.getCurrentPosition();
        int newXposition = currentPosition.getRow() + direction.getY();
        int newYposition = currentPosition.getColumn() + direction.getX();

        try {
            boolean a = (validateNewPosition(direction));
            board.setNewPlayerPosition(newXposition, newYposition);
            board.print();
        } catch (WallException e) {
            System.out.println("Nie mozna wykonac ruchu");
        }

    }

    public boolean checkWin() {
        return false;
    }

    public void showOptions() {
        for (Option a : Option.values()) {
            System.out.println(a);
        }
    }

    public Board getBoard() {
        return board;
    }

    public char validateInput() throws OptionNotRecognizedException {
        char inputChar;
        while (true) {
            inputChar = SystemInWrapper.sc.next().charAt(0);
            if (inputChar != 'w' && inputChar != 'e' && inputChar != 's' && inputChar != 'd' && inputChar != 'a' && inputChar != 'r') {
                throw new OptionNotRecognizedException("zla opcja");
            } else {
                SystemInWrapper.sc.nextLine();
                break;
            }

        }
        return inputChar;
    }

}

