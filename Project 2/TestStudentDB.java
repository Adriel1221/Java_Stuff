package student;

public class TestStudent {
  public static void main(String[] args) throws Exception, Exception {
      StudentList studentList = new StudentList();

	studentList.readStudents();
	studentList.saveStudentsToDB();    
        studentList.writeStudents();
        studentList.writeSortedStudents();
	studentList.findStudent();

  }
}
