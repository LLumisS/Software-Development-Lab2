package org.example;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        float[][] matrix = matrixInput(scanner);

        System.out.print("\n");
        System.out.println("Random matrix:");
        show(matrix);
        System.out.print("\n");

        matrix = multiInput(scanner, matrix);

        System.out.print("\n");
        System.out.println("Multiplied matrix:");
        show(matrix);

        System.out.print("\n");
        System.out.println("Sum: " + getSum(matrix) + "\n");

        scanner.close();
    }

    private static float[][] matrixInput(Scanner scanner) {
        while(true) {
            try {
                System.out.println("Enter matrix size:");

                System.out.print("x = ");
                int x = scanner.nextInt();

                System.out.print("y = ");
                int y = scanner.nextInt();

                return randomMatrix(x, y);
            } catch (Exception e) {
                System.err.println("Error: Input Mismatch.\n");
                scanner.nextLine();
            }
        }
    }

    private static float[][] multiInput(Scanner scanner, float[][] matrix) {
        while(true) {
            try {
                System.out.println("Enter matrix multiplier:");

                System.out.print("multiplier = ");
                float multiplier = scanner.nextFloat();

                return multiMatrix(matrix, multiplier);
            } catch (Exception e) {
                System.err.println("Error: Input Mismatch.\n");
                scanner.nextLine();
            }
        }
    }

    private static float[][] randomMatrix(int x, int y) {
        float[][] result = new float[y][x];
        float min = -10.0f;
        float max = 10.0f;
        Random random = new Random();

        for (int i = 0; i < y; i++)
            for (int j = 0; j < x; j++) {
                result[i][j] = min + random.nextFloat() * (max - min);
            }

        return result;
    }

    private static void show(float[][] matrix) {
        for (float[] row : matrix) {
            for (float element : row) {
                System.out.print(element + "\t");
            }
            System.out.print("\n");
        }
    }

    private static float[][] multiMatrix(float[][] matrix, float multiplier) {
        int y = matrix.length;
        int x = matrix[0].length;
        float[][] result = new float[y][x];

        for(int i = 0; i < y; i++)
            for(int j = 0; j < x; j++)
                result[i][j] = matrix[i][j] * multiplier;

        return result;
    }

    private static float getSum(float[][] matrix) {
        int y = matrix.length;
        int x = matrix[0].length;
        float sumMax = 0;
        float sumMin = 0;

        for (int i = 0; i < y; i++) {
            Arrays.sort(matrix[i]);
            if (i % 2 == 0)
                sumMin += matrix[i][0];
            else
                sumMax += matrix[i][x - 1];
        }
                
        return sumMax + sumMin;
    }
}