import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("2D Array Approach-1");
        System.out.println();

        int[][] arr1 = new int[3][3];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter inputs for first array-");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr1[i][j] = input.nextInt();
            }
        }

        System.out.print("Values are: ");
        System.out.println();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr1[i][j] + "   ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println("2D Array Approach-2");
        System.out.println();

        int[][] arr2 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        System.out.print("Values are: ");
        System.out.println();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr2[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println("2D Array Approach-3");
        System.out.println();
        int[][] arr3;
        System.out.println("Enter size for third array-");
        int row = input.nextInt();
        System.out.println("Enter size for third array-");
        int col = input.nextInt();

        arr3 = new int[row][col];

        System.out.println("Enter inputs for third array-");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr3[i][j] = input.nextInt();
            }
        }
        System.out.print("Values are: ");
        System.out.println();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr3[i][j] + "   ");
            }
            System.out.println();
        }
    }
}