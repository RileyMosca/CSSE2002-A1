package towersim.util;

public interface EmergencyState {

    void declareEmergency();

    void clearEmergency();

    boolean hasEmergency();
}
