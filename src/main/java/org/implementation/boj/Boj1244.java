package org.implementation.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1244 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int[] arr = new int[total+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i <= total; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int student = Integer.parseInt(br.readLine());

        for(int i=0; i < student; i++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(sex == 1){

                for(int j=1; num*j<= total; j++){
                    int idx = num * j;
                    if(arr[idx] == 1){
                        arr[idx] = 0;
                    } else {
                        arr[idx] = 1;
                    }
                }

            }


            else {
                arr[num] = arr[num] == 1 ? 0 : 1;

                int left = num-1;
                int right = num+1;

                while(left >= 1 && right <= total){
                    if (arr[left] != arr[right]){
                        break;
                    }
                    arr[left] = arr[left] == 1 ? 0 : 1;
                    arr[right] = arr[right] == 1 ? 0 : 1;
                    left--;
                    right++;
                }
            }
        }

        for(int i=1; i <= total; i++){
            if(i % 20 == 0){
                System.out.printf("%d\n", arr[i]);
            } else {
                System.out.printf("%d ", arr[i]);
            }
        }
    }
}
