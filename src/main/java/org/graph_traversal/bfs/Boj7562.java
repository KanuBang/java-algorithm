package org.graph_traversal.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj7562 {
    private static int[] dx = {-2,-2,-1,-1,2,2,1,1};
    private static int[] dy = {-1,1,-2,2,1,-1,2,-2};
    private static boolean[][] visited;
    private static int[][] graph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i < t; i++) {
            int l = Integer.parseInt(br.readLine());
            int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] end = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            visited = new boolean[l][l];
            graph = new int[l][l];
            System.out.println(bfs(start[0],start[1],end[0],end[1],l));
        }

    }

    static int bfs(int start_x, int start_y, int end_x, int end_y, int size) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start_x, start_y});
        visited[start_x][start_y] = true;
        int answer = 0;
        while(!queue.isEmpty() || !visited[end_x][end_y]){
            int[] point = queue.poll();

            for(int k=0; k < 8; k++) {
                int now_x = point[0] + dx[k];
                int now_y = point[1] + dy[k];
                if (now_x >= 0 && now_y >= 0 && now_x < size && now_y < size) {
                    if (!visited[now_x][now_y]) {
                        queue.offer(new int[]{now_x, now_y});
                        graph[now_x][now_y] = graph[point[0]][point[1]] + 1;
                        visited[now_x][now_y] = true;
                    }
                }

                if (now_x == end_x && now_y == end_y) {
                    answer = graph[now_x][now_y];
                    break;
                }
            }
        }
        return answer;
    }
}
