package honeydo1068;
import java.time.*;

public class Task extends HoneyDoList {
    private String name;
    private int priority;
    private int estMinToComplete;
    private LocalDateTime whenDue;

    Task(String name, int priority, LocalDateTime whenDue, int estMinToComplete) {
        this.name = name;
        this.priority = priority;
        this.estMinToComplete = estMinToComplete;
        this.whenDue = whenDue;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    int getEstMinToComplete() {
        return estMinToComplete;
    }

    public void setEstMinToComplete(int estMinToComplete) {
        this.estMinToComplete = estMinToComplete;
    }

    private LocalDateTime getWhenDue() {
        return whenDue;
    }

    public void setWhenDue(LocalDateTime whenDue) {
        this.whenDue = whenDue;
    }

    @Override
    public Integer completeTask(int index) {
        return super.completeTask(index);
    }

    @Override
    public Task[] overdueTask() {
        return super.overdueTask();
    }

    @Override
    public String toString() {
        return "Task " +
                "name='" + name + '\'' +
                ", priority=" + priority +
                ", estMinToComplete=" + estMinToComplete +
                ", whenDue=" + whenDue +
                ", overdue=" + this.overdue() +
                "\n";
    }

    void increasePriority(int amount) {
        if (amount > 0) {
            this.priority = priority + amount;
        }
    }

    void decreasePriority(int amount) {
        if (amount < this.priority) {
            this.priority = priority - amount;
        }
    }

    boolean overdue() {
        return LocalDateTime.now().isAfter(getWhenDue());
    }

}