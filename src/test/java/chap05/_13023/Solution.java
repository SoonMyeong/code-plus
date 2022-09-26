package chap05._13023;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.
 *
 * 오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.
 *
 * A는 B와 친구다.
 * B는 C와 친구다.
 * C는 D와 친구다.
 * D는 E와 친구다.
 * 위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.
 *
 * 둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다.
 * (0 ≤ a, b ≤ N-1, a ≠ b) 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.
 *
 * 출력
 * 문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다.
 *
 * 답도안나왔는데, 그래프를 잘 생각해보면 구할 수 있는 문제.
 * 백준의 경우 인접행렬,인접리스트,간선리스트 모두를 활용해서 풀었다.
 * 나도 이렇게 풀어놓고 나중에 복습용으로 볼 때 보면 좋을 거 같다.
 */
public class Solution {
    class Edge {
        int from;
        int to;
        Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
    boolean[][] a = new boolean[2000][2000];
    int n = 5;
    int m = 4;
    List<Integer>[] g = new ArrayList[n];
    List<Edge> edges = new ArrayList<>();

    @Test
    void solution() {
        int[][] arr = {{0,1},{1,2},{2,3},{3,4}};
        for(int i = 0; i< n; i++) {
            g[i] = new ArrayList<>();
        }

        for(int i = 0; i< m; i++) {
            edges.add(new Edge(arr[i][0],arr[i][1])); //양방향이므로 , 간선그래프
            edges.add(new Edge(arr[i][1], arr[i][0]));
            a[ arr[i][0] ][ arr[i][1] ]= a[ arr[i][1] ][ arr[i][0] ]= true; //인접행렬
            g[ arr[i][0] ].add(arr[i][1]); //인접그래프
            g[ arr[i][1] ].add(arr[i][0]);
        }
        m*=2; //양방향이므로 간선도 2배

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<m; j++) {
                //A->B
                int A = edges.get(i).from;
                int B = edges.get(i).to;

                //C->D
                int C = edges.get(j).from;
                int D = edges.get(j).to;

                if(A==B || A==C || A==D || B==C || B==D || C==D) {
                    continue;
                } //A-B , C-D 연결고리만 골라내기

                if(!a[B][C]) {
                    continue;
                } //B-C 연결고리 찾기

                for(int E : g[D]) {
                    if(A==E || B==E || C==E || D==E) {
                        continue;
                    } //E는 D와만 연결되어 있다., D를 넣은건 D와 값이 다를것이므로
                    System.out.println(1);
                    System.exit(0);
                }

            }
        }
        System.out.println(0);
    }
}
