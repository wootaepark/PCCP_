
import java.util.*;
import java.io.*;

public class SWEA_1228 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {

			// 빨간 줄 입력
			int N = Integer.parseInt(br.readLine()); // 원본 암호문의 길이

			// 파란 줄 입력
			Queue<String> queue = new LinkedList<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				queue.add(st.nextToken());
			}

			// 초록 줄 입력
			int count = Integer.parseInt(br.readLine()); // 명령어 개수 입력

			// 보라 줄 입력 (명령어 입력)
			String input = br.readLine();
			String[] commands = input.split("I");

			for (int i = 1; i < commands.length; i++) {
				queue = solve(queue, commands[i].trim());
			}

			StringBuilder sb = new StringBuilder("#");
			sb.append(test_case).append(" ");

			for (int i = 0; i < 10; i++) {
				sb.append(queue.poll()).append(" ");
			}
			System.out.println(sb);

		}
	}

	private static Queue<String> solve(Queue<String> queue, String s) {

		String[] str = s.split(" ");

		int position = Integer.parseInt(str[0]); // 삽입 위치
		int count = Integer.parseInt(str[1]); // 삽입 개수

		Queue<String> tmpQ = new LinkedList<>();

		for (int i = 0; i < position; i++) {
			tmpQ.offer(queue.poll());
		}

		for (int i = 2; i < str.length; i++) {
			tmpQ.offer(str[i]);
		}

		while (!queue.isEmpty()) {
			String tmp1 = queue.poll();
			tmpQ.offer(tmp1);
		}

		return tmpQ;
	}
}