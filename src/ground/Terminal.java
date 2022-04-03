package towersim.ground;

import towersim.aircraft.Aircraft;
import towersim.util.NoSpaceException;
import towersim.util.NoSuitableGateException;

import java.util.ArrayList;
import java.util.List;

public abstract class Terminal{
    private final int terminalNumber;
    private boolean isEmergency;
    public static final int MAX_NUM_GATES = 6;
    private final List<Gate> gateList = new ArrayList<>();
    private Gate unoccupiedGate;


    protected Terminal(int terminalNumber) {
        this.terminalNumber = terminalNumber;

    }
    public void addGate(Gate gate) throws NoSpaceException {
        if (gateList.size() < MAX_NUM_GATES) {
            gateList.add(gate);
        }
        else {
            throw new NoSpaceException();
        }
    }

    public int calculateOccupancyLevel() {
        int count = 0;
        for (Gate gate : gateList) {
            if (gate.isOccupied()) {
                count++;
            }
        }
        return (int) Math.round((100.0*count/gateList.size()));
    }

    public void clearEmergency() {
        isEmergency = false;
    }

    public void declareEmergency(){
        isEmergency = true;
    }

    public Gate findUnoccupiedGate() throws NoSuitableGateException {
        for (Gate gate : gateList) {
            if (!gate.isOccupied()) {
                unoccupiedGate = gate;
            } else if (gate.isOccupied()) {
                throw new NoSuitableGateException();
            }
        }
        return unoccupiedGate;
    }

    public List<Gate> getGates(){
        return gateList;
    }

    public int getTerminalNumber() {
        return terminalNumber;
    }

    public boolean hasEmergency() {
        return isEmergency;
    }

    public String toString() {
        if(hasEmergency()) {
            return String.format("%s %d, %d gates (EMERGENCY)",
                    getClass().getSimpleName(), getTerminalNumber(), gateList.size());
        }
        else {
            return String.format("%s %d, %d gates",
                    getClass().getSimpleName(), getTerminalNumber(), gateList.size());
        }

    }
}