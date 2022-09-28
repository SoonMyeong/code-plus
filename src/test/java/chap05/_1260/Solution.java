package chap05._1260;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;

/**
 *그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
 * 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 *
 *
 * 인접 리스트로 구현
 * 인접 행렬로 구현 시 O(V^2)
 * 인접 리스트로 구현 시 (V + E ) -> O(E)
 */
public class Solution {

    /**
     * 아래 쌤플의 경우 n = 4, m = 5
     * 1 2
     * 1 3
     * 1 4
     * 2 4
     * 3 4
     */
    ArrayList<Integer>[] arr =  new ArrayList[5];
    boolean[] visited = new boolean[5];

    void dfs(int x) {
        if(visited[x]) {
            return; //재귀로 구현한 거라서 탈출 조건 넣어줌
        }

        visited[x] = true;
        System.out.print(x + " ");
        for(int y : arr[x]) {
            if(!visited[y]) {
                dfs(y);
            }
        }
    }

    void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int x = queue.remove();
            System.out.print(x + " ");
            for(int y : arr[x]) {
                if(!visited[y]) {
                    visited[y] = true;
                    queue.add(y);
                }
            }
        }
    }

    @Test
    void solution() {
        for(int i =0; i<5; i++) {
            arr[i] = new ArrayList<>();
        }

        arr[1].add(2);
        arr[2].add(1);
        arr[1].add(3);
        arr[3].add(1);
        arr[1].add(4);
        arr[4].add(1);
        arr[2].add(4);
        arr[4].add(2);
        arr[3].add(4);
        arr[4].add(3);

        dfs(1);
        System.out.println();
        visited = new boolean[5];
        bfs(1);
        System.out.println();
    }
}
