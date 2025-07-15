package org.sort.quick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Boj11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }


        quickSort(a, 0, n-1, k-1);
        System.out.print(a[k-1]);
    }

    static void quickSort(int[] a, int s, int e, int k){

        if(s < e) {
            int pivot_idx = partition(a, s, e);

            if(pivot_idx == k) return;

            else if (k < pivot_idx) {
                quickSort(a,s,pivot_idx-1,k);
            }

            else {
                quickSort(a,pivot_idx+1,e,k);
            }
        }
    }

    static int partition(int[] a, int s, int e){
        if(s+1 == e){
            if(a[s] > a[e]) swap(a, s, e);
            return e;
        }


        int m = (s+e) / 2;
        swap(a,s,m);
        int pivot = a[s];
        int l = s+1;
        int h = e;

        while(l <= h){
            while(a[h] > pivot && h >= s + 1) {
                h--;
            }

            while (a[l] < pivot && l <= e){
                l++;
            }


            if (l <= h) {
                swap(a,l++,h--);
            }
        }

        a[s] = a[h];
        a[h] = pivot;
        return h;
    }


    static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
