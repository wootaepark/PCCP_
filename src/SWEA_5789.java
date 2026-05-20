
import java.util.*;
import java.io.*;

public class SWEA_5789 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 배열 크기
			int[] arr = new int[N + 1];

			int Q = Integer.parseInt(st.nextToken()); // 질문 수

			for (int i = 1; i <= Q; i++) {
				st = new StringTokenizer(br.readLine());
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());

				for (int j = L; j <= R; j++) {
					arr[j] = i;
				}

			}

			System.out.print("#" + test_case + " ");
			for (int i = 1; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();

		}
	}
}