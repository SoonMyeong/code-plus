package chap05._10866;

import java.util.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 *
 * 명령은 총 여덟 가지이다.
 *
 * push_front X: 정수 X를 덱의 앞에 넣는다.
 * push_back X: 정수 X를 덱의 뒤에 넣는다.
 * pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 덱에 들어있는 정수의 개수를 출력한다.
 * empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
 * front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *
 */
public class Solution {

    static class Deque {
        private static LinkedList<Integer> deque = new LinkedList<>();

        public static void pushFront(int n) {
            deque.addFirst(n);
        }

        public static void pushBack(int n) {
            deque.addLast(n);
        }

        public static int popFront() {
            if(deque.isEmpty()) {
                return -1;
            }
            return deque.removeFirst();
        }

        public static int popBack() {
            if(deque.isEmpty()) {
                return -1;
            }
            return deque.removeLast();
        }

        public static int empty() {
            return deque.isEmpty() ? 1 : 0;
        }

        public static int size() {
            return deque.size();
        }

        public static int front() {
            if(deque.isEmpty()) {
                return -1;
            }
            return deque.getFirst();
        }

        public static int back() {
            if(deque.isEmpty()) {
                return -1;
            }
            return deque.getLast();
        }

    }

    @Test
    void solution() {
        Deque.pushBack(1);
        Deque.pushFront(2);
        Assertions.assertEquals(Deque.front(), 2);
        Assertions.assertEquals(Deque.back(), 1);
        Assertions.assertEquals(Deque.size(), 2);
        Assertions.assertEquals(Deque.empty(), 0);
        Assertions.assertEquals(Deque.popFront(), 2);
        Assertions.assertEquals(Deque.popBack(), 1);
        Assertions.assertEquals(Deque.popFront(), -1);
        Assertions.assertEquals(Deque.size(), 0);
        Assertions.assertEquals(Deque.empty(), 1);
        Assertions.assertEquals(Deque.popBack(), -1);
        Deque.pushFront(3);
        Assertions.assertEquals(Deque.empty(), 0);
        Assertions.assertEquals(Deque.front(), 3);
    }
}
