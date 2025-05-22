package org.dp.boj;

import java.util.Scanner;
import java.math.BigInteger;

public class Boj2407 {
    static BigInteger[][] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        dp = new BigInteger[n+1][n+1];

        // nC0, nCn = 1
        for(int i=1; i <= n; i++){
            dp[i][0] = dp[i][i] = new BigInteger("1");
        }

        // nCm = n-1Cm-1 + n-1Cm
        for(int i=2; i <= n; i++){
            for(int j=1; j < i; j++){
                dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
            }
        }

        System.out.println(dp[n][m]);
    }
}
