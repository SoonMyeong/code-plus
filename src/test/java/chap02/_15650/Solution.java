package chap02._15650;

import org.junit.jupiter.api.Test;

/**
 *
 * 문제
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 *
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 고른 수열은 오름차순이어야 한다.
 * 입력
 * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
 *
 * 출력
 * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며,
 * 각 수열은 공백으로 구분해서 출력해야 한다.
 *
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 *
 *
 */
public class Solution {
    static boolean[] visited;
    static int[] arr;
    @Test
    void solution() {
        int n = 4;
        int m = 2;
        visited = new boolean[n+1];
        arr = new int[m];
        recursive(0,1,n,m);
    }

    /**
     * 오름차순을 위해 첫번째 뽑은 숫자가 4를 뽑았다면 두번째 숫자는 5~N 중에 하나를 뽑아야 하므로
     * 5에 해당하는 start 값을 인자에 포함시켜 준다.
     */
    private void recursive(int index, int start, int n, int m) {
        if(index == m) {
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for(int i = start; i<=n; i++) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            arr[index] = i;
            recursive(index+1, i+1,n,m);
            visited[i] = false;
        }
    }
}
