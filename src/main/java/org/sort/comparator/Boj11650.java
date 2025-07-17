package org.sort.comparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Point[] point = new Point[n];

        for(int i=0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            point[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 1. 퀵 정렬
        Arrays.sort(point);

        // 2. 출력
        for(Point p : point){
            System.out.println(p.x + " " + p.y);
        }
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Point p) {
            // x 좌표로 오름차순 정렬
            if(p.x != this.x) {
                return this.x > p.x ? 1 : -1;
            }

            // x 좌표가 같다면 y 좌표로 오름차순 정렬
            else{
                return this.y > p.y ? 1 : -1;
            }
        }
    }
}
