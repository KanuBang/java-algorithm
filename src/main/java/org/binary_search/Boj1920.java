package org.binary_search;
import java.io.*;
import java.util.*;
public class Boj1920 {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i < n; i++){
            a[i] = sc.nextInt();
        }

        //1. 데이터를 정렬한다
        Arrays.sort(a);

        int m = sc.nextInt();

        for(int i=0; i<m; i++){
            boolean find = false;
            int target = sc.nextInt();

            // 이진 탐색 시작
            int start = 0;
            int end = a.length - 1;

            while(start <= end) {
                int mid_idx = (start+end) / 2;
                int mid_value = a[mid_idx];

                // 2. 타깃 데이터가 중앙값보다 왼쪽에 있다면 탐색 지역을 왼쪽으로 축소한다.
                if(mid_value > target) {
                    end = mid_idx-1;
                // 3. 타깃 데이터가 중앙값보다 오른쪽에 있다면 탐색 지역을 오른쪽으로 축소한다.
                } else if(mid_value < target) {
                    start = mid_idx+1;
                // 4. 타깃 데이터와 중앙값이 같다면 탐색에 성공했으므로 탐색을 종료한다.
                } else {
                    find = true;
                    break;
                }
            }

            if(find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
