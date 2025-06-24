package lesson11.ex11_2_exercise;

public class InvalidOperationException extends Exception{
    public InvalidOperationException() {super();}
    public InvalidOperationException(String message) {super(message);}

    public InvalidOperationException(Throwable cause) {super(cause);}

    public InvalidOperationException(String message, Throwable cause) {super(message, cause);}
}
