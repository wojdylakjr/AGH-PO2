public class StudentWFiIS1 extends Student implements StudentUSOS {
    private String[] przedmioty;
    private int rokStudiow;


    public StudentWFiIS1(String name, String surname, int id, int rok, String subject1, double grade1, String subject2, double grade2, String subject3, double grade3) {
        super(name, surname, id, grade1, grade2, grade3);
        przedmioty = new String[3];
        przedmioty[0] = subject1;
        przedmioty[1] = subject2;
        przedmioty[2] = subject3;
        this.rokStudiow = rok;

    }

    @Override
    public String toString() {
        return "[" + rokStudiow + "] " + super.toString();
    }

    @Override
    public double srednia() {
        return super.average();
    }

    @Override
    public void listaPrzedmiotow() {

        for (int i = 0; i < przedmioty.length; i++) {
            System.out.println(i + 1 + " " + przedmioty[i] + " " + getGrade(i));
        }
    }

}
