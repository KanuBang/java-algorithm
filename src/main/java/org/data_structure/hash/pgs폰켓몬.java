package org.data_structure.hash;
import java.util.*;
public class pgs폰켓몬 {
    public static void main(String[] args) {
        int[] nums = {1};

        int len = nums.length;
        int n = len / 2;


        //1. HashMap 쌍을 구한다.
        HashMap<Integer,Integer> pairs = new HashMap<>();
        for(int num:nums){
            pairs.put(num, pairs.getOrDefault(nums,0)+1);
        }

        //2. keySet의 크기가 n보다 크거나 같다면 정답은 n의 크기이다.
        Set<Integer> keySet = pairs.keySet();
        Integer size = keySet.size();


        int answer = size >= n ? n : size;
        System.out.println(answer);


        //3. keySet의 크기가 n보다 작다면 정답은 keySey의 크기이다.

    }
}
