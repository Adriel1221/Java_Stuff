package studentgrade;

public class Student implements Comparable {

    private String firstName;
    private String lastName;
    private String status;
    private double grade1, grade2, grade3;
    private double average;
    char letterGrade;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }

    public char getLetterGrade() {
        computeLetterGrade();
        return letterGrade;
    }

    public void setLetterGrade(char letterGrade) {
       this.letterGrade = letterGrade;
    }

    public String getStatus() {
        computeStatus();
        return status;
    }

    private void setStatus(String status) {
        this.status = status;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public double getGrade1() {
        return grade1;
    }

    public void setGrade1(double grade1) {
        this.grade1 = grade1;
    }

    public double getGrade2() {
        return grade2;
    }

    public void setGrade2(double grade2) {
        this.grade2 = grade2;
    }

    public double getGrade3() {
        return grade3;
    }

    public void setGrade3(double grade3) {
        this.grade3 = grade3;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getAverage() {
        return average;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAverage(double average) {
        
        this.average = average;
    }
    
    

    public double computeAverage() {
        return (grade1 + grade2 + grade3) / 3;
    }

    public void computeStatus() {
        if (computeAverage() < 70) {
            setStatus("Failing");
        } else {
            setStatus("Passing");
        }
    }
    
    public void  computeLetterGrade(){
         if (computeAverage()  >= 90) {
            letterGrade = 'A';
        } else if (computeAverage()  >= 80) {
            letterGrade = 'B';
        } else if (computeAverage()  >= 70) {
            letterGrade = 'C';
        } else if (computeAverage()  >= 60) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }
}
    
    

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
