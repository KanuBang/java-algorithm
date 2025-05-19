package org.graph_traversal.dfs.boj;
import java.io.*;
import java.util.*;
public class Boj2023 {
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);
    }

    static void dfs(int start, int digit) {
        if(digit == n){
            System.out.println(start);
            return;
        }

        for(int i=1; i<=9; i++) {

            if(i % 2 == 0) {
                continue;
            }

            int newNum = start * 10 + i;

            boolean isDigit = true;

            for(int j=2; j <= newNum/2; j++) {
                if(newNum % j == 0){
                    isDigit = false;
                    break;
                }
            }

            if(isDigit){

                dfs(newNum,digit+1); // 23, 2 -> 239,3 -> 23
            }

        }
    }
}
