package org.dp.sample;

import javax.management.MBeanRegistration;
import java.math.BigInteger;
import java.util.Scanner;

// 이 문제는 사실 구하는 경우가 너무 많아져
public class CombinationBottomUp {
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
                if(i==n && j ==m) break;

            }
        }

        System.out.println(dp[n][m]);
    }
}
