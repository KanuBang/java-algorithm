package org.dp.boj;

import java.util.Scanner;

public class Boj10844 {
    static long mod = 1000000000;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] dp = new long[n+1][11]; // 자릿수 + 0,1,2,3,4,5,6,7,8,9

        for(int i=1; i <= 9; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i <= n; i++){
            dp[i][0] = dp[i-1][1];
            dp[i][9] = dp[i-1][8];

            for(int j=1; j <= 9; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
            }
        }

        long sum = 0;
        for(int i=0; i < 10; i++){
            sum = (sum+dp[n][i]) % mod;
        }

        System.out.println(sum);

    }
}
