package chap04._16194;

import org.junit.jupiter.api.Test;
/**
 *
 * 카드 구매하기
 *
 * 카드 N개를 P[N]에 구매 -> 남은 카드의 수 i-N -> P[N] + D[i-N]
 *
 * 카드를 살 수 있는 최소값을 구하기
 */
public class Solution {
    @Test
    void solution() {
        int n = 4;
        int[] p = {0,1,5,6,7};
        int[] dp = new int[1001];

        for(int i = 1; i <= n; i++) {
            dp[i] = p[i]; //안해주면 무조건 0임
            for(int j = 1; j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j] + p[j]);
            }
        }
        System.out.println(dp[n]);
    }
}
