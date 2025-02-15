package org.data_structure.array.슬라이딩윈도우;
import java.util.*;
import java.io.*;
public class Boj12891 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String dna = br.readLine();
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(s + p + dna);

        for(int i=0; i+p <= s; i++) {
            String sub = dna.substring(i, i + p);
            char[] charArray = sub.toCharArray();

            

        }

    }
}
