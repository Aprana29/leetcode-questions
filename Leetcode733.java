import java.util.*;

public class Main {

    static int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public static void floodFill(int[][] image, int sr, int sc, int originalColor, int newColor) {

        // Base Conditions
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length)
            return;

        if (image[sr][sc] != originalColor)
            return;

        // Change color
        image[sr][sc] = newColor;

        // Visit all 4 directions
        for (int[] dir : directions) {
            int newRow = sr + dir[0];
            int newCol = sc + dir[1];

            floodFill(image, newRow, newCol, originalColor, newColor);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input rows and columns
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] image = new int[rows][cols];

        // Input matrix
        System.out.println("Enter image:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                image[i][j] = sc.nextInt();
            }
        }

        // Input starting row and column
        System.out.print("Enter starting row: ");
        int sr = sc.nextInt();

        System.out.print("Enter starting column: ");
        int scol = sc.nextInt();

        // Input new color
        System.out.print("Enter new color: ");
        int newColor = sc.nextInt();

        int originalColor = image[sr][scol];

        // If original color is already new color
        if (originalColor != newColor) {
            floodFill(image, sr, scol, originalColor, newColor);
        }

        // Print result
        System.out.println("\nFlood Filled Image:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}