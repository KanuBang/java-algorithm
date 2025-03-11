package org.graph_traversal;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Boj1260DFSBFS {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i < n+1; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        // 2. 정렬 (작은 것을 우선 방문)
        for(int i=1; i < n+1; i++){
            Collections.sort(graph[i]);
        }
        // 3. dfs 탐색
        dfs(v);

        // 4. 방문 배열 재사용
        visited = new boolean[n+1];
        System.out.println();
        bfs(v);
    }

    static void dfs(int v){
        if(visited[v]){
            return;
        }

        visited[v] = true;
        System.out.printf("%d ", v);
        for(int a: graph[v]){
            if(!visited[a]){
                dfs(a);
            }
        }

    }

    static void bfs(int v){
        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            int now_v = queue.poll();
            System.out.printf(now_v + " ");
            for(int i : graph[now_v]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
