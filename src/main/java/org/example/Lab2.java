package org.example;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.Locale;

public class Lab2 {
    public void getResult() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        float[][] matrix;
        while(true) {
            try {
                System.out.println("Enter matrix size:");
                System.out.print("x = ");
                int x = scanner.nextInt();
                System.out.print("y = ");
                int y = scanner.nextInt();
                matrix = randomMatrix(x, y);

                System.out.print("\n");
                System.out.println("Random matrix:");
                show(matrix);
                System.out.print("\n");

                break;
            } catch (Exception e) {
                System.err.println("Error: Input Mismatch.\n");
                scanner.nextLine();
            }
        }

        while(true) {
            try {
                System.out.println("Enter matrix multiplier:");
                System.out.print("multiplier = ");
                float multiplier = scanner.nextFloat();
                matrix = multiMatrix(matrix, multiplier);
                System.out.print("\n");

                System.out.println("Multiplied matrix:");
                show(matrix);
                System.out.print("\n");

                System.out.println("Sum: " + getSum(matrix) + "\n");
                break;
            } catch (Exception e) {
                System.err.println("Error: Input Mismatch.\n");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private float[][] randomMatrix(int x, int y) {
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

    private void show(float[][] matrix) {
        for (float[] row : matrix) {
            for (float element : row) {
                System.out.print(element + "\t");
            }
            System.out.print("\n");
        }
    }

    private float[][] multiMatrix(float[][] matrix, float multiplier) {
        int y = matrix.length;
        int x = matrix[0].length;
        float[][] result = new float[y][x];

        for(int i = 0; i < y; i++)
            for(int j = 0; j < x; j++)
                result[i][j] = matrix[i][j] * multiplier;

        return result;
    }

    private float getSum(float[][] matrix) {
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
