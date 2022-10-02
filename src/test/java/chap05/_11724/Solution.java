package chap05._11724;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다.
 * (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다.
 * (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
 *
 */
public class Solution {
    /**
     * 1 2
     * 2 5
     * 5 1
     * 3 4
     * 4 6
     * -> 섬이 2개이므로 2
     * 결국 모든 정점에 대해 탐색하게 될 경우
     * 섬 하나가 끝날때마다 최종 리턴되므로 그때마다 값을 1씩 증가해 주면 된다.
     */

    List<Integer>[] arr = new ArrayList[7];
    boolean[] visited = new boolean[7];

    void dfs(int x) {
        if(visited[x]) {
            return ;
        }
        visited[x] = true;
        for(int y : arr[x]) {
            if(!visited[y]) {
                dfs(y);
            }
        }
    }

    @Test
    void solution() {
        int result = 0;
        for(int i = 1; i<=6; i++) {
            arr[i] = new ArrayList<>();
        }
        //init 그래프 간선 작업 (방향없으면 양방향임)
        arr[1].add(2);
        arr[2].add(1);
        arr[2].add(5);
        arr[5].add(2);
        arr[5].add(1);
        arr[1].add(5);
        arr[3].add(4);
        arr[4].add(3);
        arr[4].add(6);
        arr[6].add(4);

        for(int i = 1; i<=6; i++) {
            if(!visited[i]) {
                dfs(i);
                result++;
            }
        }
        System.out.println(result);
    }
}
