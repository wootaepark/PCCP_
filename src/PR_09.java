import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PR_09 {
	//https://www.acmicpc.net/problem/12891

	static int[] current = new int[4]; // A, C, G, T 의 부분 문자열 내에서의 개수
	static int[] need = new int[4];
	static int correct_count = 0; // 이게 4 여야 가능한 문자열이다.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken()); // 주어지는 전체 문자열 길이
		int sub_len = Integer.parseInt(st.nextToken()); // 부분 문자열 길이

		int answer = 0;
		char[] dna = br.readLine().toCharArray(); // 주어진 문자들

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			need[i] = Integer.parseInt(st.nextToken());
			if (need[i] == 0) {
				correct_count++;
			}
		}

		int start = 0, end = sub_len - 1;

		for (int i = 0; i < sub_len; i++) {
			add(dna[i]);
		}
		if (correct_count == 4) {
			answer++;
		}

		// 슬라이딩 윈도우 로직이 여기 들어감
		for (int i = end + 1; i < len; i++) {
			remove(dna[start]);
			add(dna[i]);
			start = i - sub_len + 1;

			if (correct_count == 4) {
				answer++;
			}

		}

		System.out.println(answer);

	}

	private static void add(char c) {
		switch (c) {
			case 'A':
				current[0]++;
				if (current[0] == need[0]) {
					correct_count++;
				}
				break;
			case 'C':
				current[1]++;
				if (current[1] == need[1]) {
					correct_count++;
				}
				break;
			case 'G':
				current[2]++;
				if (current[2] == need[2]) {
					correct_count++;
				}
				break;
			case 'T':
				current[3]++;
				if (current[3] == need[3]) {
					correct_count++;
				}
				break;

		}

	}

	private static void remove(char c) {
		switch (c) {
			case 'A':
				if (current[0] == need[0]) {
					correct_count--;
				}
				current[0]--;
				break;
			case 'C':
				if (current[1] == need[1]) {
					correct_count--;
				}
				current[1]--;
				break;
			case 'G':
				if (current[2] == need[2]) {
					correct_count--;
				}
				current[2]--;
				break;
			case 'T':
				if (current[3] == need[3]) {
					correct_count--;
				}
				current[3]--;
				break;

		}
	}
}
