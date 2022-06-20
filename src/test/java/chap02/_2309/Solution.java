package chap02._2309;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 *  아홉 명의 난쟁이 중 일곱 명의 난쟁이를 찾는 문제
 *  일곱 난쟁이의 키의 합은 100 이다.
 *
 */
public class Solution {
    @Test
    void solution() {
        int [] heights = {20,7,23,19,10,15,25,8,13};
        findSevenBoys(heights);
    }

    private void findSevenBoys(int[] heights) {
        int sum = makeSum(heights);
        for(int i = 0; i < heights.length; i++) {
            for(int j = i + 1; j<heights.length; j++) {
                if(sum - (heights[i] + heights[j]) == 100) {
                    print(heights, i, j);
                    return;
                }
            }
        }
    }

    private void print(int[] heights, int i, int j) {
        int[] result = new int[7];
        int n  =0;
        for(int k = 0; k < heights.length; k++) {
            if(k != i && k != j) {
                result[n++] = heights[k];
            }
        }
        Arrays.stream(result).sorted().forEach(System.out::println);
    }

    private int makeSum(int[] heights) {
        return Arrays.stream(heights).sum();
    }
}
