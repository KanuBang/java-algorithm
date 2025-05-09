package org.graph_traversal.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj21736 {

    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};
    private static char[][] graph;

    static int n;
    static int m;
    static int cnt =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new char[n][m];

        int[] doyeon = new int[2];

        for(int i=0; i < n; i++){
            String line = br.readLine();
            graph[i] = line.toCharArray();

            for(int j=0; j < m; j++){
                if(graph[i][j] == 'I'){
                    doyeon[0] = i;
                    doyeon[1] = j;
                }
            }
        }

        bfs(doyeon[0], doyeon[1]);
        System.out.println(cnt != 0 ? String.valueOf(cnt) : "TT");
    }

    public static void bfs(int x, int y){
        Deque<int[]> queue = new ArrayDeque<>();
        graph[x][y] = 'X';
        queue.offer(new int[]{x,y});

        while (!queue.isEmpty()){
            int[] front = queue.poll();

            for(int k=0; k<4; k++){
                int now_x = front[0] + dx[k]; // x 이동
                int now_y = front[1] + dy[k]; // y 이동

                if(now_x >= 0 && now_y >= 0 && now_x < n && now_y < m){

                    if(graph[now_x][now_y] == 'O'){
                        graph[now_x][now_y] = 'X';
                        queue.offer(new int[]{now_x,now_y});
                    }

                    else if(graph[now_x][now_y] == 'P'){
                        graph[now_x][now_y] = 'X';
                        queue.offer(new int[]{now_x,now_y});
                        cnt++;
                    }

                }
            }
        }
    }
}
