package towersim.aircraft;

import towersim.tasks.Task;
import towersim.tasks.TaskList;
import towersim.tasks.TaskType;

public class PassengerAircraft extends Aircraft {
    private final int numPassengers;
    public static final double AVG_PASSENGER_WEIGHT = 90.0;

    public PassengerAircraft(String callsign, AircraftCharacteristics characteristics,
                             TaskList tasks, double fuelAmount, int numPassengers) {

        super(callsign, characteristics, tasks, fuelAmount);
        this.numPassengers = numPassengers;
    }

    public int calculateOccupancyLevel() {

        return (numPassengers/getCharacteristics().passengerCapacity);
    }

    public int getLoadingTime() {
        int loadingPassengerTime =1;
        if (getTaskList().getCurrentTask().getType() == TaskType.LOAD) {
            loadingPassengerTime = (int) Math.log10(getCharacteristics().passengerCapacity);
        }
        return loadingPassengerTime;
    }

    public double getTotalWeight() {
        return (numPassengers * AVG_PASSENGER_WEIGHT) +
                (getCharacteristics().emptyWeight + LITRE_OF_FUEL_WEIGHT * getFuelAmount());
    }

    public void tick() {
        super.tick();
    }
}
