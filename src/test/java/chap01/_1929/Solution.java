package chap01._1929;

import org.junit.jupiter.api.Test;

/**
 * M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 * 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다.
 * (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
 * --------
 * 에라토스테네스의 체를 이용하여 가장 빠르게 구현할 수 있다.
 * [에라토스테네스의 체 기본 모델]
 * boolean[] check = new boolean[b + 1]; //true : 삭제
 * check[0] = check[1] = true;
 * for(int i = 2; i*i <= b; i++) { //약수 구할 때를 떠올려 보기
 * if(check[i]) {
 * continue;
 * }
 * for(int j = i * i; j <= b; j+=i) { //배수, 시작점이 제곱근인건 i-1 배수를 돌면서 지워졌기 때문
 * check[j] = true;
 * }
 * }
 */
public class Solution {
    @Test
    void solution() {
        int a = 3;
        int b = 16;
        eratosthenes(a, b);
    }

    private void eratosthenes(int a, int b) {
        boolean[] check = new boolean[b + 1]; //true : 삭제
        check[0] = check[1] = true;
        for (int i = 2; i * i <= b; i++) { // i 의 제곱이 b보다 커지면 범위를 넘어간 거라서 안구해도 됨, 아래 for 문 시작점이 i^2 임
            if (check[i]) {
                continue;
            }
            for (int j = i * i; j <= b; j += i) { //배수, 시작점이 제곱근인건 i-1 배수를 돌면서 지워졌기 때문
                check[j] = true;
            }
        }
        for (int i = a; i <= b; i++) {
            if (!check[i]) {
                System.out.println(i);
            }
        }
    }

}
