package org.graph_traversal.dfs.boj;

import java.util.Scanner;
import java.lang.*;
public class Boj2579 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] s = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1; i < n+1; i++){
            s[i] = scanner.nextInt();
        }

        for(int i=1; i <= n; i++){

            if(i == 1){
                dp[i] = s[1];
            }
            else if(i == 2){
                dp[i] = dp[i-1] + s[2];
            }
            else{
                dp[i] = Math.max(dp[i-3]+s[i-1]+s[i], dp[i-2]+s[i]);
            }
        }

        System.out.println(dp[n]);

    }
}
