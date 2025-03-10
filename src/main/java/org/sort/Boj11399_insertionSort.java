package org.sort;
/*
5
3 1 4 3 2

1 2 3 3 4
- 1 + 3 + 6 + 9 + 13 = 10 + 22 = 32

 */

import java.util.*;
import java.io.*;

public class Boj11399_insertionSort {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        int[] s = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        /*
        5
        3 1 4 3 2
        */

        for(int i=1; i < n; i++){
            // 1. 삽입할 대상을 선택한다.
            int insert_value = a[i];
            int insert_index = i;

            // 2. 삽입할 위치를 찾는다.
            for(int j = i-1; j >= 0; j--) {
                if(insert_value > a[j]){
                    insert_index = j + 1;
                    break;
                }

                if(j == 0) {
                    insert_index = 0;
                }
            }


            // 3. 삽입할 위치부터 삽입되는 대상이 있는 요소까지 shift를 수행한다.
            for(int j = i; j > insert_index; j--){
                a[j] = a[j-1];
            }

            // 4. 대상을 삽입한다.
            a[insert_index] = insert_value;
        }

        // 5. 합배열을 구한다.
        s[0] = a[0];
        for(int i=1; i < n; i++) {
            s[i] = s[i-1] + a[i];
        }

        // 6. 합배열의 합을 구한다.
        for(int i=0; i < n; i++){
            sum += s[i];
        }

        System.out.println(sum);

    }
}
