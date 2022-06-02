package chapter2.db;

import chapter2.tasks.TaskManager;

import java.sql.*;
import java.util.ArrayList;

public class DBConnector {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/javaee_db", "postgres", "Postgres");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<TaskManager> getAllTasks() {

        ArrayList<TaskManager> task=new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" + "SELECT *FROM t_tasks");
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
                Long id=resultSet.getLong("id");
                String name = resultSet.getString("name");
                String status = resultSet.getString("status");
                String deadline = resultSet.getString("deadline");

                TaskManager tasks=new TaskManager();
                tasks.setId(id);
                tasks.setName(name);
                tasks.setDeadlineDate(deadline);
                tasks.setStatus(status);
                task.add(tasks);

            }
            statement.close();
        } catch (Exception e) {
e.printStackTrace();
        }
        return task;
    }
    public static void addTask(TaskManager task) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO t_tasks(name,deadline,status) " +
                    "VALUES (?,?,?)");
            statement.setString(1, task.getName());
            statement.setString(2,task.getDeadlineDate());
            statement.setString(3,task.getStatus());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
