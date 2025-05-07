package org.binary_search.sampleCodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i < n; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] find = new int[m];
        for(int i=0; i < m; i++){
            find[i] = Integer.parseInt(st.nextToken());
        }

        //1 대상 데이터 오름차순 정렬
        Arrays.sort(data);

        for(int i=0; i < m; i++) {
            boolean success = false;
            int target = find[i];
            int start = 0;
            int end = data.length - 1;
            while (start <= end) {
                //2 중앙값을 선택한다.
                int midIdx = (start + end) / 2;
                int midValue = data[midIdx];

                //3 대상 데이터가 중앙값보다 작다면 왼쪽 데이터 셋을 선택한다
                if (midValue > target){
                    end = midIdx-1;
                }
                //4 대상 데이터가 중앙값보다 크다면 오른쪽 데이터 셋을 선택한다
                else if(midValue < target){
                    start = midIdx+1;
                }
                //5 대상 데이터와 중앙값이 같다면 탐색에 성공했다.
                else {
                    success = true;
                    break;
                }
            }

            if(success){
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
