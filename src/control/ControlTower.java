package towersim.control;

import towersim.aircraft.Aircraft;
import towersim.aircraft.AircraftType;
import towersim.ground.AirplaneTerminal;
import towersim.ground.Gate;
import towersim.ground.Terminal;
import towersim.util.NoSuitableGateException;
import towersim.util.Tickable;


import java.util.LinkedList;
import java.util.List;

import static towersim.tasks.TaskType.LOAD;

public class ControlTower implements Tickable {


    private final List<Terminal> terminalList = new LinkedList<>();
    private final List<Aircraft> aircraftList = new LinkedList<>();
    private final List<Gate> gateList = new LinkedList<>();
    private Gate unoccupiedGate;

    public ControlTower(){
    }

    public void addAircraft(Aircraft aircraft) throws NoSuitableGateException{
        aircraftList.add(aircraft);
        throw new NoSuitableGateException();

    }

    public void addTerminal(Terminal terminal) {
        terminalList.add(terminal);
    }

    public Gate findGateOfAircraft(Aircraft aircraft) {
        for(Gate aircraftAtGate : gateList) {
            if (aircraftAtGate.getAircraftAtGate() == aircraft) {
                return aircraftAtGate;
            }
        }
        return null;
    }

    public Gate findUnoccupiedGate(Aircraft aircraft) throws NoSuitableGateException{
        for (Terminal terminal : terminalList) {
            if (terminal instanceof AirplaneTerminal) {
                if (aircraft.getCharacteristics().type == AircraftType.AIRPLANE) {
                    return terminal.findUnoccupiedGate();
                }
            } else if (aircraft.getCharacteristics().type == AircraftType.HELICOPTER) {
                return terminal.findUnoccupiedGate();
            }
        }
        throw new NoSuitableGateException();
    }


    public List<Aircraft> getAircraft() {
        return aircraftList;

    }

    public List<Terminal> getTerminals() {
        return terminalList;
    }

    public void tick() {
        // Don't know what to do here, idk how to call Aircraft.tick(); alone :(
    }
}
