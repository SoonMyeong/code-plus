package chap01._17427;

import org.junit.jupiter.api.Test;


/**
 *
 * 두 자연수 A와 B가 있을 때, A = BC를 만족하는 자연수 C를 A의 약수라고 한다.
 * 예를 들어, 2의 약수는 1, 2가 있고, 24의 약수는 1, 2, 3, 4, 6, 8, 12, 24가 있다.
 * 자연수 A의 약수의 합은 A의 모든 약수를 더한 값이고, f(A)로 표현한다.
 * x보다 작거나 같은 모든 자연수 y의 f(y)값을 더한 값은 g(x)로 표현한다.
 * 첫째 줄에 g(N)를 출력한다.
 * ----------------------------------
* n을 입력 받을 때 1 부터 n 까지 약수의 합들을 구하는 문제 이다.
 * -> N 이하의 자연수 중에 1을 약수로 갖는 개수 (1의 배수) 는 [N/1] 개 이다.
 * -> N 이하의 자연수 중에 2을 약수로 갖는 개수 (1의 배수) 는 [N/2] 개 이다.
 *
 */
public class Solution {
    @Test
    void solution() {
        int n = 70;
        System.out.println(sum(n));
    }

    private int sum(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer += (n / i) * i;
        }

        return answer;
    }
}
