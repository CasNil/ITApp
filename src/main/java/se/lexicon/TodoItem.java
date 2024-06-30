package se.lexicon;


import java.time.LocalDate;

public class TodoItem {
    private int id;
    public String title;
    public String taskDescription;
    public LocalDate deadLine;
    public boolean done;
    public Person creator;

    public TodoItem() {
        deadLine = LocalDate.parse("2024-06-31");
    }

    public int getId() {
        return id;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        if (deadLine == null) throw new IllegalArgumentException("deadLine is not allowed to be null!");
        this.deadLine = deadLine;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title is not allowed to be null or empty!");
        this.title = title;
    }

    public boolean isOverdue() {
        if (LocalDate.now().isBefore(deadLine)) return true;
        return false;
    }
    public String getSummary(){
        return "id: " + id + "creator" + creator;
    }

}
