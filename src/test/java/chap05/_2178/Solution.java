package chap05._2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//dfs & bfs
public class Solution {
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int sum = Integer.MAX_VALUE;
    static int n;
    static int m;

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        int [][] arr = new int[n+1][m+1];
        boolean [][] visited = new boolean[n+1][m+1];
        scan.nextLine();
        for(int i = 1; i<=n; i++) {
            String str = scan.nextLine();
            String[] ns = str.split("");
            for(int j = 1; j<=m; j++) {
                arr[i][j] = Integer.parseInt(ns[j-1]);
            }
        }
        visited[1][1] = true;
//        dfs(1,1,arr,visited,1);
//        System.out.println(sum);
        bfs(1,1,arr,visited);
        System.out.println(arr[n][m]);

    }

    private static void bfs(int x, int y, int[][] arr, boolean[][] visited) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Point p = queue.remove();

            for(int i = 0; i < 4; i++) {
                int xx = p.x + dx[i];
                int yy = p.y + dy[i];

                if(xx >0 && xx<=n && yy >0 && yy <=m) {
                    if(arr[xx][yy] == 1 && !visited[xx][yy]) {
                        queue.add(new Point(xx,yy));
                        visited[xx][yy] = true;
                        arr[xx][yy] = arr[p.x][p.y] + 1; //방문 순서를 기록한다.
                    }
                }

            }
        }

    }
    //백트래킹
    private static void dfs(int x, int y, int[][] arr, boolean[][] visited, int total)
    {
        if(x==n && y ==m) {
            sum = Math.min(sum, total);
            return;
        }

        for(int j = 0; j< 4; j++) {
            int xx = x + dx[j];
            int yy = y + dy[j];
            if(xx >0 && xx <= n && yy >0 && yy <= m)
            {
                if (!visited[xx][yy] && arr[xx][yy] == 1)
                {
                    visited[x][y] = true;
                    dfs(xx, yy, arr, visited,++total);
                    visited[xx][yy] = false;
                    total--;
                }
            }
        }
    }
}
