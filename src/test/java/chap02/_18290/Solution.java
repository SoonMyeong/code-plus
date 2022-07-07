package chap02._18290;

import org.junit.jupiter.api.Test;

/**
 *
 * 문제
 * 크기가 N×M인 격자판의 각 칸에 정수가 하나씩 들어있다. 이 격자판에서 칸 K개를 선택할 것이고,
 * 선택한 칸에 들어있는 수를 모두 더한 값의 최댓값을 구하려고 한다. 단, 선택한 두 칸이 인접하면 안된다.
 * r행 c열에 있는 칸을 (r, c)라고 했을 때, (r-1, c), (r+1, c), (r, c-1), (r, c+1)에 있는 칸이 인접한 칸이다.
 *
 * 입력
 * 첫째 줄에 N, M, K가 주어진다. 둘째 줄부터 N개의 줄에 격자판에 들어있는 수가 주어진다.
 *
 * 출력
 * 선택한 칸에 들어있는 수를 모두 더한 값의 최댓값을 출력한다.
 *
 * 제한
 * 1 ≤ N, M ≤ 10
 * 1 ≤ K ≤ min(4, N×M)
 * 격자판에 들어있는 수는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이다.
 * 항상 K개의 칸을 선택할 수 있는 경우만 입력으로 주어진다.
 *
 */
public class Solution {
    public static int[][] arr;
    public static int[][] visited;
    @Test
    void solution() {
        int n = 2;
        int m = 2;
        int k = 2;
        arr = new int[n+1][m+1];

        recursive(n,m,k);
    }

    private void recursive(int n, int m, int k) {

    }
}
