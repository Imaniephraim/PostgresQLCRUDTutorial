package org.example;

import java.sql.*;

public class CRUD {

    private Connection connection;

    //constructor
    public CRUD(String url, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    //A method to create a new user
    public void createEmployee(String name, String email) throws SQLException{
        String query ="INSERT INTO employees (name, email) VALUES (?, ?)";

        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.executeUpdate();
        }
    }

    // a method for reading or retrieving employees from the database
    public void readEmployees() throws SQLException{
        String query = "SELECT id, name, email FROM employees";

        try(Statement statement = connection.createStatement()) {
            ResultSet resultset = statement.executeQuery(query);

            while(resultset.next()){
                System.out.println("ID: " + resultset.getInt("id") + " Name: " + resultset.getString("name") + " Email: " + resultset.getString("email"));
            }
        }
    }
    //a method for reading/retreiving a single person
    public void readOneEmployee(int id)throws SQLException{
        String  query = "SELECT * FROM employees WHERE id = ?";

        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + " Name: " + resultSet.getString("name") + " Email: " + resultSet.getString("email"));
            }else{
                System.out.println("Employee with ID: " + id + " Not Found!");
            }
        }
    }

    //a method for updating employees
    public void updateEmployee(int id, String name,String email) throws SQLException{
        String query = "UPDATE employees SET name = ?, email + ? WHERE id =?";

        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setInt(3, id);
            statement.executeUpdate();
        }
    }
    //a method for deleting an employee
    public void deleteEmployee(int id)throws SQLException{
        String query = "DELETE FROM employees WHERE id = ?";

        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}



























