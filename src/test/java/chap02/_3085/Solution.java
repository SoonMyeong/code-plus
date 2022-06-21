package chap02._3085;

import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void solution() {
        String[] strs = {"PPPP", "CYZY", "CCPY", "PPCC"};
        result(strs);
    }

    private void result(String[] strs) {
        int size = strs.length;
        char[][] arr = new char[size][size];
        for (int i = 0; i < size; i++) {
            arr[i] = strs[i].toCharArray();
        }
        int answer = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j + 1 < size) {
                    swap(arr, i, j, i, j + 1);
                    int temp = check(arr, i, i, j, j + 1);
                    if (answer < temp) {
                        answer = temp;
                    }
                    swap(arr, i, j, i, j + 1);
                }
                if (i + 1 < size) {
                    swap(arr, i, j, i+1, j );
                    int temp = check(arr, i, i+1, j, j );
                    if (answer < temp) {
                        answer = temp;
                    }
                    swap(arr, i, j, i+1, j );
                }
            }
        }
        System.out.println(answer);
    }

    private void swap(char[][] arr, int i, int j, int i1, int j1) {
            char temp = arr[i][j];
            arr[i][j] = arr[i1][j1];
            arr[i1][j1] = temp;
    }

    private int check(char[][] arr, int rowStart, int rowEnd, int colStart, int colEnd) {
        int result = 1;
        int size = arr.length;

        for(int i = rowStart ; i <= rowEnd; i++) {
            int count = 1; //최소 1개는 나온다.
            for(int j = 1; j < size; j++) {
                if(arr[i][j] == arr[i][j-1]) {
                    count++;
                }else {
                    count = 1;
                }
                if(count > result) {
                    result = count;
                }
            }
        }

        for(int i = colStart ; i <= colEnd; i++) {
            int count = 1;
            for(int j = 1; j< size; j++) {
                if(arr[j][i] == arr[j-1][i]) {
                    count++;
                }else {
                    count = 1;
                }
                if(count > result) {
                    result = count;
                }
            }
        }

        return result;
    }

}
