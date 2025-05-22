package org.dp.boj;
import java.util.*;
public class Boj11727 {
    private static int[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new int[1000+1];
        dp[1] = 1;
        dp[2] = 3;
        topdown(n);
        System.out.println(dp[n] % 10007);

    }

    static int topdown(int a){
        if(a == 1 || a == 2){
            return dp[a];
        }
        if(dp[a] != 0){
            return dp[a];
        }

        return dp[a] = (topdown(a-1) + 2 * topdown(a-2)) % 10007;
    }

}
