import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private final String firstName;
    private final String secondName;
    private final int index;
    private final double[] arrayOfGrades;

    private Student(String firstName, String secondName, int index, double[] grades) {
        this.index = index;
        this.firstName = firstName;
        this.secondName = secondName;
        this.arrayOfGrades = grades;
    }

    public double[] getGrades() {
        double[] copiedArray = new double[arrayOfGrades.length];
        System.arraycopy(arrayOfGrades, 0, copiedArray, 0, arrayOfGrades.length);
        return copiedArray;
    }

    @Override
    public String toString() {
        StringBuilder stringToReturn = new StringBuilder(new String(firstName + " " + secondName + " (" + index + ") "));
        if (arrayOfGrades == null || arrayOfGrades.length == 0) {
            return stringToReturn.toString();
        } else {
            stringToReturn.append(" - ");
            for (Double grade : arrayOfGrades) {
                stringToReturn.append(grade);
                stringToReturn.append(" ");
            }
            return stringToReturn.toString();
        }
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
        return this.index == stud.index && this.firstName.equals(stud.firstName) && this.secondName.equals(stud.secondName) && Arrays.equals(this.arrayOfGrades, stud.arrayOfGrades);
    }

    public static class Builder {
        private int arrayIndex = 0;
        private String firstName;
        private String secondName;
        private int index = -1;
        private double[] arrayOfGrades;

        public Builder firstName(String name) {
            this.firstName = name;
            return this;
        }

        public Builder lastName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Builder indexNumber(int indexNumber) {
            this.index = indexNumber;
            return this;
        }

        public Builder grade(double grade) {
            double[] tempArray = new double[arrayIndex + 1];

            if (arrayIndex >= 0 && arrayOfGrades != null) {
                System.arraycopy(arrayOfGrades, 0, tempArray, 0, arrayIndex);
            }

            arrayOfGrades = tempArray;
            arrayOfGrades[arrayIndex++] = grade;
            return this;
        }

        public Student build() {
            if (firstName == null) {
                System.out.println("First name is required!");
                return null;
            } else if (secondName == null) {
                System.out.println("Last name is required!");
                return null;
            } else if (index == -1) {
                System.out.println("Index is required!");
                return null;
            } else {
                return new Student(firstName, secondName, index, arrayOfGrades);
            }

        }
    }
}