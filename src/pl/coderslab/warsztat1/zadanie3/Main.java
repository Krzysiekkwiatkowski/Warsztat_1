package pl.coderslab.warsztat1.zadanie3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        guessNumber();
    }

    public static void guessNumber(){
        System.out.println("Pomyśl liczbę od 0 do 1000, a ja ją zgadnę w max 10 próbach");
        int min = 0;
        int max = 1000;
        Scanner scanner = new Scanner(System.in);
        int guess = nextGuess(min, max);
        System.out.println("Zgaduję liczbę: " + guess + "\n" + "Zgadłem?");
        String check = scanner.nextLine();
        while(check.equals("nie")){
            System.out.println("Za dużo?");
            String wrong = scanner.nextLine();
            if(wrong.equals("tak")) {
                max = guess;
                guess = nextGuess(min, max);
                System.out.println("Zgaduję liczbę: " + guess + "\n" + "Zgadłem?");
                check = scanner.nextLine();
            } else if (wrong.equals("nie")) {
                System.out.println("Za mało?");
                wrong = scanner.nextLine();
                if (wrong.equals("tak")) {
                    min = guess;
                    guess = nextGuess(min, max);
                    System.out.println("Zgaduję liczbę: " + guess + "\n" + "Zgadłem?");
                    check = scanner.nextLine();
                } else if (wrong.equals("nie")) {
                    System.out.println("Nie oszukuj");
                    System.out.println("Zgaduję liczbę: " + guess + "\n" + "Zgadłem?");
                    check = scanner.nextLine();
                }
            }
        }
        System.out.println("Wygrałem!");
    }
    public static int nextGuess(int min, int max){
        return ((max - min)/2) + min;
    }
}
