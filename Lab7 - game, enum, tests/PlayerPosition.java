public class PlayerPosition {
    private int row;
    private int column;
    private char sign;

    public char getSign() {
        return sign;
    }

    public PlayerPosition(int x, int y, char sign) {
        this.row = x;
        this.column = y;
        this.sign = sign;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
