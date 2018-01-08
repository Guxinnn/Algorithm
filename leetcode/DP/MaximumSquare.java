package DP;

/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
 */
public class MaximumSquare {
    public int maximalSquare(char[][] matrix) {
        // dp[i][j] represents maxium number with i, j as right bottom corner

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] - '0';
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }

        int max = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                max = Math.max(dp[i][j] * dp[i][j], max);
            }
        }

        return max;
    }
}
