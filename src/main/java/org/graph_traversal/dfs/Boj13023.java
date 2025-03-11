package org.graph_traversal.dfs;
import java.io.*;
import java.util.*;
public class Boj13023 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean answer;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];

        for(int i=0; i < n; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);

        }

        answer = false;
        for(int i=0; i<n; i++){
            visited = new boolean[n]; // 매번 새로운 방문 처리 배열 필요
            dfs(i,0);
            if(answer){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    static void dfs(int v, int depth) {
        //1. 깊이를 확인한다
        if(depth == 4){
            answer = true;
            return;
        }

        //2. 방문 처리를 한다.
        visited[v] = true;

        for(int a: graph[v]){
            if(!visited[a]){
                dfs(a, depth+1);
            }
        }

        //3. 재방문 처리를 한다.
        visited[v] = false;

    }
}
