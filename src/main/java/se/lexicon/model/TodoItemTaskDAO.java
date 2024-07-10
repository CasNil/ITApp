package se.lexicon.model;

import java.util.Collection;

public interface TodoItemTaskDAO {
    TodoItemTask persist(String todoItemTask);

    TodoItemTask findById(int id);

    Collection<TodoItemTask> findAll();

    Collection<TodoItemTask> findByAssignedStatus(String status);

    Collection<TodoItemTask> findByPersonId(int personId);

    void remove(int id);

}
