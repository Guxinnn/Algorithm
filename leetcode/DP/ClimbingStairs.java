package DP;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int all_way = 0;
        int one_away = 2;
        int two_away = 1;

        for (int i = 2; i < n; i++) {
            all_way = one_away + two_away;
            two_away = one_away;
            one_away = all_way;
        }

        return all_way;
    }

    public static void main(String[] args) {
        ClimbingStairs c = new ClimbingStairs();
        System.out.print(c.climbStairs(7));
    }
}
