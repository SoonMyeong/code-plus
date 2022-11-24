package chap01._2178;

import java.util.Scanner;

public class Test
{
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int sum = Integer.MAX_VALUE;
    static int total = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
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
        dfs(1,1,arr,visited);
        System.out.println(sum);
    }

    private static void dfs(int x, int y, int[][] arr, boolean[][] visited)
    {
        if(x==4 && y == 6) {
            sum = Math.min(sum, total);
            return;
        }
        for(int j = 0; j< 4; j++) {
            int xx = x + dx[j];
            int yy = y + dy[j];
            if(xx >0 && xx <= 4 && yy >0 && yy <= 6)
            {
                if (!visited[xx][yy] && arr[xx][yy] == 1)
                {
                    visited[xx][yy] = true;
                    total++;
                    dfs(xx, yy, arr, visited);
                }
            }
        }
    }

}
