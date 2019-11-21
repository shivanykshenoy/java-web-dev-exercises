package org.launchcode.demos.lsn4classes2;

public class Student {

    private static int nextStudentId = 1;
    private String name;
    private int studentId;
    private int numberOfCredits = 0;
    private double gpa = 0.0;

    public Student () {

    }

    public Student (String name, int studentId, int numberOfCredits, double gpa) {
        this.name = name;
        this.studentId = studentId;
        this.numberOfCredits = numberOfCredits;
        this.gpa = gpa;
    }

    public Student(String name, int studentId) {
        this(name, studentId, 0, 0);
    }

    public Student(String name) {
        this(name, nextStudentId);
        nextStudentId++;
    }

    public String studentInfo() {
        return (this.name + " has a GPA of: " + this.gpa);
    }


    public String getGradeLevel() {
       if (this.numberOfCredits <= 29) {
           return "Freshman";
       } else if (this.numberOfCredits <= 59) {
           return "Sophomore";
       } else if (this.numberOfCredits <= 89) {
           return "Junior";
       } else if (this.numberOfCredits <= 119) {
           return "Senior";
       } else if (this.numberOfCredits >= 120){
           return "Graduated";
       } else {
           return "N/A";
       }
    }

    // TODO: Complete the addGrade method.
    public void addGrade(int courseCredits, double grade) {
        this.numberOfCredits = courseCredits;
        this.gpa = grade / courseCredits;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentId=" + studentId +
                ", numberOfCredits=" + numberOfCredits +
                ", gpa=" + gpa +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (getStudentId() != student.getStudentId()) return false;
        if (getNumberOfCredits() != student.getNumberOfCredits()) return false;
        if (Double.compare(student.getGpa(), getGpa()) != 0) return false;
        return getName().equals(student.getName());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getName().hashCode();
        result = 31 * result + getStudentId();
        result = 31 * result + getNumberOfCredits();
        temp = Double.doubleToLongBits(getGpa());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public double getGpa() {
        return gpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    private void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public static void main(String[] args) {
        Student sally = new Student("Sally",1,1,4.0);
        System.out.println("The Student class works! " + sally.getName() + " is a student!");
        System.out.println(sally);
        sally.addGrade(12, 3.5);
        System.out.println(sally);
        sally.addGrade(25, 3.8);
        System.out.println(sally);
    }
}
