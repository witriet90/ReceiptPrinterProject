package input;

public class InputParserException extends RuntimeException{
    public InputParserException() {
    }

    public InputParserException(String message) {
        super(message);
    }

    public InputParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputParserException(Throwable cause) {
        super(cause);
    }

}
