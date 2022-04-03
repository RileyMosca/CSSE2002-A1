package towersim.aircraft;

//Imports
import towersim.tasks.TaskList;
import towersim.util.EmergencyState;
import towersim.util.OccupancyLevel;
import towersim.util.Tickable;

//Represents an aircraft capable of carrying freight cargo.
public class FreightAircraft extends Aircraft implements EmergencyState, OccupancyLevel, Tickable {

    //Instance fields
    private final int freightAmount;

    /**
     * Constructor method of the aircraft, provides a new aircraft object with the given parameters
     * @param callsign unique callsign
     * @param characteristics characteristics that describe this freight aicraft
     * @param tasks task list to be used by aircraft
     * @param fuelAmount current amount of fuel onboard, in litres
     * @param freightAmount current amount of freight onboard in kilograms
     * @throws IllegalArgumentException If fuelamount <0, or if fuelAmount > fuel capacity
     */
    public FreightAircraft(String callsign, AircraftCharacteristics characteristics, TaskList tasks,
                           double fuelAmount, int freightAmount) throws IllegalArgumentException {
        super(callsign, characteristics, tasks, fuelAmount);
        this.freightAmount = freightAmount;
    }

    /**
     * Returns the ratio of freight cargo onboard to maximum available freight
     * capacity as a percentage between 0 and 100.
     * @return integer representation of the occupancy in the aircraft
     */
    public int calculateOccupancyLevel() {

        return (freightAmount/ getCharacteristics().freightCapacity);
    }

    /**
     *
     * @return
     */
    public int getLoadingTime() {
        double freightToBeLoaded = getCharacteristics().freightCapacity *
                getTaskList().getCurrentTask().getLoadPercent()/100.0;
        int loadingTime = 0;
        if( freightToBeLoaded < 1000) {
            loadingTime = 1;
        }else if ( freightToBeLoaded > 1000 && freightToBeLoaded < 50000) {
            loadingTime = 2;
        }else if ( freightToBeLoaded > 50000) {
            loadingTime = 3;
        }return loadingTime;
    }

    /**
     *
     * @return
     */
    public double getTotalWeight() {
        return  (freightAmount) +
                (getCharacteristics().emptyWeight + LITRE_OF_FUEL_WEIGHT * getFuelAmount());
    }

    public void tick() {
        super.tick();
    }
}
