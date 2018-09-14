package pl.coderslab.warsztat1.zadanie2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] choosen = choosenNumbers();
        Arrays.sort(choosen);
        System.out.println("Wybrane liczby " + Arrays.toString(choosen));
        int[] randoms = randomNumbers();
        Arrays.sort(randoms);
        System.out.println("Wylosowane liczby " + Arrays.toString(randoms));
        result(randoms, choosen);
    }

    private static void result(int[] randoms, int[] choosen) {
        int points = 0;
        for (int i = 0; i < randoms.length; i++) {
            int helper = 0;
            for (int j = 0; j < choosen.length; j++) {
                if(choosen[j] != randoms[i]){
                    helper++;
                } else {
                    helper++;
                    points++;
                }
            }
        }
        if(points < 3){
            System.out.println("Słabo, nie trafiłeś nawet 3!");
        }
        if(points == 3){
            System.out.println("Gratulcje, trafiłeś 3!");
        }
        if(points == 4){
            System.out.println("Gratulcje, trafiłeś 4!");
        }
        if(points == 5){
            System.out.println("Gratulcje, trafiłeś 5!");
        }
        if(points == 6){
            System.out.println("Gratulcje, trafiłeś 6! Nie musisz już chodzić do pracy!");
        }
    }

    private static int[] choosenNumbers() {
        int[] choosen = new int[6];
        int counter = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź liczbę");
        while(scanner.hasNext()){
            try {
                int number = Integer.parseInt(scanner.next());
                int notRepeat = 0;
                for (int i = 0; i < counter; i++) {
                    if(choosen[i] != number){
                        notRepeat++;
                    }
                    if(notRepeat == counter){
                        choosen[i] = number;
                        counter++;
                        if(counter - 1 != choosen.length) {
                            System.out.println("Wprowadź liczbę");
                        }
                        break;
                    }
                    if(counter - 1 == i && notRepeat != counter){
                        i--;
                        System.out.println("Taka liczba zostałą już podana, wprowadź inną");
                        break;
                    }
                }
                if(counter - 1 == choosen.length){
                    break;
                }
            } catch (NumberFormatException e){
                System.out.println("To nie jest liczba, wprowadź poprawną wartość");
                continue;
            }
        }
        return choosen;
    }

    private static int[] randomNumbers() {
        Random random = new Random();
        int[] table = new int[6];
        for (int i = 0; i < table.length; i++) {
            int counter = 0;
            int number = random.nextInt(49) + 1;
            for (int j = 0; j <=i ; j++) {
                if(table[j] != number){
                    ++counter;
                }
                if(counter == i + 1){
                    table[j] = number;
                } else if (counter != i + 1 && i == j){
                    i--;
                }
            }
        }
        return table;
    }
}







