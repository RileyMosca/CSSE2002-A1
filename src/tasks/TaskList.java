package towersim.tasks;

import java.util.LinkedList;
import java.util.List;



public class TaskList {
    private List<Task> tasks = new LinkedList<>();
    private int currentTaskIndex = 0;

    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Task getCurrentTask() {
        return tasks.get(currentTaskIndex);
    }

    public Task getNextTask() {
        if (currentTaskIndex < tasks.size() - 1) {
            currentTaskIndex++;
            return  tasks.get(currentTaskIndex);
        }
        return tasks.get(0);
    }

    public void moveToNextTask() {
        Task nextTask = getNextTask();
    }

    public String toString() {
        return String.format("TaskList currently on %s [%d/%d]",getCurrentTask(),
                (currentTaskIndex + 1), tasks.size());
    }
}
