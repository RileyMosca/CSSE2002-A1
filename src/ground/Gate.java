package towersim.ground;

import towersim.aircraft.Aircraft;
import towersim.util.NoSpaceException;

public class Gate{
    private final int gateNumber;
    private Aircraft aircraft;


    public Gate(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public void aircraftLeaves() {
        aircraft = null;
    }

    public Aircraft getAircraftAtGate() {
        if (isOccupied()) {
            return aircraft;
        } else {
            return null;
        }
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public boolean isOccupied() {
        return aircraft != null;
    }

    public void parkAircraft(Aircraft aircraft) throws NoSpaceException {
        if (isOccupied()) {
            throw new NoSpaceException();
        } else {
            this.aircraft = aircraft;
        }
    }

    public String toString() {
        if (!isOccupied()) {
            return String.format("Gate %d [%s] [empty]", gateNumber, aircraft.getCallsign());
        } else {
            return String.format("Gate %d [%s]",gateNumber, aircraft.getCallsign());
        }
    }
}
