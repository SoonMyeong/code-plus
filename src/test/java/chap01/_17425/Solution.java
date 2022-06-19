package chap01._17425;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 두 자연수 A와 B가 있을 때, A = BC를 만족하는 자연수 C를 A의 약수라고 한다.
 * 예를 들어, 2의 약수는 1, 2가 있고, 24의 약수는 1, 2, 3, 4, 6, 8, 12, 24가 있다.
 * 자연수 A의 약수의 합은 A의 모든 약수를 더한 값이고, f(A)로 표현한다.
 * x보다 작거나 같은 모든 자연수 y의 f(y)값을 더한 값은 g(x)로 표현한다.
 *
 * 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 100,000)가 주어진다.
 * 둘째 줄부터 테스트 케이스가 한 줄에 하나씩 주어지며 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
 *
 * 자연수 N이 주어졌을 때, g(N)을 구해보자.
 *
 * 각각의 테스트 케이스마다, 한 줄에 하나씩 g(N)를 출력한다.
 *------------------------------------------
 * 17427 문제와 똑같으나 테스트 케이스 개수 만큼 모두 통과 해야 한다.
 * 기존 17427 방식대로 풀게 되면 O(TN) 이 되어 10만 x 100 만 = 1000억, 약 1000초가 걸리게 된다.
 * (대략 1억 개 연산이 보통 1초가 걸린다.)
 * 1초 내에 해결하려면?
 * 해당 범위 내에 모든 g(N) 을 미리 다 구한 뒤 그 합들도 미리 구해 놓고 테스트케이스에 따른 결과를 리턴 해 준다.
 * 2 ~ n 까지의 약수의 합을 저장할 공간을 long []d 라고 할 때
 * (일단 초기 값 1로 모두 셋팅한다. 1을 가지고 있는 약수 즉 1의 배수는 모든 숫자에 포함되기 때문)
 * for(int i =2; i<=n; i++) {
 *     for(int j=1; i*j<=n; j++) {
 *         d[i*j] += i;
 *     }
 * }
 *
 * 이 문제.. BufferedReader, BufferedWriter 안 쓰면 시간초과 뜸..
 *
 */
public class Solution {
    @Test
    void solution() {
        int []q = {1,2,10,70,10000};
        sum(q);
    }

    private void sum(int[] n) {
        int max = 1000000;
        long[] d = new long[max+1];
        Arrays.fill(d, 1);

        for(int i = 2; i <= max; i++) {
            for(int j = 1; i * j <= max; j++) {
                d[i * j] += i;
            }
        }

        long[] s = new long[max+1];
        for(int i = 1; i <= max; i++) {
            s[i] = s[i-1] + d[i];
        }

        for(int num : n) {
            System.out.println(s[num]);
        }
    }
}
