import java.io.*;
import java.util.*;

public class SWEA_1218 {
	private static int answer;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			answer = 1;
			int size = Integer.parseInt(br.readLine()); // 주어지는 문자열의 길이
			String str = br.readLine();

			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < size; i++) {

				if (str.charAt(i) != '(' && str.charAt(i) != '{' && str.charAt(i) != '<'
					&& str.charAt(i) != '[') { // 닫는 괄호인 경우
					char opposite = opt(str.charAt(i));
					if (!stack.isEmpty() && stack.peek() != opposite) {
						answer = 0;
						break;
					} else {
						stack.pop(); // 동일한 경우
						continue;
					}
				}
				stack.push(str.charAt(i)); // 여는 괄호는 무조건 push
			}
			System.out.println("#" + test_case + " " + answer);

		}
	}

	private static char opt(char c) {
		if (c == ')')
			return '(';
		if (c == '}')
			return '{';
		if (c == ']')
			return '[';
		if (c == '>')
			return '<';
		return 'e';
	}
}