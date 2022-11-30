package chap05._2606;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int computerCount = Integer.parseInt(scanner.nextLine());
        int settingCount = Integer.parseInt(scanner.nextLine());

        List<List<Integer>> result = new ArrayList<>();
        for(int i =0; i<= computerCount; i++) {
            List<Integer> el = new ArrayList<>();
            result.add(el);
        }

        for(int i = 0; i<settingCount; i++) {
            String[] numbers = scanner.nextLine().split(" ");
            result.get(Integer.parseInt(numbers[0])).add(Integer.parseInt(numbers[1]));
            result.get(Integer.parseInt(numbers[1])).add(Integer.parseInt(numbers[0]));
        }

    }
}
