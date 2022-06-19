package chap01._2609;

import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    void solution() {
        int a = 24;
        int b = 16;
        int g = gcd(a,b);
        System.out.println(g);
        System.out.println(a*b/g);
    }

    //유클리드 호제법
    private int gcd(int x, int y) {
        if(y == 0) {
            return x;
        }else {
            return gcd(y, x%y);
        }
    }
}
