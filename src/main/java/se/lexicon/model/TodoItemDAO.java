package se.lexicon.model;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO {
    TodoItem persist(String todoItem);

    TodoItem findById(int id);

    Collection<TodoItem> findAll();

    Collection<TodoItem> findAllByDoneStatus(String done);

    Collection<TodoItem> findByTitleContains(String title);

    Collection<TodoItem> findByPersonId(int personId);

    Collection<TodoItem> findByDeadlineBefore(LocalDate date);

    Collection<TodoItem> findByDeadlineAfter(LocalDate date);

    void remove(int id);

}
