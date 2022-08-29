package chap04._11726;

import org.junit.jupiter.api.Test;

/**
 *
 * 문제
 * 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
 *
 * 아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.
 *
 *
 * 입력
 * 첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
 *
 * 출력
 * 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
 *
 * 구하는 팁은 가장 끝을 채울 직사각형을 생각해보면 된다.
 * 가장 끝에 1x2 형인 긴 직사각형이 오려면 그 전까지의 크기는 n-1 까지여야 함
 * 가장 끝에 2x1 형인 가로로 넓은 직사각형이 오려면 그 전가지의 크기는 n-2 까지여야함
 *  --> 그래야 두개 합쳐서 n 이 되지
 *
 * dp[n] = dp[n-1] + dp[n-2]
 *
 */
public class Solution {
    @Test
    void solution() {
        int n = 9;
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i<= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] = dp[i] % 10007;
        }
        System.out.println(dp[n]);
    }
}