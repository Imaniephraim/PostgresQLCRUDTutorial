package org.example;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) {
        // DB parameters
        String url = "jdbc:postgresql://localhost/crudDB";
        String user = "postgres";
        String password = "ephraIms@ccount";

        //perform the crud operations

        try {
            //create the CRUD object
            CRUD employee = new CRUD(url, user, password);

            //create a new employee
            //employee.createEmployee("Dominic Maroko", "email@email.com");
            //employee.createEmployee("Ryan Roimen", "email@email.com");
            //employee.createEmployee("Nathan Mopel", "email@email.com");
            //employee.createEmployee("Ephraim Imani", "email@email.com");
            //employee.createEmployee("Brenda Karimi", "email@email.com");
            //employee.createEmployee("Frank Maina", "email@email.com");
            //employee.createEmployee("Praise Mwangi", "email@email.com");

            //update an employee
          //  employee.updateEmployee( 7,"Muzna Hassan", "muzna@email.com");

            //delete an employee
           // employee.deleteEmployee(8);

            //read/retrieve employees
         // employee.readEmployees();

            //read one employee
           //employee.readOneEmployee(4);


        } catch (SQLException ex) {
            ex.printStackTrace();


        }
    }
}