package org.data_structure.stackQueue;
import java.util.*;
import java.io.*;
public class Boj1874 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] seq = new int[n+1];
        List<String> chars = new ArrayList<String>();
        int seq_idx = 0;

        for(int i=0; i < n; i++){
            seq[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i <=n; i++){
            stack.push(i);
            chars.add("+");
            while(!stack.isEmpty() && stack.peek() == seq[seq_idx]){
                stack.pop();
                seq_idx++;
                chars.add("-");
            }
        }

        if(!stack.isEmpty()){
            System.out.println("NO");
        } else {
            chars.stream().forEach(System.out::println);
        }

        // 1. 숫자를 넣는다
        // 2. stack의 peek과 배열의 인덱스를 비교한다
        // 3. 같지않다면 Push, 같다면 Pop
        // 4. 배열의 끝에 도달했고 배열의 마지막 값과 현재 peek이 같지 않다면 no
    }
}
