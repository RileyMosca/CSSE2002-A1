package towersim.ground;

public class HelicopterTerminal extends Terminal{
    private int terminalNumber;
    public static final int MAX_NUM_GATES = 6;

    public HelicopterTerminal(int terminalNumber) {
        super(terminalNumber);
    }
}
