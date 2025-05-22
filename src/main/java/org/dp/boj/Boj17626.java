package org.dp.boj;

import java.util.Scanner;
import java.lang.Math;
import java.lang.*;
public class Boj17626 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new int[n+1];
        dp[1] = 1;

        for(int i=2; i <= n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                min = Math.min(min,dp[i - j*j]);
            }

            dp[i] = min + 1;
        }

        System.out.println(dp[n]);
    }
}
