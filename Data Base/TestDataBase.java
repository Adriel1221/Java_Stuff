package teststudentdb;

import java.sql.*;

public class TestStudentDB {
  public static void main(String[] args) throws SQLException {
    // Load the JDBC driver
    //  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    //   System.out.println("Driver loaded");

    // Connect to a database
    //Connection connection = DriverManager.getConnection("jdbc:odbc:Students");
	
	Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Adriel.Camargo001/Desktop/Students.accdb");
    System.out.println("Database connected");

    // Create a statement
    Statement statement = connection.createStatement();

    // Execute a statement
    ResultSet resultSet = statement.executeQuery
      ("select firstName, lastName, Grade1, Grade2, Grade3 from StudentsTbl");

    // Iterate through the result and print the student names
    System.out.println("Name\tLast\tGrade1\tGrade2\tGrade3");
    
    while (resultSet.next()){
        System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + 
        		resultSet.getDouble(3) + "\t" + resultSet.getDouble(4) + "\t" + resultSet.getDouble(5));

    }
    // Close the connection
    connection.close();
  }
}
