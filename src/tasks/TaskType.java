package towersim.tasks;

import towersim.aircraft.Aircraft;

public enum TaskType {
    AWAY("Flying outside the airport"),
    LAND("Waiting in queue to land"),
    LOAD("Loading at gate"),
    TAKEOFF("Waiting in queue to take off"),
    WAIT("Waiting idle at gate");

    private final String description;

    TaskType(String description) {
        this.description = description;

    }
    public String getDescription() {
        return description;
    }
}