import java.sql.*;

public class TestStudentDB {
  public static void main(String[] args) throws SQLException, Exception {
      StudentList studentList = new StudentList();

	studentList.readStudents();
	studentList.saveStudentsToDB();    
        studentList.writeStudents();
        studentList.writeSortedStudents();
	studentList.findStudent();

  }
}
