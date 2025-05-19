package org.graph_traversal.dfs.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj1926 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] graph;

    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for(int i=0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int paint = 0;
        int max_size = 0;


        for(int i=0; i < n; i++){
            for(int j=0; j < m; j++){
                if(graph[i][j] == 1){
                    paint++;
                    graph[i][j] = 0;
                    int result = dfs(i, j, 1);
                    if(result > max_size){
                        max_size = result;
                    }
                }
            }
        }

        System.out.println(paint);
        System.out.println(max_size);

    }


    private static int dfs(int x, int y, int depth){

        for(int k=0; k < 4; k++){
            int new_x = x + dx[k];
            int new_y = y + dy[k];

            if(new_x >=0 && new_y >=0 && new_x < n && new_y < m){
                if(graph[new_x][new_y] == 1){
                    graph[new_x][new_y] = 0; // 방문처리
                    depth = dfs(new_x,new_y,depth+1);
                }
            }
        }

        return depth;
    }
}
