package chap06._16926;

/**
 * https://www.acmicpc.net/problem/16926
 *
 * 해당 문제의 경우
 * 4개의 상하좌우 로 각각 그룹핑 한 다음
 * 각각의 회전 규칙에 따라 k번 만큼 옮겨준 후 그 값들을 리턴하면 된다.
 *
 * 1차원배열의 회전은 해봤기에 이를 응용하면 풀 수 있는 문제..
 *
 *
 * A[1][1] ← A[1][2] ← A[1][3] ← A[1][4] ←            A[1][5]  --> 0번 그룹
 *    ↓                                       ↑
 * A[2][1]   A[2][2] ← A[2][3] ← A[2][4]  --> 1번그룹  A[2][5]
 *    ↓         ↓                   ↑         ↑
 * A[3][1]   A[3][2] → A[3][3] → A[3][4]              A[3][5]
 *    ↓                                       ↑
 * A[4][1] → A[4][2] → A[4][3] → A[4][4] →            A[4][5]
 *
 * 가장 겉으로 도는게 0번 그룹
 * 그 안에 1번 그룹 ...
 *
 * ex ) 0번 그룹
 * A[0][j] (0 <= j < M) -> 상
 * A[N-1][j] (0 <= j < M) -> 하
 * A[j][0] < (0 <= j < N) -> 좌
 * A[i][M-1] (0 <= i < N) --> 우
 *
 *
 */
public class Solution {


}
