package towersim.aircraft;

//Imports
import static towersim.aircraft.AircraftType.HELICOPTER;
import static towersim.aircraft.AircraftType.AIRPLANE;

//Stores information about particular models of aircraft.
public enum AircraftCharacteristics{
    AIRBUS_A320(AIRPLANE, 42600, 27200,
            150, 0),
    BOEING_747_8F(AIRPLANE, 197131,226117,
            0,137756),
    ROBINSON_R44(HELICOPTER, 658, 190,
            4, 0),
    BOEING_787(AIRPLANE, 119950, 126206,
            242, 0),
    FOKKER_100(AIRPLANE, 24375, 13365,
            97, 0),
    SIKORSKY_SKYCRANE(HELICOPTER, 8724, 3328,
            0, 9100);

    //Instance fields of the AircraftCharacteristics Enum Class
    public final AircraftType type;
    public final int emptyWeight;
    public final double fuelCapacity;
    public final int passengerCapacity;
    public final int freightCapacity;

    /**
     *
     * @param type Type of the aircraft as specified in AircraftTpe Enum.
     * @param emptyWeight Weight of aircraft with no load or fuel, in kilograms.
     * @param fuelCapacity Maximum amount of fuel able to be carried, in litres.
     * @param passengerCapacity Maximum number of passengers able to be carried.
     * @param freightCapacity Maximum amount of freight able to be carried, in kilograms.
     */
    AircraftCharacteristics(AircraftType type, int emptyWeight, int fuelCapacity,
                                         int passengerCapacity, int freightCapacity){
        this.type = type;
        this.emptyWeight = emptyWeight;
        this.fuelCapacity = fuelCapacity;
        this.passengerCapacity = passengerCapacity;
        this.freightCapacity = freightCapacity;
    }
}