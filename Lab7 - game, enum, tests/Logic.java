public class Logic {
    Board board;

    public Board createBoard(int nx, int ny, double p) {
        board = new Board(nx, ny, p);
        return board;
    }

    public void printBoard(){
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
        } else {
            System.out.println("Wprowadz poprawna opcje");
        }
    }

    public boolean validateNewPosition(Direction direction) {
        PlayerPosition currentPosition = board.getCurrentPosition();
        int newXposition = currentPosition.getRow() + direction.getY();
        int newYposition = currentPosition.getColumn() + direction.getX();

        if (board.getSign(newXposition, newYposition) != 'X' ) {
            return true;
        } else {
            return false;
        }
    }

    private void makeMoveOnBoard(Direction direction){
        PlayerPosition currentPosition = board.getCurrentPosition();
        int newXposition = currentPosition.getRow() + direction.getY();
        int newYposition = currentPosition.getColumn() + direction.getX();
        if(validateNewPosition(direction)){
            board.setNewPlayerPosition(newXposition, newYposition);
            board.print();
        }
        else{
            System.out.println("Nie mozna wykonac ruchu");
        }
    }

    public boolean checkWin() {
        if (board.getSign(0, board.getNy() / 2) == board.getCurrentPosition().getSign()) {
            System.out.println("Wygrana!");
            return true;
        } else {
            return false;
        }
    }

    public void showOptions() {
        for(Option a: Option.values()){
            System.out.println(a);
        }
    }

    public Board getBoard(){
        return board;
    }
}
