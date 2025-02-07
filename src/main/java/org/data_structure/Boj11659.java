package org.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11659 {
    public static void main(String[] args) throws IOException {

        // 1. 입력을 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 2. 합(시그마)를 구한다.
        int[] sigma = new int[n+1];
        for(int i = 1;  i <= n ; i++) {
            sigma[i] = sigma[i-1] + Integer.parseInt(st.nextToken());
        }

        // 3. 구간을 입력 받는다
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            // always first < second
            int result = sigma[second] - sigma[first-1];
            System.out.println(result);
        }
        // 4. 시그마를 이용하여 구간합을 구한다.

    }
}
