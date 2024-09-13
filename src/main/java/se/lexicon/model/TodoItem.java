package se.lexicon.model;


import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    private int id;
    private String title;
    private String description;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;
    private int assigneeId;


    public TodoItem(int id, String title, String description, LocalDate deadLine, boolean done, Person creator, int assigneeId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadLine = deadLine;
        this.done = done;
        this.creator = creator;
        this.assigneeId = assigneeId;
    }

    public TodoItem(int id, String title, String description, LocalDate deadLine, boolean done, int assigneeId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadLine = deadLine;
        this.done = done;
        this.assigneeId = assigneeId;
    }

    public TodoItem(int id, String title, String description, LocalDate deadLine) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadLine = deadLine;
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

    public int getAssigneeId() {
        return assigneeId;
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


    public String getDescription() {
        return description;
    }


    public String getTitle() {
        return title;
    }



    @Override
    public String toString() {
        return "Id: " + id + ", Title: " + title + ", Task: " + description + ", Deadline: " + deadLine + ", Done: " + done + ", Creator: " + creator;
    }


    @Override
    public boolean equals(Object obj) {
        {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            return (Objects.equals(id, ((TodoItem) obj).id) && Objects.equals(title, ((TodoItem) obj).title) && Objects.equals(description, ((TodoItem) obj).description) && Objects.equals(deadLine, ((TodoItem) obj).deadLine) && Objects.equals(done, ((TodoItem) obj).done) && Objects.equals(creator, ((TodoItem) obj).creator));
        }
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(id);
        result = prime * result + Objects.hashCode(title);
        result = prime * result + Objects.hashCode(description);
        result = prime * result + Objects.hashCode(deadLine);
        result = prime * result + Objects.hashCode(done);
        result = prime * result + Objects.hashCode(creator);

        return result;
    }
}
