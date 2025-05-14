package org.dp.boj;

import java.util.Scanner;

public class Boj1904 {
    static long[] dp;
    static int mod = 15746;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new long[n+1];
        if(n == 1){
            System.out.println(1);
            return;
        }
        dp[1] = 1;
        dp[2] = 2;
        long answer = topdown(n);
        System.out.println(answer % mod);
    }

    private static long topdown(int n) {
        if(dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = (topdown(n-1) + topdown(n-2)) % mod;
    }
}
