package org.implementation.boj;

import java.io.*;
import java.util.*;

public class Boj2578 {
    static boolean[][] visited;
    static int bingo = 0;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[5][5];
        visited = new boolean[5][5];
        int cnt = 0;
        int[][] way = new int[][]{{1,-1}, {0,0}, {0,0}, {1,-1}, {1,-1}, {1,-1}, {1,-1}, {-1,1}};

        for(int i =0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j < 5; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i =0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j < 5; j++){
                int num = Integer.parseInt(st.nextToken());

                for(int q =0; q < 5; q++){
                    for(int w=0; w < 5; w++){
                        if(board[q][w] == num){
                            visited[q][w] = true;
                            check(q,w,0, way[0], way[1]); // vertical
                            check(q,w,0, way[2], way[3]); // horizontal
                            check(q,w,0, way[4], way[5]); // left diagonal
                            check(q,w,0, way[6], way[7]); // right diagonal
                            break;
                        }
                    }

                    if(bingo >= 3){
                        System.out.println(cnt+1);
                        return;
                    }

                }

                cnt ++;
            }
        }

    }

    static void check(int q, int w, int continuous, int[] way_x, int[] way_y){
        int x = q;
        int y = w;
        for(int k=0; k < 2; k++){
            x += way_x[k];
            y += way_y[k];

            while(x >= 0 && y >= 0 && x < 5 && y < 5){
                if(visited[x][y]){
                    continuous++;
                }

                x += way_x[k];
                y += way_y[k];

            }
            x = q;
            y= w;
        }

        if(continuous == 4){
            bingo++;
        }

    }

}
