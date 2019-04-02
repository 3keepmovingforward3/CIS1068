package honeydo1068;

import org.jetbrains.annotations.Contract;

import java.time.LocalDateTime;
import java.util.Arrays;

public class HoneyDoList {
    private Task[] task;
    private int numTasks;
    private int INITIAL_CAPACITY;

    HoneyDoList() {
        setINITIAL_CAPACITY();
        this.task = new Task[getINITIAL_CAPACITY()];
        this.numTasks = getINITIAL_CAPACITY();
    }

    void addTask(String name, int priority, LocalDateTime whenDue, int estMinToComplete) {
        setNumTasks(numTasks + 1);
        this.task = Arrays.copyOf(this.task, numTasks);
        this.task[numTasks - 1] = new Task(name, priority, whenDue, estMinToComplete);
    }

    @Contract(pure = true)
    private int getNumTasks() {
        return numTasks;
    }

    private void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }

    private void setINITIAL_CAPACITY() {
        this.INITIAL_CAPACITY = 0;
    }

    private int getINITIAL_CAPACITY() {
        return INITIAL_CAPACITY = 0;
    }

    public int find(String name) {
        for (int i = 0; i < getNumTasks(); i++) {
            if (this.task[i].getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public int totalTime() {
        int accum = 0;
        for (int i = 0; i < numTasks; i++) {
            accum += this.task[i].getEstMinToComplete();
        }
        return accum;
    }

    public int shortestTime() {
        int t = 0;
        if (this.task == null) {
            return -1;
        }
        t = this.task[0].getEstMinToComplete();
        for (int i = 0; i < numTasks; i++) {
            if (this.task[i].getEstMinToComplete() < t) {
                t = this.task[i].getEstMinToComplete();
            }
        }
        return t;
    }

    public Integer completeTask(int index) {
        if (index < 0 || index > numTasks) {
            return null;
        } //out of bounds

        if (index == 0) { //first element
            this.task = Arrays.copyOfRange(this.task, index + 1, numTasks);
            setNumTasks(getNumTasks() - 1);
            return 0;
        }
        if (index == numTasks) { //last element
            this.task = Arrays.copyOf(this.task, numTasks - 1);
            return 0;
        } else if (numTasks - index >= 0) System.arraycopy(this.task, index, this.task, index - 1, numTasks - index);
        this.task = Arrays.copyOf(this.task, numTasks - 1);
        setNumTasks(numTasks - 1);
        return 0;
    }

    public Task[] overdueTask() {
        Task[] overdue = new Task[numTasks];
        for (int i = 0; i < numTasks; i++) {
            if (this.task[i].overdue()) {
                overdue[i] = this.task[i];
            }
        }
        return overdue;
    }

    @Override
    public String toString() {
        return "HoneyDoList\n" + Arrays.toString(task).replace("[", "").replace("]", "").replace(", T", "T") +
                '\n';
    }
}