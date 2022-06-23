package chap02._1107;

import org.junit.jupiter.api.Test;

/**
 *
 * 수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.
 * 리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다.
 * 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.
 * 수빈이가 지금 이동하려고 하는 채널은 N이다. 어떤 버튼이 고장났는지 주어졌을 때,
 * 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.
 *
 * 수빈이가 지금 보고 있는 채널은 100번이다.
 *
 * 첫째 줄에 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)이 주어진다.  둘째 줄에는 고장난 버튼의 개수 M (0 ≤ M ≤ 10)이 주어진다.
 * 고장난 버튼이 있는 경우에는 셋째 줄에는 고장난 버튼이 주어지며, 같은 버튼이 여러 번 주어지는 경우는 없다.
 *
 * 첫째 줄에 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는지를 출력한다.
 * -------------------------------------------------------
 *
 * 불필요한 값과 중복되는 값은 모두 포함하지 않는다! (중요)
 *
 *
 */
public class Solution {
    private static boolean[] brokenNumbers = new boolean[10];
    @Test
    void solution() {
        int n = 5457;
        int brokenCount = 3;
        int[] brokenButtons = {6,7,8};
        remote(n , brokenCount, brokenButtons);
    }

    private void remote(int n, int brokenCount, int[] brokenButtons) {
        for(int i = 0; i < brokenCount; i++) {
            brokenNumbers[brokenButtons[i]] = true;
        }
        int answer = n - 100;
        if(answer < 0) {
            answer =  -answer;
        }

        for(int i = 0; i <= 1000000; i++) {
            int numLength = numCount(i);
            if(numLength > 0) {
                int press = i - n;
                if(press < 0) {
                    press = -press;
                }
                if(answer > numLength + press) {
                    answer = numLength + press;
                }
            }
        }

        System.out.println(answer);

    }

    /**
     * 입력받은 숫자(i) 에서 고장 난 버튼 존재 시 0 을 리턴
     * 숫자의 개수를 구하는 메서드
     *
     */
    private int numCount(int i) {
        if(i == 0) {
            if(brokenNumbers[0]) {
                return 0;
            }else {
                return 1;
            }
        }
        int result = 0;
        while(i > 0) {
            if(brokenNumbers[i % 10]) {
                return 0 ;
            }
            result ++;
            i /= 10;
        }

        return result;
    }
}
