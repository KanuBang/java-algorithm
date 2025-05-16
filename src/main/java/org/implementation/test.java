package org.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) throws Exception {
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

//                for(int x=1; x <= total; x++){
//                    if(x % 20 == 0){
//                        System.out.printf("%d\n", arr[x]);
//                    } else {
//                        System.out.printf("%d ", arr[x]);
//                    }
//                }
            }


            else {
                if(num == 1 || num == total){
                    System.out.println("here?");
                    if(arr[num] == 1){
                        arr[num] = 0;
                    } else {
                        arr[num] = 1;
                    }
                    continue;
                }

                int left = num-1;
                int right = num+1;
                boolean sign = true;

                // num 1 total 1

                while(left >= 1 && right <= total){
                    if (arr[left] != arr[right]){
                        sign = false;
                        break;
                    }
                    left--;
                    right++;
                }

                for(int x=1; x <= total; x++){
                    if(x % 20 == 0){
                        System.out.printf("%d\n", arr[x]);
                    } else {
                        System.out.printf("%d ", arr[x]);
                    }
                }

                if(sign){
                    for(int k=left+1; k < right; k++){
                        System.out.printf("k : %d, arr[k]: %d\n", k, arr[k]);
                        if(arr[k] == 1){
                            arr[k] = 0;
                        } else {
                            arr[k] = 1;
                        }
                    }
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
