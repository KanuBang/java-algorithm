package org.dp.sample;

import java.util.Scanner;

public class TileTopDown {
    static int[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;

        System.out.println(topdown(n)%10007);
    }

    public static int topdown(int n){
        if(n==1){
            return dp[1];
        } else if (n==2) {
            return dp[2];
        } else if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = (topdown(n-1) + topdown(n-2)) % 10007 ;
    }
}
