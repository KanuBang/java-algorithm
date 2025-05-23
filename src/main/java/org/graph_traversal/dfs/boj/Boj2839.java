package org.graph_traversal.dfs.boj;

import java.util.Scanner;
import java.lang.*;
public class Boj2839 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new int[5000+1];
        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        dp[4] = -1;
        dp[5] = 1;

        for(int i = 6; i <= n; i++){
            if(dp[i-5] != -1){
                dp[i] = dp[i-5] + 1;
            }
            else if(dp[i-3] != -1){
                dp[i] = dp[i-3] + 1;
            }
            else{
                dp[i] = -1;
            }
        }

        System.out.println(dp[n]);


    }
}
