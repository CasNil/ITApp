package se.lexicon.model;

import java.util.Objects;

public class TodoItemTask {
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask(TodoItem todoItem, Person assignee) {
        this.todoItem = todoItem;
        this.assignee = assignee;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        if (todoItem == null) throw new IllegalArgumentException("Item is not allowed to be null!");
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return "Id: " + id + "Assigned: " + assigned + ", Item: " + todoItem + ", Assignee: " + assignee;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return (Objects.equals(id, ((TodoItemTask) obj).id) && Objects.equals(assigned, ((TodoItemTask) obj).assigned) && Objects.equals(todoItem, ((TodoItemTask) obj).todoItem) && Objects.equals(assignee, ((TodoItemTask) obj).assignee));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(id);
        result = prime * result + Objects.hashCode(assigned);
        result = prime * result + Objects.hashCode(todoItem);
        result = prime * result + Objects.hashCode(assignee);

        return result;
    }
}
