import java.util.*;
import java.io.*;

class SWEA_1204 {

	public static int AMOUNT = 1000;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		int[] arr = new int[AMOUNT];

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); // 횟수 넘버
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < AMOUNT; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			int count = 0, max = 0, max_score = 0, tmp = arr[0]; // 해당 점수 개수, 최빈수의 개수, 최빈 점수, 현재 탐색중인 수

			for (int i : arr) {

				if (tmp == i) {
					count++;
				}
				else{
					// 이 부분이 약간 비효율 적이긴 하다. (tmp 값이 무의미하게 증가만 하고 있고 불필요한 if 문이 실행될 수 있음)
					if (count >= max) {
						max = count;
						max_score = tmp;
					}
					count = 0;
					tmp++;
				}


			}
			System.out.printf("#%d %d\n", test_case, max_score);
		}
	}
}