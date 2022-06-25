package chap02._14500;

import org.junit.jupiter.api.Test;

/**
 *
 * 브루트포스 완전 탐색
 * 그냥 경우의 수 다 구해서 계산
 * 폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.
 *
 * 정사각형은 서로 겹치면 안 된다.
 * 도형은 모두 연결되어 있어야 한다.
 * 정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
 * 정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.
 *
 * 아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.
 *
 * 테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.
 *
 * 테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.
 * -----------------------------------------------------
 * 입력
 * 첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)
 *
 * 둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다. i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다.
 * 입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.
 *
 * 출력
 * 첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.
 *
 *
 *
 */
public class Solution {
    @Test
    void solution() {
        int[][] arr = {
                {1,2,3,4,5}
                , {5,4,3,2,1}
                , {2,3,4,5,6}
                , {6,5,4,3,2}
                , {1,2,1,2,1}
        };
        tetromino(arr);
    }

    private void tetromino(int[][] arr) {
        int result = 0;
        int n = arr.length;
        int m = arr[0].length;

        for(int i = 0; i< n; i++) {
            for(int j = 0; j < m; j++) {
                if(j + 3 < m) { //긴 작대기
                    int temp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i][j+3];
                    result = Math.max(result, temp);
                }
                if(i + 3 < n) { //누운 짝대기
                    int temp = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+3][j];
                    result = Math.max(result, temp);
                }

                if(i + 1 < n && j + 1 < m) { // 네모
                    int temp = arr[i][j] + arr[i+1][j] + arr[i][j+1] + arr[i+1][j+1];
                    result = Math.max(result,temp);
                }

                if(i + 2 < n && j + 1 < m) { // 왼쪽꺽쇄
                    int temp = arr[i][j] + arr[i + 1][j] + arr[i+1][j+1] + arr[i+2][j+1];
                    result = Math.max(result,temp);
                }
                if(i - 1 >=0 && i - 1 <n && j + 2 <m) { //회전한 왼쪽꺽쇄
                    int temp = arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i-1][j+2];
                    result = Math.max(result,temp);
                }

                if(i -2 >=0 && i -2 <n && j + 1 <m) { //오른쪽꺽쇄
                     int temp = arr[i][j] + arr[i-1][j] + arr[i-1][j+1] + arr[i-2][j+1];
                     result = Math.max(result, temp);
                }
                if(i + 1 <n && j + 2 < m) { //회전한 오른쪽꺽쇄
                    int temp = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j+2];
                    result = Math.max(result, temp);
                }

                if(i + 2 <n && j + 1 < m) { //ㅏ
                    int temp = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j];
                    result = Math.max(result, temp);
                }
                if(i - 1  >=0 && j + 2 <m) { // ㅗ
                    int temp = arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i][j+2];
                    result = Math.max(result, temp);
                }
                if(i - 1 >=0 && i + 1 < n && j +1 < m) { // ㅓ
                    int temp = arr[i][j] + arr[i-1][j+1] + arr[i][j+1] + arr[i+1][j+1];
                    result = Math.max(result, temp);
                }
                if(i + 1 < n && j + 2 < m) { // ㅜ
                    int temp = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i][j+2];
                    result = Math.max(result, temp);
                }

                if(i + 1 < n && j + 2 < m) { //ㄴ
                    int temp = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2];
                    result = Math.max(result, temp);
                }
                if(i -2 >= 0 && j + 1 < m) { // _|
                    int temp = arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i-2][j+1];
                    result = Math.max(result, temp);
                }
                if(i + 1 < n && j + 2 < m) { // |--
                    int temp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j];
                    result = Math.max(result, temp);
                }
                if(i + 2 <n && j + 1 < m) { // |-
                    int temp = arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+2][j];
                    result = Math.max(result, temp);
                }

                if(i -1 >= 0 && j + 2 < m) { // ---|
                    int temp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i-1][j+2];
                    result = Math.max(result, temp);
                }
                if(i -2 >= 0 && j + 1 < m) { // |_
                    int temp = arr[i][j] + arr[i][j+1] + arr[i-1][j] + arr[i-2][j];
                    result = Math.max(result, temp);
                }
                if(i + 1 < n && j + 2 < m) { //---|
                    int temp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+2];
                    result = Math.max(result, temp);
                }
                if(i + 2 < n && j + 1 <m) { // -|
                    int temp = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1];
                    result = Math.max(result, temp);
                }
            }
        }
        System.out.println(result);
    }
}
