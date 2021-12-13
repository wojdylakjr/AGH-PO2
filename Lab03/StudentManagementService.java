import java.util.ArrayList;

public class StudentManagementService {
    private ArrayList<Student> arrayOfStudents = new ArrayList<>();

    public void addStudent(Student student) {
        if (arrayOfStudents.contains(student)) {
            System.out.println("Student is already in database!");
        } else {
            arrayOfStudents.add(student);
        }
    }

    public void printAllStudents() {
        System.out.println("*** Students ***");
        for (Student student : arrayOfStudents) {
            System.out.println(student);
        }
    }

    public void removeStudent(Student student) {
        // System.out.println("Usuwam studenta");
        if (arrayOfStudents.contains(student)) {
            arrayOfStudents.remove(student);
        } else {
            System.out.println("Student is not exist in database!");
        }


    }

    public Student findStudentWithTheHighestAverage() {
        if (arrayOfStudents.size() > 0) {
            Student bestStudent = arrayOfStudents.get(0);
            double maxAverage = 0;
            for (Student student : arrayOfStudents) {
                if (student.getAverage() > maxAverage) {
                    maxAverage = student.getAverage();
                    bestStudent = student;
                }
            }
            return bestStudent;
        } else {
            return new Student(1, "a", "b");
        }

    }
}