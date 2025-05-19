package org.implementation;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj4396 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<int[]> bomb = new ArrayList<>();
        char[][] board = new char[n][n];
        char[][] result = new char[n][n];
        // 게임판 입력
        for(int i=0; i < n; i++){
            board[i] = scanner.next().toCharArray();
            for(int j=0; j < n; j++){
                if (board[i][j] == '*'){
                    bomb.add(new int[]{i,j});
                }
            }
        }

        //결과판
        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                result[i][j] = board[i][j];
            }
        }

        // 플레이 기록
        char[][] play = new char[n][n];
        boolean lose = false;
        // 위 아래 오른쪽 왼쪽

        // 주변 8칸 확인
        int[] dx = new int []{1,-1,0,0, 1,1,-1,-1};
        int[] dy = new int []{0,0,1,-1, 1,-1,1,-1};
        for(int i=0; i < n; i++){
            play[i] = scanner.next().toCharArray();
        }

        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                if(play[i][j] == 'x'){
                    // 'x' && '*' -> 폭탄을 밟았을 때
                    if(board[i][j] == '*'){
                        if(lose) continue;
                        else {
                            for (int[] idx : bomb) {
                                result[idx[0]][idx[1]] = '*';
                            }
                            lose = true;
                        }
                    }

                    // 'x' && '.'
                    else {
                        int cnt = 0;

                        // 폭탄 체크
                        for(int k=0; k < 8; k++){
                            int now_x = i+dx[k];
                            int now_y = j+dy[k];

                            if(now_x >= 0 && now_x < n && now_y >= 0 && now_y < n){
                                if(board[now_x][now_y] == '*'){
                                    cnt += 1;
                                }
                            }

                        }
                        result[i][j] = (char)(cnt + '0');

                    }
                }


                else{
                    if(lose && result[i][j] == '*') continue;
                    result[i][j] = '.';
                }
                // '.'
            }
        }


        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                System.out.printf("%c",result[i][j]);
            }
            System.out.println();
        }

    }
}
