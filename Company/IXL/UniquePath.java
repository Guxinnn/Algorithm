package Company.IXL;

/**
 * Created by Doodle on 2/7/18.
 */
public class UniquePath {
    int uniquePathsWithObstacle(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0] == 0 ? 1 : 0;

        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] == 0 ? dp[i-1][0] : 0;
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j] == 0 ? dp[0][j-1] : 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[m-1][n-1];
    }

    int uniquePaths(int[][] grid) {
        int n = grid.length;

        int[] dp = new int[n];
        dp[0] = 1;

        for (int[] row : grid) {
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] += dp[j-1];
                }
            }
        }

        return dp[n-1];
    }
}
