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
    private static boolean[][] visited;
    private static int max = Integer.MIN_VALUE;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    static int n = 2;
    static int m = 2;
    static int k = 2;
    static int[][] arr = new int[n][m];
    @Test
    void solution() {
        int[] numbers = {1,2,3,4};
        int l = 0;
        for(int i = 0; i< n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = numbers[l];
                l++;
            }
        }
        visited = new boolean[n][m];
        recursive(0,0, k);
        System.out.println(max);
    }

    private void recursive(int count, int sum, int k) {
        if(count == k) {
            if(max < sum) {
                max = sum;
            }
            return;
        }

        for(int x = 0; x < n; x++) {
            for(int y = 0; y < m; y++) {
                if(visited[x][y]) {
                    continue;
                }
                boolean ok = true;
                //인접한 위치에 있는 숫자를 골랐는지 확인, 골랐다면 false 처리
                for(int i = 0; i < 4; i++) {
                    int nx = x + dy[i];
                    int ny = y + dx[i];

                    if(nx >= 0 && nx <n && ny >=0 && ny < m) {
                        if(visited[nx][ny]) {
                            ok = false;
                        }
                    }
                }
                //기존  n과m 에서 하던 방식
                if(ok) {
                    visited[x][y] = true;
                    recursive(count+1, sum+arr[x][y], k);
                    visited[x][y] = false;
                }
            }
        }
    }

}
