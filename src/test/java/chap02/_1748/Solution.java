package chap02._1748;

import org.junit.jupiter.api.Test;


/**
 *
 * 1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
 *
 * 1234567891011121314151617181920212223...
 *
 * 이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N(1 ≤ N ≤ 100,000,000)이 주어진다.
 *
 * 출력
 * 첫째 줄에 새로운 수의 자릿수를 출력한다.
 *
 */
public class Solution {
    @Test
    void solution() {
        int n = 15;
        newNumber(n);
    }

    /**
     * for 문을 그냥 무식하게 1부터 1억까지 돌면 1초걸려서 타임 아웃남 (문제 범위 1억까지 입력 가능)
     * @param n
     */
    private void newNumber(int n) {
        long result = 0;
        int len = 1;
        //(9*1)*1 + (9 * 10) *2 + (9 * 100) * 3 ...
        for(int start = 1; start <=n; start*=10) {
            int end = start * 10 - 1; //다음 자리수 end 미리 구해놓고 확인
            if(end > n) {
                end = n;
            }
            result += (end - start + 1) * len;
            len++;
        }
        System.out.println(result);
    }

}
