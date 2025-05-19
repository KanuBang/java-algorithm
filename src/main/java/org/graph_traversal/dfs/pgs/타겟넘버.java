package org.graph_traversal.dfs.pgs;

public class 타겟넘버 {
    private static int answer = 0;
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        dfs(0,numbers,0,target);

    }
    private static void dfs(int depth, int[] numbers, int sum, int target)
    {
        if(depth == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }

        dfs(depth+1, numbers, sum+numbers[depth], target);
        dfs(depth+1, numbers, sum-numbers[depth], target);
    }
}
