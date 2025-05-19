package org.graph_traversal.dfs.boj;

import java.util.*;
import java.io.*;

public class Boj11724DFS {
    static boolean[] visited;
    static ArrayList<Integer>[] a;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        a = new ArrayList[n+1]; // ArrayList를 요소로 하는 배열[]
        visited = new boolean[n+1];

        for(int i=1; i < n+1; i++) {
            a[i] = new ArrayList<Integer>();
        }

        for(int i=1; i < m+1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            a[s].add(e);
            a[e].add(s);
        }

        int count = 0;
        for(int i=1; i < n+1; i++){
            if(!visited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    static void dfs(int v) {
        if(visited[v]){
            return;
        }
        visited[v] = true;
        for(int i : a[v]) {
            if(visited[i] == false) {
                dfs(i);
            }
        }
    }
}
