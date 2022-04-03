package towersim.ground;

public class AirplaneTerminal extends Terminal {
    private int terminalNumber;
    public static final int MAX_NUM_GATES = 6;

    public AirplaneTerminal(int terminalNumber) {
        super(terminalNumber);
    }
}
