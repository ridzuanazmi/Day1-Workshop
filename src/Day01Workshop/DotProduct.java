package Day01Workshop;

import java.io.Console;

public class DotProduct {
    
    public static void main(String[] args) {

        // Declare Console to allow user to input values
        Console cons = System.console();

        // Check the args length which input the values in the command prompt
        System.out.printf("args.length = %d\n ",args.length);
        
        // Print out content of args array
        for (int i = 0; i < args.length; i++) {
            System.out.printf(">>>>> args[%d] = %s\n", i, args[i]);        
        }

        // These 2 lines converts the String to an Integer value
        Integer row = Integer.parseInt(args[0]);
        Integer col = Integer.parseInt(args[1]);

        // Check on the number of rows and columns of the matrix that the user inputs
        System.out.printf("The number of row is %s \n",row);
        System.out.printf("The number of colums is %s\n",col);

        // Declaring the 2D array or matrix with the correct rows and columns
        Integer[][] mat = new Integer[row][col];

        // This loop asks the user to input the values into the matrix
        // Using a nested for loop to enter in order and converts the String value into Integer
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                String input = cons.readLine("Enter the value for Matrix [%s][%s]: ", i, j);
                //System.out.printf("Enter the value for Matrix [%s][%s]: ", i, j);
                //String input = cons.readLine();
                mat[i][j] = Integer.parseInt(input);
            }
        }
        System.out.println("\nThe order of the matrix is below");
        // This loop displays the Matrix in order
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.printf(mat[i][j] + " ");
            }
            System.out.printf("\n");
        }

        Integer row2 = col; // Auto sets the row to match the columns of the first array
        System.out.printf("\nThe number of rows for the second 2D array (weights) is %s\n", row2);
        String input2 = cons.readLine("Enter the number of columns for the second 2D array (weights) is ");
        Integer col2 = Integer.parseInt(input2);

        System.out.printf("The weights have %s rows and %s columns\n", row2, col2);
        Integer[][] weights = new Integer[row2][col2]; // weights is the name of the second array

        // This loop asks the user to input the values into the weights
        // Using a nested for loop to enter in order and converts the String value into Integer
        for (int i = 0; i < weights.length ; i++) {
            for (int j = 0; j < weights[0].length; j++) {
                String input = cons.readLine("Enter the value for Matrix [%s][%s]: ", i, j);
                //System.out.printf("Enter the value for Matrix [%s][%s]: ", i, j);
                //String input = cons.readLine();
                weights[i][j] = Integer.parseInt(input);
            }
        }

        System.out.println("\nThe order of the weights matrix is below");
        // This loop displays the weights in order
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[0].length; j++) {
                System.out.printf(weights[i][j] + " ");
            }
            System.out.printf("\n");
        }

        Integer row3 = row;
        Integer col3 = col2;
        // Declare new 2D array called dot product. 
        // It must have the row of the first matrix and column of the second matrix
        Integer[][] dotProduct = new Integer[row3][col3];
        // dotProduct[0][0] = 0;
              
        // This nested for loop calculates the mat and weights matrix
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < weights[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < mat[0].length; k++) {
                    sum += mat[i][k] * weights[k][j]; 
                }
                dotProduct[i][j] = sum;
            }
        }

        // Displays the result dotProduct matrix
        System.out.printf("\nThe dot product of the matrix and weights is below\n");
        for (int i = 0; i < dotProduct.length; i++) {
            for (int j = 0; j < dotProduct[0].length; j++) {
                System.out.printf(dotProduct[i][j] + " ");
            }
            System.out.printf("\n");
        }
    }
}