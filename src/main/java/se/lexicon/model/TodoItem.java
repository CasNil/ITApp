package se.lexicon.model;


import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    private int id;
    public String title;
    public String taskDescription;
    public LocalDate deadLine;
    public boolean done;
    public Person creator;

    public TodoItem(int id, String title, String taskDescription, LocalDate deadLine, boolean done, Person creator) {
        this.id = id;
        this.title = title;
        this.taskDescription = taskDescription;
        this.deadLine = deadLine;
        this.done = done;
        this.creator = creator;
    }

    public TodoItem(String title, String taskDescription, LocalDate deadLine, boolean done, Person creator) {
        this.title = title;
        this.taskDescription = taskDescription;
        this.deadLine = deadLine;
        this.done = done;
        this.creator = creator;
    }

    public TodoItem(int id, String title, String taskDescription, LocalDate deadLine) {
        this.id = id;
        this.title = title;
        this.taskDescription = taskDescription;
        this.deadLine = deadLine;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        if (creator == null) throw new IllegalArgumentException("creator is not allowed to be null!");
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
        if (title == null || title.trim().isEmpty())
            throw new IllegalArgumentException("Title is not allowed to be null or empty!");
        this.title = title;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(deadLine);
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Title: " + title + ", Task: " + taskDescription + ", Deadline: " + deadLine + ", Done: " + done + ", Creator: " + creator;
    }

    @Override
    public boolean equals(Object obj) {
        {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            return (Objects.equals(id, ((TodoItem) obj).id) && Objects.equals(title, ((TodoItem) obj).title) && Objects.equals(taskDescription, ((TodoItem) obj).taskDescription) && Objects.equals(deadLine, ((TodoItem) obj).deadLine) && Objects.equals(done, ((TodoItem) obj).done) && Objects.equals(creator, ((TodoItem) obj).creator));
        }
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(id);
        result = prime * result + Objects.hashCode(title);
        result = prime * result + Objects.hashCode(taskDescription);
        result = prime * result + Objects.hashCode(deadLine);
        result = prime * result + Objects.hashCode(done);
        result = prime * result + Objects.hashCode(creator);

        return result;
    }
}
