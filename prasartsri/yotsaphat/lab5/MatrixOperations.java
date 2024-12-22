/*
 * This program allows the user to create and perform operations on matrices. 
 * The user can choose from various matrix types, including custom input, random, 
 * all zeros, all ones, and diagonal matrices. After creating the matrix, the user 
 * can perform operations such as transposing the matrix, calculating row and column sums, 
 * finding the minimum and maximum values, and displaying diagonal elements. 
 * The matrix is displayed after creation, and the user can interact with it through a 
 * menu-driven interface until they choose to exit. Error handling ensures that only valid 
 * inputs are accepted, and the program operates in a loop until the user decides to stop.
 * 
 * Author: Yotsaphat Prasartsri 
 * ID :673040403-7 
 * Sec : 1 
 * Last Updated: December 23, 2024
 */
package prasartsri.yotsaphat.lab5;

import java.util.Scanner;

public class MatrixOperations {
    private static int[][] matrix;
    private static int rows;
    private static int columns;
    private static final Scanner scanner = new Scanner(System.in);

    private static void displayCreationMenu() {
        System.out.println("Metrix Creation Menu:");
        System.out.println("1. User Input Matrix");
        System.out.println("2. Random Matrix (0-9)");
        System.out.println("3. All Zeros Matrix");
        System.out.println("4. All Ones Matrix");
        System.out.println("5. Diagonal Matrix");
        System.out.print("Enter your choice: ");
    }

    private static void createMatrix(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Enter matrix elements:");

                scanner.nextLine();
                for (int i = 0; i < rows; i++) {
                    while (true) {
                        String[] rowValues = scanner.nextLine().split(" ");

                        boolean hasZero = false;
                        for (int j = 0; j < columns; j++) {
                            matrix[i][j] = Integer.parseInt(rowValues[j]);
                            if (matrix[i][j] == 0) {
                                hasZero = true;
                            }
                        }

                        if (hasZero) {
                            System.out.println("Error: Zero is not allowed in the matrix. Please re-enter the row.");
                        } else {
                            break;
                        }
                    }
                }
                break;

            case 2:
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        matrix[i][j] = (int) (Math.random() * 10);
                    }
                }
                break;

            case 3:
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        matrix[i][j] = 0;
                    }
                }
                break;

            case 4:
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        matrix[i][j] = 1;
                    }
                }
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void createDiagonalMatrix() {
        matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%5d", value);
            }

            System.out.println();

        }

        System.out.println("");
    }

    private static void displayOperationsMenu() {
        System.out.println("Matrix Operations Menu:");
        System.out.println("1. Find Transpose of the Matrix");
        System.out.println("2. Calculate Sum ofRows and Columns ");
        System.out.println("3. Find Minnimum and Maximum Eelements");
        System.out.println("4. Display Diagonal Elements");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void transposeMatrix() {
        int[][] transposed = new int[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        System.out.println("\nTransposed Matrix:");
        displayMatrix(transposed);
    }

    private static void calculateSums() {

        System.out.println("");

        System.out.println("Row sums:");
        for (int i = 0; i < rows; i++) {
            int rowSum = 0;
            for (int j = 0; j < columns; j++) {
                rowSum += matrix[i][j];
            }
            System.out.printf("Row %d: %d\n", i + 1, rowSum);
        }

        System.out.println("");

        System.out.println("Column sums:");
        for (int j = 0; j < columns; j++) {
            int colSum = 0;
            for (int i = 0; i < rows; i++) {
                colSum += matrix[i][j];
            }
            System.out.printf("Column %d: %d\n", j + 1, colSum);
        }

        System.out.println("");

    }

    private static void findMinMax() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] < min)
                    min = matrix[i][j];
                if (matrix[i][j] > max)
                    max = matrix[i][j];
            }
        }

        System.out.println("");
        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);

        System.out.println("");
    }

    private static void displayDiagonal() {

        if (rows != columns) {
            System.out.println("Matrix is not square. Cannot display diagonal elements.");
            return;
        }

        int[][] diagonalMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            diagonalMatrix[i][i] = matrix[i][i];
        }

        System.out.println("The diagonal matrix is:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(diagonalMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        boolean continueProgram = true;
        while (continueProgram) {
            displayCreationMenu();
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4) {

                System.out.print("Enter number of rows: ");
                rows = scanner.nextInt();
                System.out.print("Enter number of columns: ");
                columns = scanner.nextInt();

                if (rows <= 0 || columns <= 0) {
                    System.out.println("Error: Dimensions must be greater than 0");
                    continue;
                }

                matrix = new int[rows][columns];
                createMatrix(choice);
            } else if (choice == 5) {
                // Diagonal matrix must be square
                System.out.print("Enter size of square matrix: ");
                rows = columns = scanner.nextInt();

                if (rows <= 0) {
                    System.out.println("Error: Size must be greater than 0");
                    continue;
                }

                matrix = new int[rows][rows];
                createDiagonalMatrix();
            } else {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            System.out.println("\nCreated Matrix:");
            displayMatrix(matrix);

            // Operations menu loop
            boolean continueOperations = true;
            while (continueOperations) {
                displayOperationsMenu();
                int operation = scanner.nextInt();

                switch (operation) {
                    case 1:
                        transposeMatrix();
                        break;
                    case 2:
                        calculateSums();
                        break;
                    case 3:
                        findMinMax();
                        break;
                    case 4:
                        displayDiagonal();
                        break;
                    case 5:
                        continueOperations = false;
                        continueProgram = false;
                        break;
                    default:
                        System.out.println("Invalid operation choice.");
                }
            }
        }
        scanner.close();
    }
}
