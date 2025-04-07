package org.graph_traversal.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj24479 {
    static boolean[] visited;
    static ArrayList<Integer>[] a;
    static int[] order;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        a = new ArrayList[n+1];
        order = new int[n+1];

        for(int i=1; i < n+1; i++){
            a[i] = new ArrayList<>();
        }

        for(int i=1 ; i < m+1; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            a[s].add(e);
            a[e].add(s);
        }

        for(int i=1; i < n+1; i++){
            Collections.sort(a[i]);
        }

        dfs(k);
        for(int i=1; i < n+1; i++){
            System.out.println(order[i]);
        }
    }

    static void dfs(int v) {
        if(visited[v]){
            return;
        }
        visited[v] = true;
        cnt++;
        order[v] = cnt;
        for(int k : a[v]){
            if(!visited[k]){
                dfs(k);
            }
        }
    }
}
