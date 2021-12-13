public class EmailService {
    public void generateEmailForStudent(Student student, String facultyName) {
        student.setEmail(student.getFirstName() + "." + student.getSecondName() + "@" + facultyName + ".pl");
    }
}