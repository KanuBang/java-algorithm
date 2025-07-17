package org.sort.quick;

import java.io.*;
import java.util.*;

public class Boj25305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] score = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i < n; i++){
            score[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 퀵 소트 시작
        quickSort(score, 0, n-1);
        System.out.println(score[n-k]);
    }


    public static void quickSort(int[] a , int s, int e){
        // N=1일 경우는 정렬할 필요 없음
        if(s < e){
            int pivot_idx = partition(a,s,e);
            quickSort(a, s, pivot_idx-1); // 왼쪽
            quickSort(a,pivot_idx+1, e);
        }
    }

    public static int partition(int[] a, int s, int e){
        // N=2인 경우
        if(e == s+1){
            if(a[s] > a[e]){
                swap(a,s,e);
            }
            return e;
        }

        int m = (s+e) / 2;
        swap(a,s,m);
        int pivot_val = a[s];
        int l = s+1;
        int h = e;

        // 2. l <= h 일때 l과 h를 움직인다.
        while(l <= h){

            while(h >= s+1 && a[h] > pivot_val){
                h--;
            }

            while(l <= e && a[l] < pivot_val){
                l++;
            }

            if( h >= l ){
                swap(a,l++,h--);
            }
        }

        // 3. l > h 일때 h와 pivot을 바꾼다.
        a[s] = a[h];
        a[h] = pivot_val;
        return h;
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
