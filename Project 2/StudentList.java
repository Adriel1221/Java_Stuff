import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.sql.*;

public class StudentList {

    
    ArrayList<Student> students = new ArrayList<Student>();
    private File file;
    private String routeDB;

    public void readStudents() throws Exception {
        double grade1 = 0;
        double grade2 = 0;
        double grade3 = 0;

        JFileChooser filechooser = new JFileChooser();
        filechooser.setDialogTitle("Chose Original Document");
        if (filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            File f = filechooser.getSelectedFile();
            Scanner input = new Scanner(f);
            
            while (input.hasNext()) {

                String line = input.next();
                String[] values = line.split("\\|");

                if (values.length == 5) {
                    grade1 = Double.parseDouble(values[2]);
                    grade2 = Double.parseDouble(values[3]);
                    grade3 = Double.parseDouble(values[4]);
                } else if (values.length == 4) {
                    grade1 = Double.parseDouble(values[2]);
                    grade2 = Double.parseDouble(values[3]);
                    grade3 = 0;
                } else if (values.length == 3) {
                    grade1 = Double.parseDouble(values[2]);
                    grade2 = 0;
                    grade3 = 0;
                } else {
                    grade1 = 0;
                    grade2 = 0;
                    grade3 = 0;

                }
                
                
                Student student = new Student(values[0], values[1]);
                student.setGrade1(grade1);
                student.setGrade2(grade2);
                student.setGrade3(grade3);
                students.add(student);
                
            }
            input.close();
        } else {
            System.out.println("No File selected");
        }
    }

    public void writeStudents() throws Exception {

        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getfirstName() + " " + students.get(i).getGrade1() + " " + students.get(i).getGrade2() + " " + students.get(i).getGrade3() + " " + students.get(i).computeAverage() + " " + students.get(i).getStatus());
            System.out.println();
        }

        javax.swing.JFileChooser jF1 = new javax.swing.JFileChooser();
        String route;
        jF1.setDialogTitle("Chose File to Write");
        try {
            if (jF1.showSaveDialog(null) == jF1.APPROVE_OPTION) {
                route = jF1.getSelectedFile().getAbsolutePath();
                File file = new java.io.File(route);

                if (file.exists()) {
                    PrintWriter output = new java.io.PrintWriter(file);

                    Connection connection = DriverManager.getConnection("jdbc:ucanaccess://" + routeDB);
                    System.out.println("Database connected");

                    Statement statement = connection.createStatement();

                    ResultSet resultSet = statement.executeQuery("select firstName, lastName, Grade1, Grade2, Grade3, Average, Status, LetterGrade from StudentsTbl");

                    
                        
                    while (resultSet.next()) {
                        output.print(resultSet.getString(1) + "\t");
                        output.print(resultSet.getString(2) + "\t\t");
                        output.print(resultSet.getDouble(3) + "\t\t");
                        output.print(resultSet.getDouble(4) + "\t\t");
                        output.print(resultSet.getDouble(5)+"\t\t");
                        output.print(resultSet.getDouble(6)+"\t\t");
                        output.print(resultSet.getString(7)+"\t\t");
                        output.println(resultSet.getString(8)+"\t\t");

                    }
                    output.close();
                    connection.close();

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void saveStudentsToDB() throws SQLException {
        javax.swing.JFileChooser jF1 = new javax.swing.JFileChooser();
        jF1.setDialogTitle("Choose Data Base");
        if (jF1.showSaveDialog(null) == jF1.APPROVE_OPTION) {
            routeDB = jF1.getSelectedFile().getAbsolutePath();
            System.out.println(routeDB);

            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://" + routeDB);
            System.out.println("Database connected");

            Statement statement = connection.createStatement();
            for (int i = 0; i < students.size(); i++) {
                try {
                    Statement st = connection.createStatement();
                    String sql = "insert into StudentsTbl (FirstName, LastName, Grade1, Grade2, Grade3, Average, Status, LetterGrade)values" + "('" + students.get(i).getfirstName() + "','" + students.get(i).getLastName() + "','" + students.get(i).getGrade1() + "','" + students.get(i).getGrade2() + "','" + students.get(i).getGrade3() + "','" + students.get(i).computeAverage() + "','" + students.get(i).getStatus() + "','" + students.get(i).getLetterGrade() + "')";
                    st.executeUpdate(sql);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error" + e);
                }
            }

            ResultSet resultSet = statement.executeQuery("select firstName, lastName, Grade1, Grade2, Grade3, Average, Status, LetterGrade from StudentsTbl");

            connection.close();
        }
    }

    public void writeSortedStudents() {
        javax.swing.JFileChooser jF1 = new javax.swing.JFileChooser();
        String route;
        jF1.setDialogTitle("Choose File to Sort");
        try {
            if (jF1.showSaveDialog(null) == jF1.APPROVE_OPTION) {
                route = jF1.getSelectedFile().getAbsolutePath();
                File file = new java.io.File(route);
                
                if (file.exists()) {
                    PrintWriter output = new java.io.PrintWriter(file);

                    Connection connection = DriverManager.getConnection("jdbc:ucanaccess://" + routeDB);
                    System.out.println("Database connected");

                    Statement statement = connection.createStatement();

                    ResultSet resultSet = statement.executeQuery("select firstName, lastName, Grade1, Grade2, Grade3, Average, Status, LetterGrade from StudentsTbl order by Average asc;");

                    output.println("Name\tLast\tGrade1\tGrade2\tGrade3");
                    
                     while (resultSet.next()) {
                        output.print(resultSet.getString(1) + "\t");
                        output.print(resultSet.getString(2) + "\t\t");
                        output.print(resultSet.getDouble(3) + "\t\t");
                        output.print(resultSet.getDouble(4) + "\t\t");
                        output.print(resultSet.getDouble(5)+"\t\t");
                        output.print(resultSet.getDouble(6)+"\t\t");
                        output.print(resultSet.getString(7)+"\t\t");
                        output.println(resultSet.getString(8)+"\t\t");

                    }
                    
                    
                    output.close();
                    connection.close();

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        

    }

    public void findStudent() {
        String name = "";
        String lastName = "";
        Scanner userInput = new Scanner(System.in);

        do {
            System.out.println("If you don't want to continue type end");
            System.out.println("Please enter the first name of the student you are looking for: ");
            name = userInput.nextLine();
            if (name.equals("end")) {
                break;
            }
            System.out.println("Please enter the last name of the student you are looking for: ");
            lastName = userInput.nextLine();

            try {
                if (!name.equals("end") || !lastName.equals("end")) {

                    Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\jose.aparicio002\\Documents\\Students.accdb");
                    System.out.println("Database connected");

                    Statement statement = connection.createStatement();

                    ResultSet resultSet = statement.executeQuery("select firstName, lastName, Grade1, Grade2, Grade3, Average, Status, LetterGrade from StudentsTbl");
                    System.out.println("Name\tLast\tGrade1\tGrade2\tGrade3");
                    while (resultSet.next()) {

                        if (resultSet.getString(1).equals(name) && resultSet.getString(2).equals(lastName)) {
                            System.out.println("Student found!");
                            System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t"
                                    + resultSet.getDouble(3) + "\t" + resultSet.getDouble(4) + "\t" + resultSet.getDouble(5));
                            break;
                        } else {
                            System.out.println("Student not found!");
                        }
                    }

                    connection.close();

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } while (!name.equals("end") || !lastName.equals("end"));
    }

}
