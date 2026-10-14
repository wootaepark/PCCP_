package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

// lv2 : 정답률 57%
// https://school.programmers.co.kr/learn/courses/30/lessons/42883?language=java
public class MakeBigNumber {

    public static void main(String[] args) {
        System.out.println(solution("4177252841", 4));
    }


    public static String solution(String number, int k){
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            // 제거 횟수가 남아 있고, top이 현재 숫자보다 작으면 계속 pop
            while (k > 0 && !stack.isEmpty() && stack.peekLast() < c) {
                stack.pollLast();
                k--;
            }
            stack.addLast(c);
        }

        // 순회가 끝났는데 k가 남았다면 뒤에서 잘라내기 (내림차순인 경우)
        while (k > 0) {
            stack.pollLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
