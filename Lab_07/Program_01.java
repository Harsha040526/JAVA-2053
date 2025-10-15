package DIAGNOLS;



import java.util.Scanner;



public class DIAGNOL {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



        System.out.print("Enter the size of the square matrix (n): ");

        int n = sc.nextInt();



        int[][] matrix = new int[n][n];

        System.out.println("Enter the elements of the matrix:");



        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                matrix[i][j] = sc.nextInt();

            }

        }



        int upperSum = 0, lowerSum = 0, otherDiagonalSum = 0;



        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (i <= j)

                    upperSum += matrix[i][j];

                if (i >= j)

                    lowerSum += matrix[i][j];

                if (i + j == n - 1)

                    otherDiagonalSum += matrix[i][j];

            }

        }



        System.out.println("\nSum of Upper Diagonal elements: " + upperSum);

        System.out.println("Sum of Lower Diagonal elements: " + lowerSum);

        System.out.println("Sum of Other (Secondary) Diagonal elements: " + otherDiagonalSum);



        sc.close();

    }

}

