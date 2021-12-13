import java.util.*;

class Main {
    public static void main(String[] args) {
        int x;
        while (true) {
            System.out.println("Podaj rozmiar planszy: ");
            try {
                x = SystemInWrapper.sc.nextInt();
                if (x < 2) {
                    throw new ArithmeticException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Podaj liczbe calkowita");
                SystemInWrapper.sc.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("Podaj liczbe wieksza od 2");
                SystemInWrapper.sc.nextLine();
            }
        }

        new Game().play(x);
    }
}
