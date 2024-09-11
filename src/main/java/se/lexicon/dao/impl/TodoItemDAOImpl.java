package se.lexicon.dao.impl;

import se.lexicon.dao.TodoItemDAO;
import se.lexicon.helper.MySQLConnection;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class TodoItemDAOImpl implements TodoItemDAO {


    @Override
    public TodoItem create(TodoItem todoItem) {
        String query = "INSERT INTO todo_item (title, description, deadline) VALUES (?, ?, ?)";
        TodoItem insertedTodoItem = null;

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, todoItem.getTitle());
            preparedStatement.setString(2, todoItem.getDescription());

            LocalDateTime localDateTime = todoItem.getDeadLine().atStartOfDay();
            Timestamp timestamp = Timestamp.valueOf(localDateTime);
            preparedStatement.setTimestamp(3, timestamp);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        insertedTodoItem = new TodoItem(id, todoItem.getTitle(), todoItem.getDescription(), todoItem.getDeadLine());
                    }
                }
            }

        } catch (SQLException e) {

        }
        return insertedTodoItem;
    }

    @Override
    public Collection<TodoItem> findAll() {
        String query = "SELECT * FROM todo_item";
        Collection<TodoItem> todoItemList = new ArrayList<>();


        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet rs = preparedStatement.executeQuery()) {


            while (rs.next()) {
                int itemId = rs.getInt("todo_id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                Timestamp deadlineTimestamp = rs.getTimestamp("deadline");
                boolean done = rs.getBoolean("done");
                int assigneeId = rs.getInt("assignee_id");

                LocalDate deadline = deadlineTimestamp.toLocalDateTime().toLocalDate();

                TodoItem todoItem = new TodoItem(itemId, title, description, deadline, done, assigneeId);
                todoItemList.add(todoItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItemList;
    }

    @Override
    public TodoItem findById(int id) {
        String query = "SELECT * FROM todo_item WHERE todo_id = ?";
        TodoItem todoItem = null;

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    int todoId = rs.getInt("todo_id");
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    Timestamp deadlineTimestamp = rs.getTimestamp("deadline");
                    boolean done = rs.getBoolean("done");
                    int assigneeId = rs.getInt("assignee_id");

                    LocalDate deadline = null;
                    if (deadlineTimestamp != null) {
                        deadline = deadlineTimestamp.toLocalDateTime().toLocalDate();
                    }
                    todoItem = new TodoItem(todoId, title, description, deadline, done, assigneeId);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItem;
    }

    @Override
    public Collection<TodoItem> findByDoneStatus(boolean doneStatus) {
        String query = "SELECT * FROM todo_item WHERE done = ?";
        Collection<TodoItem> todoItems = new ArrayList<>();

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setBoolean(1, doneStatus);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    int todoId = rs.getInt("todo_id");
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    Timestamp deadlineTimestamp = rs.getTimestamp("deadline");
                    boolean done = rs.getBoolean("done");
                    int assigneeId = rs.getInt("assignee_id");

                    LocalDate deadline = null;
                    if (deadlineTimestamp != null) {
                        deadline = deadlineTimestamp.toLocalDateTime().toLocalDate();
                    }
                    TodoItem todoItem = new TodoItem(todoId, title, description, deadline, done, assigneeId);
                    todoItems.add(todoItem);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return todoItems;
    }

    @Override
    public Collection<TodoItem> findByAssignee(int assignee) {
        String query = "SELECT * FROM todo_item WHERE assignee_id = ?";
        Collection<TodoItem> todoItems = new ArrayList<>();

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, assignee);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    int todoId = rs.getInt("todo_id");
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    Timestamp deadlineTimestamp = rs.getTimestamp("deadline");
                    boolean done = rs.getBoolean("done");
                    int assigneeId = rs.getInt("assignee_id");


                    LocalDate deadline = null;
                    if (deadlineTimestamp != null) {
                        deadline = deadlineTimestamp.toLocalDateTime().toLocalDate();
                    }
                    TodoItem todoItem = new TodoItem(todoId, title, description, deadline, done, assigneeId);
                    todoItems.add(todoItem);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItems;
    }

    @Override
    public Collection<TodoItem> findByAssignee(Person person) {
        String query = "SELECT * FROM todo_item WHERE assignee_id = ?";
        Collection<TodoItem> todoItems = new ArrayList<>();

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, person.getId());

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("todo_id");
                String title = rs.getString("title");
                String taskDescription = rs.getString("description");
                Timestamp deadlineTimestamp = rs.getTimestamp("deadline");
                boolean done = rs.getBoolean("done");
                int assigneeId = rs.getInt("assignee_id");

                LocalDate deadline = null;
                if (deadlineTimestamp != null) {
                    deadline = deadlineTimestamp.toLocalDateTime().toLocalDate();
                }
                TodoItem item = new TodoItem(id, title, taskDescription, deadline, done, person, assigneeId);

                todoItems.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItems;
    }

    @Override
    public Collection<TodoItem> findByUnassignedTodoItems() {
        String query = "SELECT todo_id, title, description, deadline FROM todo_item WHERE assignee_id IS NULL";
        Collection<TodoItem> todoItems = new ArrayList<>();

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int todoId = rs.getInt("todo_id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                Timestamp deadlineTimestamp = rs.getTimestamp("deadline");
                boolean doneStatus = rs.getBoolean("done");
                int assigneeId = rs.getInt("assignee_id");


                LocalDate deadline = null;
                if (deadlineTimestamp != null) {
                    deadline = deadlineTimestamp.toLocalDateTime().toLocalDate();
                }
                TodoItem item = new TodoItem(todoId, title, description, deadline, doneStatus, null, assigneeId);

                todoItems.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoItems;
    }

    @Override
    public TodoItem update(TodoItem todoItem) {
        String query = "UPDATE todo_item SET title = ?, description = ?, deadline = ?, done = ?, assignee_id = ? WHERE todo_id = ?";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, todoItem.getTitle());
            preparedStatement.setString(2, todoItem.getDescription());
            preparedStatement.setTimestamp(3, todoItem.getDeadLine() != null ? Timestamp.valueOf(todoItem.getDeadLine().atStartOfDay()) : null);
            preparedStatement.setBoolean(4, todoItem.isDone());
            preparedStatement.setObject(5, todoItem.getCreator() != null ? todoItem.getCreator().getId() : null, Types.INTEGER);
            preparedStatement.setInt(6, todoItem.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("TodoItem updated successfully.");
                return todoItem;
            } else {
                System.out.println("No TodoItem found with the specified ID.");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        String query = "DELETE FROM todo_item WHERE todo_id = ?";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("TodoItem with ID: " + id + "deleted successfully.");
                return true;
            } else {
                System.out.println("No TodoItem found with ID: " + id + ".");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
