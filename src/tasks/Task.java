package towersim.tasks;

public class Task {
    private final TaskType type;
    private int loadPercent;

    public Task(TaskType type) {
        this.type = type;
    }
    public Task(TaskType type, int loadPercent) {
        this.type = type;
        this.loadPercent = loadPercent;
    }

    public int getLoadPercent() {
        return loadPercent;
    }

    public TaskType getType() {
        return type;
    }

    public String toString() {
        return String.format("%s", getType());
    }
}
