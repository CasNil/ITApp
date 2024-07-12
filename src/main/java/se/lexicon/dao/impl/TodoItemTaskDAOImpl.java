package se.lexicon.dao.impl;

import se.lexicon.dao.TodoItemTaskDAO;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItemTask;
import se.lexicon.sequencers.TodoItemTaskIdSequencer;

import java.util.ArrayList;
import java.util.List;

public class TodoItemTaskDAOImpl implements TodoItemTaskDAO {
    private final List<TodoItemTask> itemTaskList;

    private TodoItemTaskDAOImpl() {
        itemTaskList = new ArrayList<>();
    }

    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        if (todoItemTask.getId() != 0) throw new IllegalArgumentException("Item id was not 0");
        if (itemTaskList.contains(todoItemTask)) {
            throw new IllegalArgumentException("Item already exists");
        }
        todoItemTask.setId(TodoItemTaskIdSequencer.nextId());
        itemTaskList.add(todoItemTask);
        return todoItemTask;
    }

    @Override
    public TodoItemTask findById(int id) {
        for (TodoItemTask todoItemTask : itemTaskList) {
            if (todoItemTask.getId() == id) {
                return todoItemTask;
            }
        }
        return null;
    }

    @Override
    public List<TodoItemTask> findAll() {
        return new ArrayList<>(itemTaskList);
    }

    @Override
    public List<TodoItemTask> findByAssignedStatus(boolean assignedStatus) {
        List<TodoItemTask> result = new ArrayList<>();
        for (TodoItemTask todoItemTask : itemTaskList) {
            if (todoItemTask.isAssigned()) {
                result.add(todoItemTask);
            }
        }
        return result;
    }

    @Override
    public List<TodoItemTask> findByPersonId(int personId) {
        List<TodoItemTask> result = new ArrayList<>();
        for (TodoItemTask todoItemTask : itemTaskList) {
            if (todoItemTask.getAssignee().getId() == personId) {
                result.add(todoItemTask);
            }
        }
        return result;
    }

    @Override
    public TodoItemTask addAssignee(int idTask, Person person) {
        return null;
    }

    @Override
    public TodoItemTask removeAssignee(int idTask) {
        return null;
    }

    @Override
    public void remove(int id) {
        TodoItemTask todoItemTask = findById(id);
        if (todoItemTask != null) itemTaskList.remove(todoItemTask);
    }
}
