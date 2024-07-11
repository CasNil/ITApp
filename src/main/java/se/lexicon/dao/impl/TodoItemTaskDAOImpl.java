package se.lexicon.dao.impl;

import se.lexicon.dao.TodoItemTaskDAO;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItemTask;

import java.util.List;

public class TodoItemTaskDAOImpl implements TodoItemTaskDAO {
    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        return null;
    }

    @Override
    public TodoItemTask findById(int id) {
        return null;
    }

    @Override
    public List<TodoItemTask> findAll() {
        return List.of();
    }

    @Override
    public List<TodoItemTask> findByAssignedStatus(boolean assignedStatus) {
        return List.of();
    }

    @Override
    public List<TodoItemTask> findByPersonId(int Id) {
        return List.of();
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

    }
}
