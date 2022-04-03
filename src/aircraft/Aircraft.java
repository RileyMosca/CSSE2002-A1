package towersim.aircraft;

// imports of all the necessary packages and methods from other classes in towersim and java.

import towersim.tasks.TaskList;
import towersim.tasks.TaskType;
import towersim.util.EmergencyState;
import towersim.util.OccupancyLevel;
import towersim.util.Tickable;


/** Introduction to the abstract Aircraft class
 *  This class represents an aircraft whose movement is managed by the system.
 */
public abstract class Aircraft implements OccupancyLevel, Tickable, EmergencyState{

    // Below are the instance fields of the Aircraft class
    public static final double LITRE_OF_FUEL_WEIGHT = 0.8;
    private final String callsign;
    private final AircraftCharacteristics characteristics;
    private final TaskList tasks;
    private double fuelAmount;
    private boolean isEmergency;

    /**
     * Constructor method of the Aircraft, provides a new Aircraft Object Creates a new aircraft
     *  with the given callsign, task list, fuel capacity and amount.
     * @param callsign - unique callsign
     * @param characteristics - characteristics that describe this aircraft
     * @param tasks - task list to be used by aircraft
     * @param fuelAmount - current amount of fuel onboard, in litres
     * @throws IllegalArgumentException If fuelAmount < 0 or if fuelAmount > fuel capacity
     */
    protected Aircraft(String callsign, AircraftCharacteristics characteristics,
                       TaskList tasks, double fuelAmount) throws IllegalArgumentException{
        this.callsign = callsign;
        this.characteristics = characteristics;
        this.tasks = tasks;
        this.fuelAmount = fuelAmount;
    }

    /**
     * Method that clears any active state of emergency
     */
    public void clearEmergency(){
        isEmergency = false;
    }

    /**
     * Method that declares state of emergency
     */
    public void declareEmergency() {

        isEmergency = true;
    }

    /**
     * Getter method for aircraft callsign
     * Returns the callsign of the aircraft
     * @return aircraft callsign
     */
    public String getCallsign() {
        return this.callsign;
    }


    /**
     * Getter method for aircraft characteristics
     * Returns the characteristics of the aircraft
     * @return aircraft characteristics
     */
    public AircraftCharacteristics getCharacteristics() {
        return characteristics;
    }

    /**
     * Getter method for aircraft fuel amount
     * Returns the amount of fuel of the aircraft
     * @return aircraft fuel amount
     */
    public double getFuelAmount(){
        return fuelAmount;
    }

    /**
     * Getter method for aircraft callsign
     * Returns the callsign of the aircraft
     * @return aircraft callsign
     */
    public int getFuelPercentRemaining(){
        return 100 * (int) Math.round(fuelAmount/ characteristics.fuelCapacity);
    }

    /**
     * Abstract getter method for loading time in ticks
     * Different types and models of aircraft have different loading times.
     * Returns the number of ticks required to load the aircraft at the gate.
     * @return number of ticks to load the aircraft at the gate
     */
    public abstract int getLoadingTime();

    /**
     * Returns the task list of this aircraft
     * @return Task list of the aicraft
     */
    public TaskList getTaskList(){
        return tasks;
    }

    /**
     * Returns the total weight of the aircraft in its current state
     * Which means the freight of passengers/ freight is not included
     * @return Total weight of aircraft in kilograms
     */
    public double getTotalWeight(){
        return characteristics.emptyWeight + LITRE_OF_FUEL_WEIGHT * fuelAmount;
    }


    /**
     * A method that returns whether or not an emergency is currently active
     * Returns whether or not a state of emergency is currently active.
     * @return true/false depending whether an emergency is currently active
     */
    public boolean hasEmergency(){
        return isEmergency;
    }

    /**
     * Updates the aircraft's state on each tick of the simulation.
     * If the aircraft is away, 10% of the fuel amount is decreased per tick
     * If the fuel amount decreased below zero, the fuel amount is set to zero
     * If the aircraft is loading, the fuel amount increases by capacity/loadingTime
     * the fuel of the aircraft is measured in litres
     */
    public void tick() {
        if (tasks.getCurrentTask().getType() == TaskType.AWAY) {
            double fuelDecrease = -0.1* characteristics.fuelCapacity;
            if(fuelAmount + fuelDecrease > 0) {
                fuelAmount += fuelDecrease;
            }else if(fuelAmount + fuelDecrease < 0) {
                fuelAmount = 0;
            }
        }else if (tasks.getCurrentTask().getType() == TaskType.LOAD) {
            double fuelIncrease = characteristics.fuelCapacity / getLoadingTime();
            if(fuelAmount + fuelIncrease < characteristics.fuelCapacity) {
                fuelAmount += fuelIncrease;
            }else if(fuelAmount + fuelIncrease == characteristics.fuelCapacity) {
                fuelAmount = characteristics.fuelCapacity;
            }
        }
    }

    /**
     * This method returns a string, and this string varies depending on
     * whether the hasEmergency boolean true or not
     * Returns the human-readable string representation of this aircraft.
     * @return the string representation of the Aicraft
     */
    public String toString(){
        if (hasEmergency()){
            return String.format("%s %s %s %s %s",characteristics.type, getCallsign(),
                    characteristics.name(), tasks.getCurrentTask(), "(EMERGENCY)");
        }else{
            return String.format("%s %s %s %s",characteristics.type, getCallsign(),
                    characteristics.name(), tasks.getCurrentTask());
        }
    }
}