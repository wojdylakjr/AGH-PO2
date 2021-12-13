import java.util.*;
import java.lang.Math;
import java.lang.reflect.*;

class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Nie podano nic do obliczenia!");
            System.exit(1);
        }

        String[] splitted = splitArgs(args[0]);
        String methodName = splitted[0];
        double arg1 = 0.0;
        double arg2 = 0.0;
        Double result = null;

        try {
            if (splitted.length == 2) {
                arg1 = Double.parseDouble(splitted[1]);
                Class[] arg = new Class[]{double.class};
                Method m1 = Math.class.getMethod(methodName, arg);
                result = (Double) m1.invoke(null, arg1);
            } else if (splitted.length == 3) {
                arg1 = Double.parseDouble(splitted[1]);
                arg2 = Double.parseDouble(splitted[2]);
                Class[] arg = new Class[]{double.class, double.class};
                Method m2 = Math.class.getMethod(methodName, arg);
                result = (Double) m2.invoke(null, arg1, arg2);
            } else {
                throw new ArithmeticException("Zla liczba argumentow funkcji! Podaj jedna lub dwie liczby.");
            }
            System.out.println("Wynik: " + result);

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Argumenty funkcji musza byc liczbami!");
        } catch (Exception e) {
            System.out.println("Nie ma takiej metody!");
        }
    }

    public static String[] splitArgs(String arg) {
        return Arrays.stream(arg.split("[\\s+(),]")).filter(w -> w.isEmpty() == false).toArray(String[]::new);
    }
}