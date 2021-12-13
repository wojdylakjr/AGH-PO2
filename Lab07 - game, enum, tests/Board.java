import java.util.Random;

public class Board {
    private char[][] board;
    private int nx;
    private int ny;
    private double p;
    PlayerPosition currentPosition;


    Board(int nx, int ny, double p) {
        board = new char[nx][ny];
        this.nx = nx;
        this.ny = ny;
        this.p = p;
        this.setBoard();
    }

    public int getNx() {
        return nx;
    }

    public int getNy() {
        return ny;
    }


    public void setBoard() {
        for (int i = 0; i < this.nx; i++) {
            board[i][0] = 'X';
        }
        for (int i = 0; i < this.nx; i++) {
            board[i][ny - 1] = 'X';
        }
        for (int i = 0; i < this.ny; i++) {
            board[0][i] = 'X';
        }
        for (int i = 0; i < this.ny; i++) {
            board[nx - 1][i] = 'X';
        }
        board[0][ny / 2] = ' ';

        Random rand = new Random();
        for (int i = 1; i < nx - 1; i++) {
            for (int j = 1; j < ny - 1; j++) {
                if (rand.nextDouble() < p) {
                    board[i][j] = 'X';
                } else {
                    board[i][j] = ' ';
                }
            }
        }
        currentPosition = new PlayerPosition(nx - 1, 1, 'o');
        board[currentPosition.getRow()][currentPosition.getColumn()] = currentPosition.getSign();
    }


    public PlayerPosition getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int x, int y){
        currentPosition.setRow(x);
        currentPosition.setColumn(y);
        board[x][y] = currentPosition.getSign();
    }

    public char getSign(int x, int y) {
        if (x < nx  && y < ny  && x >= 0 && y >= 0) {
            return board[x][y];
        } else return 'X';
    }

    public void print() {
        for (int i = 0; i < nx; i++) {
            for (int j = 0; j < ny; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void setNewPlayerPosition(int x, int y) {
//        char currentSign
        board[currentPosition.getRow()][currentPosition.getColumn()] = ' ';
        this.setCurrentPosition(x,y);

    }
}