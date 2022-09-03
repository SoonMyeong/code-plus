package chap04._2193;

import org.junit.jupiter.api.Test;

/**
 * 이친수
 *
 * 1, -> 1
 * 10 -> 1
 * 100,101, -> 2
 * 1000, 1001, 1010 -> 3
 * 10000, 10001, 10010, 10100, 10101 -> 5
 * 100000, 100001, 100010, 100101, 100100, 101000, 101001 101010 -> 8
 * 1000000, 1000001, 1000010 , 1000100, 1000101, 1001000, 1001010, 1001001, 1010000
 *
 * dp[n] = dp[n-1]+dp[n-2]
 * 왜냐? dp[3]의 경우 n-1번째 합과 n-2번째합의 합으로 구할 수 있음.
 *
 */
public class Solution {
    static int[] dp;
    @Test
    void sol() {
        int n = 3;
        dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        System.out.println(solution(n));
    }

    private int solution(int n) {
        for(int i =3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

}
