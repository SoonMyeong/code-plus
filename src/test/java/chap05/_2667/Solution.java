package chap05._2667;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
 * 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
 * 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다.
 * 그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
 * 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 *
 *
 */
public class Solution {
    /**
     * 0110100
     * 0110101
     * 1110101
     * 0000111
     * 0100000
     * 0111110
     * 0111000
     */
    int []dx = {-1,0,1,0};
    int []dy = {0,1,0,-1};
    int [][]visited = new int[7][7];
    List<Integer> arrCount = new ArrayList<>();
    int [][]arr = {
            {0,1,1,0,1,0,0}
            ,{0,1,1,0,1,0,1}
            ,{1,1,1,0,1,0,1}
            ,{0,0,0,0,1,1,1}
            ,{0,1,0,0,0,0,0}
            ,{0,1,1,1,1,1,0}
            ,{0,1,1,1,0,0,0}
    };

    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    void bfs(int x, int y, int count) {
        int result = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        visited[x][y] = count;

        while(!queue.isEmpty()) {
            Point p = queue.poll();

            for(int i = 0; i <4; i++) { //움직일 수 있는 범위 상하좌우
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >=0 && nx <7 && ny>=0 && ny<7) {
                    if(arr[nx][ny] ==1 && visited[nx][ny] == 0) {
                        queue.add(new Point(nx,ny));
                        visited[nx][ny] = count;
                        result++;
                    }
                }
            }
        }
        arrCount.add(result);
    }

    @Test
    void solution() {
        int count = 0;
        for(int i = 0; i<arr.length; i++) {
            for(int j = 0; j<arr.length; j++) {
                if(arr[i][j] == 1 && visited[i][j] == 0) {
                    bfs(i,j,++count);
                }
            }
        }
        System.out.println(count);
        arrCount.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
