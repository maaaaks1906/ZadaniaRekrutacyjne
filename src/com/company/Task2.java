package com.company;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Task2 {

    private static Scanner scanner = new Scanner(System.in);

    private static int[][] array;
    private static int[][] secondArray;

    public static void main(String[] args) {
        System.out.println("Podaj liczbę wierszy: ");
        int rows = scanner.nextInt();

        System.out.println("Podaj liczbę kolumn");
        int columns = scanner.nextInt();

        System.out.println("Podaj do której kolumny wstawić 0: ");
        int zeroX = scanner.nextInt();

        System.out.println("Podaj do którego wiersza wstawić 0: ");
        int zeroY = scanner.nextInt();

        array = new int[rows][columns];
        secondArray = new int[rows][columns];

        fillArrayWithRandomNumbers();

        copyArrayToSecondArray();

        moveLeftPart(zeroX, zeroY);

        moveRightPart(zeroX, zeroY);

        moveTopPart(zeroX, zeroY);

        moveBottomPart(zeroX, zeroY);

        secondArray[zeroY][zeroX] = 0;

        printArray(array);
        printArray(secondArray);
    }

    private static void moveBottomPart(int zeroX, int zeroY) {
        for (int i = zeroY + 1; i < array.length; i++) {
            secondArray[i][zeroX] = array[i - 1][zeroX];
        }
    }

    private static void moveTopPart(int zeroX, int zeroY) {
        for (int i = 0; i <= zeroY; i++) {
            secondArray[i][zeroX] = array[i + 1][zeroX];
        }
    }

    private static void moveRightPart(int zeroX, int zeroY) {
        for (int i = zeroX + 1; i < array.length; i++) {
            secondArray[zeroY][i] = array[zeroY][i - 1];
        }
    }

    private static void moveLeftPart(int zeroX, int zeroY) {
        for (int i = zeroX - 1; i >= 0; i--) {
            secondArray[zeroY][i] = array[zeroY][i+1];
        }
    }

    private static void copyArrayToSecondArray() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                secondArray[i][j] = array[i][j];
            }
        }
    }

    private static void fillArrayWithRandomNumbers() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = ThreadLocalRandom.current().nextInt(1, 9);
            }
        }
    }


    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
