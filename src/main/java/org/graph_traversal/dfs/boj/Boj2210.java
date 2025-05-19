package org.graph_traversal.dfs.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj2210 {

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] graph = new int[5][5];
    static List<String> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j < 5; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /*
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                dfs(i, j, String.valueOf(graph[i][j]), 0);
            }
        }
        */
        int i = 3;
        int j = 3;
        dfs(i, j, String.valueOf(graph[i][j]), 0);
        System.out.println(result.size());
    }

    private static void dfs(int x, int y, String route, int depth){
        if(depth == 5){
            if(!result.contains(route)){
                result.add(route);
            }
            return;
        }

        for(int k=0; k < 4; k++){
            int new_x = x + dx[k];
            int new_y = y + dy[k];
            if(new_x >=0 && new_y >= 0 && new_x < 5 && new_y < 5) {
                System.out.printf("new_x:%d, new_y:%d, route:%s, depth:%d\n", new_x,new_y, route + graph[new_x][new_y], depth+1);
                dfs(new_x,new_y, route + graph[new_x][new_y], depth+1);
            }
        }
    }
}
