public class OptionNotRecognizedException extends Exception{
    private String error;
    public OptionNotRecognizedException(String error){
        this.error = error;
    }

}