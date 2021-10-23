//Proszę napisać program, który przyjmuje jako argumenty wywołania programu wartości całkowite n, min, max. Następnie należy wylosować n liczb całkowitych z zakresu [min, max], wyświetlić je oraz znaleźć i wyświetlić:
//        1.stosunek liczb dodatnich do ujemnych,
//        2.najmniejszą z wylosowanych wartości,
//        3.największą z wylosowanych wartości.
//
//        Przykładowe wyjście programu może wyglądać następująco:
//        java11 Lab1 5 -100 100
//        Input arguments: n=5 min= -100, max=100
//        62
//        14
//        -19
//        -63
//        27
//        Positive/negative=1.5 minVal=-63, maxVal=62
package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        if (args.length == 3) {
            int n = Integer.parseInt(args[0]);
            int minRange = Integer.parseInt(args[1]);
            int maxRange = Integer.parseInt(args[2]);
            Random generator = new Random();
            int amountOfPositive = 0;
            int amountOfNegative = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int randomNumber = generator.nextInt(maxRange - minRange) + minRange;
                System.out.println(randomNumber);
                if (randomNumber < min) {
                    min = randomNumber;
                }
                if (randomNumber > max) {
                    max = randomNumber;
                }
                if (randomNumber > 0) {
                    ++amountOfPositive;
                } else if (randomNumber < 0) {
                    ++amountOfNegative;
                }
            }
            System.out.println("Stosunek liczb ujemnych do dodatnich: " + amountOfNegative + " : " + amountOfPositive);
            System.out.println("Wartosc minimalna: " + min);
            System.out.println("Wartosc maksymalna: " + max);

        } else {
            System.out.println("Zla ilosc argumentow");
        }

    }
}


