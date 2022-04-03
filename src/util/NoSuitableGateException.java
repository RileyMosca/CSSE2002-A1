package towersim.util;

public class NoSuitableGateException extends Exception{

    public NoSuitableGateException() {
    }

    public NoSuitableGateException(String message) {

        super(message);
    }
}
