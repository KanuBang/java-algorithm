package org.data_structure.array.구간합;

import java.util.*;
import java.io.*;
public class Boj11660 {
    public static void main(String[] args) throws Exception {
        // 1. 입력을 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] a = new int[n+1][n+1];

        for(int i = 1;  i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 구간 한 배열 D를 만든다.
        int[][] d = new int[n+1][n+1];
        for(int i = 1;  i <= n; i++){
            for(int j = 1; j <= n; j++){
                d[i][j] = d[i-1][j] + d[i][j-1] - d[i-1][j-1] + a[i][j];
            }
        }

        // 3. 구간 합을 구한다.
        for(int k = 0; k < m; k++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int answer = d[x2][y2] - d[x1-1][y2] - d[x2][y1-1] + d[x1-1][y1-1];
            System.out.println(answer);
        }
    }
}
