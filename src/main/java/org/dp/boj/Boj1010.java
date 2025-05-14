package org.dp.boj;

import java.util.Scanner;

public class Boj1010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        for(int i=0; i < x; i++){
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            long[][] dp = new long[m+1][m+1];

            // 1) nCn = nC0 = 1
            for(int j=1; j < m+1; j++){
                dp[j][j] = 1;
                dp[j][0] = 1;
            }

            // 2) n+1Cr+1 = nCr + nCr+1
            for(int k=1; k < m; k++){
                for(int z=0; z < k; z++){
                    dp[k+1][z+1] = dp[k][z] + dp[k][z+1];
                }
            }
            System.out.println(dp[m][n]);
        }

    }
}
