public class WallException extends Exception {
    private String error;

    public WallException(String error) {
        this.error = error;
    }
}