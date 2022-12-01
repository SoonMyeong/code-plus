package chap05._2606;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int computerCount = Integer.parseInt(scanner.nextLine());
        int settingCount = Integer.parseInt(scanner.nextLine());

        List<Integer>[] result = new ArrayList[computerCount + 1];
        boolean[] visited = new boolean[computerCount + 1];

        for(int i = 0; i <= computerCount; i++) {
            result[i] = new ArrayList<>();
        }

        for(int i = 0; i<settingCount; i++) {
            String[] numbers = scanner.nextLine().split(" ");
            result[Integer.parseInt(numbers[0])].add(Integer.parseInt(numbers[1]));
            result[Integer.parseInt(numbers[1])].add(Integer.parseInt(numbers[0]));
        }

        System.out.println(bfs(1, result, visited));
    }

    private static int bfs(int start, List<Integer>[] result, boolean[] visited) {
        int sum = 0;
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int n = queue.remove();
            for(int i : result[n]) {
                if(!visited[i]) {
                    visited[i] = true;
                    sum++;
                    queue.add(i);
                }
            }
        }
        return sum;
    }
}
