package chapter3.db;

import chapter3.tasks.Students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnector {

    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/javaee_db", "postgres", "Postgres");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Students> getAllStudents(){
        ArrayList<Students> students = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" + "SELECT * FROM t_students ");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String birthdate = resultSet.getString("birthdate");
                String city = resultSet.getString("city");

                Students student = new Students();
                student.setId(id);
                student.setName(name);
                student.setSurname(surname);
                student.setBirthdate(birthdate);
                student.setCity(city);
                students.add(student);
            }
            statement.close();
        } catch(Exception e) {
        e.printStackTrace();
        }
    return students;
    }

    public static void addStudent(Students students){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO t_students(name,surname,birthdate,city)" + "VALUES (?,?,?,?)");
            statement.setString(1,students.getName());
            statement.setString(2,students.getSurname());
            statement.setString(3,students.getBirthdate());
            statement.setString(4,students.getCity());
            statement.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Students getStudent(Long id){
        Students students = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" + "SELECT * FROM t_students WHERE id = ? ");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name= resultSet.getString("name");
                String surname= resultSet.getString("surname");
                String birthdate= resultSet.getString("birthdate");
                String city= resultSet.getString("city");

                students=new Students();
                students.setId(id);
                students.setName(name);
                students.setSurname(surname);
                students.setBirthdate(birthdate);
                students.setCity(city);
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }
    public static void saveStudent(Students students){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE t_students SET name=?, surname=?, birthdate=?, city=? " + " WHERE id= ? ");
            statement.setString(1,students.getName());
            statement.setString(2,students.getSurname());
            statement.setString(3,students.getBirthdate());
            statement.setString(4,students.getCity());
            statement.setLong(5,students.getId());
            statement.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteStudent(Students student){

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM t_students WHERE id = ?");

            statement.setLong(1, student.getId());

            statement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    }

