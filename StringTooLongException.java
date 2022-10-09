public class StringTooLongException extends Exception {
    public StringTooLongException()
    {
        super("Строка имеет слишком много значений, введите меньше 30");       
    }
}