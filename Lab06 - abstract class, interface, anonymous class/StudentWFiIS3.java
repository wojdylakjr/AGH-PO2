public class StudentWFiIS3 extends Student {
    private StudentUSOS stud;

    public StudentWFiIS3(String name, String surname, int id, int rok, String subject1, double grade1, String subject2, double grade2, String subject3, double grade3) {
        super(name, surname, id, grade1, grade2, grade3);
        String[] przedmioty = new String[3];
        przedmioty[0] = subject1;
        przedmioty[1] = subject2;
        przedmioty[2] = subject3;

        this.stud = new StudentUSOS() {
            @Override
            public String toString() {
                return "[" + rok + "] ";
            }

            @Override
            public double srednia() {
                return average();
            }

            @Override
            public void listaPrzedmiotow() {
                for (int i = 0; i < przedmioty.length; i++) {
                    System.out.println(i + 1 + " " + przedmioty[i] + " " + getGrade(i));
                }
            }

        };


    }

    @Override
    public String toString() {
        return this.stud.toString() + super.toString();
    }


    public double srednia() {
        return this.stud.srednia();
    }


    public void listaPrzedmiotow() {
        this.stud.listaPrzedmiotow();
    }
    /* IMPLEMETACJA METOD: */

}