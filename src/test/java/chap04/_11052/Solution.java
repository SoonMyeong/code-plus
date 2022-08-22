package chap04._11052;

import org.junit.jupiter.api.Test;

/**
 *
 * 카드 구매하기
 *
 * 카드 N개를 P[N]에 구매 -> 남은 카드의 수 i-N -> P[N] + D[i-N]
 */
public class Solution {

    @Test
    void solution() {
        int n = 4;
        int[] p = {0,1,5,6,7};
        int[] dp = new int[1001];

        for(int i = 1; i<= n; i++) {
            for(int j = 1; j<=i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + p[j]);
            }
        }
        System.out.println(dp[n]);
    }
}
