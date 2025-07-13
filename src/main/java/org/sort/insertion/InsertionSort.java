package org.sort.insertion;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];

        for(int i=0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        for(int i=1; i < n; i++){
            // 1. 삽입 대상 선택
            int insert_idx = i;
            int insert_val = nums[i];

            // 2. 정렬된 부분에서 삽입될 위치를 결정
            // 내림차순 정렬이므로 삽입 대상보다 크면은 삽입 인덱스 1 감소 시킴.
            for(int j = i-1; j >=0 ; j--){
                if(nums[i] < nums[j]){
                    insert_idx--;
                }
            }

            // 3. 삽입 인덱스부터 삽입 대상이 있는 지점까지 오른쪽으로 shift
            for(int j=i; j > insert_idx; j--){
                nums[j] = nums[j-1];
            }


            // 4. 삽입 인덱스에 삽입 대상 삽입
            nums[insert_idx] = insert_val;

            /* ex

            1 3 8  | 2 5

            - 삽입 대상이 '2'이고, 초기 삽입 인덱스는 3
            - 내림차순 정렬이므로, 정렬된 부분에서 '2'보다 큰 숫자를 만나면 삽입 인덱스 1 감소
            - 최종적으로 삽입 인덱스는 1

            1 3 3 | 8 5

            - 삽입 인덱스 1부터 '2'의 인덱스 3까지 약 2번의 오른쪽 shift 연산

            1 2 3 8 | 5

            - 삽입 인덱스 1에 '2'를 넣으면 1 2 3 8 까지는 정렬이 완선됨.
             */
        }


        int[] sum = new int[n];

        sum[0] = nums[0];

        for(int i=1; i < n; i++){
            sum[i] = sum[i-1] + nums[i];
        }

        int answer = 0;
        for(int i=0; i < n; i++){
            answer += sum[i];
        }
        System.out.println(answer);
    }
}
