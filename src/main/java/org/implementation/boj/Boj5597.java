package org.implementation.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Boj5597 {
    public static void main(String[] args) throws IOException {
        HashSet<Integer> set = new HashSet<>();
        for(int i=1; i <= 30; i++){
            set.add(i);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=1; i <= 28; i++){
            set.remove(Integer.parseInt(br.readLine()));
        }

        List<Integer> list = set.stream().sorted().collect(Collectors.toList());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}
