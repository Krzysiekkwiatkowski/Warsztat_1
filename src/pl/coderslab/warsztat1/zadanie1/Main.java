package pl.coderslab.warsztat1.zadanie1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        guess();

    }

    static String guess() {

        String result = "Pudło";
        int number = (int) (Math.random() * 100);
        Scanner scanner = new Scanner(System.in);
        int guess = -1;
        while (result.equals("Pudło")) {
            System.out.println("Zgadnij liczbę");
            try {
                guess = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("To nie jest liczba");
                result = "Pudło";
                scanner.next();
                continue;
            }
            if (number == guess) {
                System.out.println("Zgadłeś");
                result = "Zgadłeś";
            } else {
                if (guess < number){
                    System.out.println("Za mało");
                    result = "Pudło";
                }
                if (guess > number){
                    System.out.println("Za dużo");
                    result = "Pudło";
                }
            }


        }
        return result;
    }
}
