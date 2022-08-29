package chap04._15990;

import org.junit.jupiter.api.Test;

/**
 *
 * 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 3가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
 * 단, 같은 수를 두 번 이상 연속해서 사용하면 안 된다.
 * 1+2+1
 * 1+3
 * 3+1
 * 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
 *
 * 숫자가 연속된 숫자가 나오면 안되는 제약조건 때문에 아래처럼 2차원 점화식을 세워야 함.
 * dp[n][1] = dp[n-1][2] + dp[n-1][3]
 * dp[n][2] = dp[n-2][1] + dp[n-2][3]
 * dp[n][3] = dp[n-3][1] + dp[n-3][2]
 *
 */
public class Solution {
    @Test
    void solution() {
        int n = 3;

        solution(n);
    }

    private void solution(int n) {

    }

}
