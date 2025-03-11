package org.graph_traversal.bfs;
import java.util.*;
import java.io.*;
public class Boj2178 {
    // 오른쪽, 아래, 왼쪽, 위
    static int[] dx = {0,1,0,-1}; // 행
    static int[] dy = {1,0,-1,0}; // 열

    static boolean[][] visited;
    static int[][] a;
    static int n,m;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j < m; j++) {
                a[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }
        bfs(0,0);
        System.out.println(a[n-1][m-1]);
    }

    public static void bfs(int i, int j) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {i,j}); // 1 2
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int now[] = queue.poll();
            for(int k=0; k<4; k++){
                int x = now[0] + dx[k]; // 0
                int y = now[1] + dy[k]; // 1

                if(x >= 0 && y >=0 && x < n && y <m) {
                    if(a[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        a[x][y] = a[now[0]][now[1]]+1;
                        queue.add(new int[]{x,y});
                    }
                }
            }
        }
    }
}
