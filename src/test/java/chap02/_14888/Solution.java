package chap02._14888;

import org.junit.jupiter.api.Test;

public class Solution
{
    boolean[] visited;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    @Test
    void solution() {
        int[] arr = {3,4,5};
        int[] operators = {1,0,1,0};
        visited = new boolean[2];
        dfs(arr,operators,1, arr[0]);
        System.out.println("max :" + max);
        System.out.println("min : " + min);
    }

    private void dfs(int[] arr, int[] operators, int depth, int total)
    {
        if(depth == arr.length) {
            if(total > max) {
                max = total;
            }
            if(total < min) {
                min = total;
            }

            return;
        }



        for(int i = 0; i<arr.length -1; i++) {
            for(int j = 0; j< 4; j++)
            {
                if (operators[j] > 0 && !visited[i])
                {
                    visited[i] = true;
                    total = calcuate(arr, j, depth, total);
                    operators[j] -= 1;
                    dfs(arr, operators, depth + 1, total);
                    operators[j] += 1;
                    total = arr[0];
                    visited[i] = false;
                }
            }
        }

    }

    private int calcuate(int[] arr, int operator,int depth, int total)
    {
        if(operator == 0) {
            return total+arr[depth];
        }
        if(operator == 1) {
            return total-arr[depth];
        }
        if(operator == 2) {
            return total*arr[depth];
        }
        if(operator == 3) {
            return Math.abs(total) / arr[depth];
        }
        return 0;
    }
}
