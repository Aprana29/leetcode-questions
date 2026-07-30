import java.util.*;

public class Main {

    static int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    // DFS to calculate island area
    public static int dfs(int[][] grid, int row, int col) {

        // Base conditions
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return 0;

        if (grid[row][col] == 0)
            return 0;

        // Mark as visited
        grid[row][col] = 0;

        int area = 1;

        // Visit all 4 directions
        for (int[] dir : directions) {
            area += dfs(grid, row + dir[0], col + dir[1]);
        }

        return area;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] grid = new int[rows][cols];

        System.out.println("Enter the grid:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        System.out.println("Maximum Area of Island = " + maxArea);

        sc.close();
    }
}