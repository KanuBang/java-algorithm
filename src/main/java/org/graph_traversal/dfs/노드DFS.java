package org.graph_traversal.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 노드DFS {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
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

        for(int i=1; i < n+1; i++){
            Collections.sort(graph[i]);
        }

        dfs(v);


    }

    static void dfs(int v){
        if(visited[v]){
            return;
        }

        visited[v] = true;

        for(int a: graph[v]){
            if(!visited[a]){
                dfs(a);
            }
        }
    }
}
