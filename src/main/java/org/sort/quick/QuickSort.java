package org.sort.quick;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSort {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());

        int[] a = new int[n];


        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(a, 0, n - 1, k - 1);
        System.out.println(a[k - 1]);
    }


    public static void quickSort(int[] a, int s, int e, int k) {
        if (s < e) {
            int pivot = partition(a, s, e);

            if (pivot == k) return; // 피봇은 정렬 결과 상에서 k번째 수를 의미함. -> 탐색 완료

            else if (k < pivot) quickSort(a, s, pivot - 1, k); // 왼쪽
            else quickSort(a, pivot + 1, e, k); // 오른쪽
        }
    }

    public static int partition(int[] a, int s, int e) {
        // 데이터가 2개인 경우는 바로 정렬
        if (s + 1 == e) {
            if (a[s] > a[e]) swap(a, s, e);
            return e;
        }


        // 피봇 설정
        int m = (s + e) / 2;
        swap(a, s, m); // 중앙값을 1번째 요소로 이동 -> 꼭 필요한 건 아니지만 좋은 피봇 선정을 위한 최적화 기법
        // 굳이 필요한가?

        int pivot = a[s]; // 피봇이 가르키는 값
        int l = s + 1;
        int h = e;


        // l과 h 이동
        while (l <= h) {

            // a[h] -> 피봇보다 값이 작아야
            while (h >= s + 1 && pivot < a[h]) {
                h--;
            }

            // a[l] -> 피봇보다 값이 커야
            while (l <= e && pivot > a[l]) {
                l++;
            }

            // l과 h 스왑 -> 반복문에서 탈출 했을 때까지 값이 update 되지 않아 추가로 update 해서 swap 함수에 전달
            if (l <= h) {
                swap(a, l++, h--);
            }

        }

        // h < l 일때 pivot, h 스왑
        a[s] = a[h];
        a[h] = pivot;
        return h; // 새로운 피봇 인덱스 전달

    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
