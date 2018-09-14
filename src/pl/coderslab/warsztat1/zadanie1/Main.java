package pl.coderslab.warsztat1.zadanie1;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int random = randomNumber();
        int guess = guess();
        while (!check(random, guess)) {
            guess = guess();
        }
    }

    private static boolean check(int random, int guess) {
        if (guess < random) {
            System.out.println("Za mało");
            return false;
        } else if (guess > random) {
            System.out.println("Za dużo");
            return false;
        } else {
            System.out.println("Zgadłeś!");
            return true;
        }
    }

    private static int guess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź liczbę");
        while (scanner.hasNext()) {
            try {
                int quess = Integer.parseInt(scanner.next());
                return quess;
            } catch (NumberFormatException e) {
                System.out.println("To nie jest liczba, wprowadź poprawną wartość");
                continue;
            }
        }
        return 0;
    }

    private static int randomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }
}
