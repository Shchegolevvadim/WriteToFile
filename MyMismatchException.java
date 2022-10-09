import java.util.InputMismatchException;

public class MyMismatchException extends InputMismatchException{
    public MyMismatchException(String s){
        super(s);
}
}