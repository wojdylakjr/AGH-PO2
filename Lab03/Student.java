import java.util.ArrayList;

public class Student {
    private String firstName;
    private String secondName;
    private String email;

    private int index;
    private ArrayList<Double> arrayOfGrades = new ArrayList<>();

    Student(int index, String firstName, String secondName) {
        this.index = index;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addGrade(double grade) {
        arrayOfGrades.add(grade);
    }

    public double getAverage() {
        double sum = 0;
        for (Double grade : arrayOfGrades) {
            sum += grade;
        }
        return sum / arrayOfGrades.size();
    }

    @Override
    public String toString() {
        StringBuilder stringToReturn = new StringBuilder(firstName + " " + secondName + " (" + index + ") ");
        if (arrayOfGrades.size() != 0) {
            stringToReturn.append(" - ");
            for (Double grade : arrayOfGrades) {
                stringToReturn.append(grade);
                stringToReturn.append(" ");
            }
        }
        return stringToReturn.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }
        Student stud = (Student) obj;
        return this.index == stud.index && this.firstName.equals(stud.firstName) && this.secondName.equals(stud.secondName) && this.arrayOfGrades.equals(stud.arrayOfGrades);
    }

}