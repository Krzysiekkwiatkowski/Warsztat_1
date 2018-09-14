package pl.coderslab.warsztat1.zadanie4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println(throwCube("2D6"));
    }

    public static int throwCube(String cubeType) {
        String numberOfThrows = "";
        String numberOfWalls = "";
        String adds = "";
        int d = cubeType.indexOf("D");
        for (int i = 0; i < d; i++) {
            numberOfThrows += cubeType.charAt(i);
        }
        if (numberOfThrows.equals("")) {
            numberOfThrows = "1";
        }
        if (cubeType.contains("+")) {
            int plus = cubeType.indexOf("+");
            for (int i = d + 1; i < plus; i++) {
                numberOfWalls += cubeType.charAt(i);
            }
            for (int i = plus; i < cubeType.length(); i++) {
                adds += cubeType.charAt(i);
            }
        } else if (cubeType.contains("-")) {
            int minus = cubeType.indexOf("-");
            for (int i = d + 1; i < minus; i++) {
                numberOfWalls += cubeType.charAt(i);
            }
            for (int i = minus; i < cubeType.length(); i++) {
                adds += cubeType.charAt(i);
            }
        } else {
            for (int i = d + 1; i < cubeType.length(); i++) {
                numberOfWalls += cubeType.charAt(i);
            }
        }
        int throwNumber = Integer.parseInt(numberOfThrows);
        int wallNumber = Integer.parseInt(numberOfWalls);
        String numberToAdd = "";
        char mark = '_';
        if (!adds.equals("")) {
            mark = adds.charAt(0);
            for (int i = 1; i < adds.length(); i++) {
                numberToAdd += adds.charAt(i);
            }
        }
        int add = 0;
        try {
            add = Integer.parseInt(numberToAdd);
        } catch (NumberFormatException e) {
            System.out.print("");
        }
        Random random = new Random();
        if (mark == '+') {
            return (random.nextInt((throwNumber * wallNumber) - throwNumber + 1) + throwNumber) + add;
        } else if (mark == '-') {
            int result = (random.nextInt((throwNumber * wallNumber) - throwNumber + 1) + throwNumber) - add;
        }
        return (random.nextInt((throwNumber * wallNumber) - throwNumber + 1) + throwNumber);
    }
}
