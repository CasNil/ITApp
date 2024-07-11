package se.lexicon.dao.impl;

import se.lexicon.dao.TodoItemDAO;
import se.lexicon.model.TodoItem;
import se.lexicon.sequencers.TodoItemIdSequencer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TodoItemDAOImpl implements TodoItemDAO {

    private final List<TodoItem> items;

    private TodoItemDAOImpl() {
        items = new ArrayList<>();
    }

    @Override
    public TodoItem persist(TodoItem todoItem) {
        if (todoItem.getId() != 0) throw new IllegalArgumentException("Item id was not 0 ");
        todoItem.setId(TodoItemIdSequencer.nextId());
        items.add(todoItem);
        return todoItem;
    }

    @Override
    public TodoItem findById(int id) {
        for (TodoItem todoItem : items) {
            if (todoItem.getId() == id) {
                return todoItem;
            }
        }
        return null;
    }


    @Override
    public List<TodoItem> findAllByDoneStatus(boolean doneStatus) {
        List<TodoItem> result = new ArrayList<>();

        for (TodoItem todoItem : items) {
            if (todoItem.isDone()) {
                result.add(todoItem);
            }
        }
        return result;
    }

    @Override
    public List<TodoItem> findByTitleContains(String query) {
        List<TodoItem> result = new ArrayList<>();

        for (TodoItem todoItem : items) {
            if (todoItem.getTitle().equalsIgnoreCase(query)) {
                result.add(todoItem);
            }
        }
        return result;
    }

    @Override
    public List<TodoItem> findByPersonId(int id) {
        List<TodoItem> result = new ArrayList<>();

        for (TodoItem todoItem : items) {
            if (todoItem.getId() == id) {
                result.add(todoItem);
            }
        }
        return result;
    }

    @Override
    public List<TodoItem> findByDeadlineBefore(LocalDate date) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem todoItem : items) {
            if (todoItem.getDeadLine().isBefore(date)) {
                result.add(todoItem);
            }
        }
        return result;
    }

    @Override
    public List<TodoItem> findByDeadlineAfter(LocalDate date) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem todoItem : items) {
            if (todoItem.getDeadLine().isAfter(date)) {
                result.add(todoItem);
            }
        }
        return result;
    }

    @Override
    public List<TodoItem> findAll() {
        return new ArrayList<>(items);
    }

    @Override
    public void remove(int id) {
        TodoItem todoItem = findById(id);
        if (todoItem != null) items.remove(todoItem);
    }
}
