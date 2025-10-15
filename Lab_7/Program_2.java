package matrix;



import java.util.Scanner;



public class matrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



        System.out.print("Enter the size of the square matrix (n): ");

        int n = sc.nextInt();



        int[][] mat = new int[n][n];



        System.out.println("Enter the elements of the matrix:");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                mat[i][j] = sc.nextInt();

            }

        }



        System.out.println("\nMatrix Entered:");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                System.out.print(mat[i][j] + "\t");

            }

            System.out.println();

        }



        if (n % 2 != 0) {

            int mid = n / 2;

            System.out.println("\nMiddle element (odd-sized matrix): " + mat[mid][mid]);

        } else {

            int mid1 = n / 2 - 1;

            int mid2 = n / 2;



            System.out.println("\nMiddle elements (even-sized matrix):");

            System.out.println(mat[mid1][mid1] + "  " + mat[mid1][mid2]);

            System.out.println(mat[mid2][mid1] + "  " + mat[mid2][mid2]);



            double avg = (mat[mid1][mid1] + mat[mid1][mid2] + mat[mid2][mid1] + mat[mid2][mid2]) / 4.0;

            System.out.println("Average of middle elements: " + avg);

        }



        sc.close();

    }

}

