import java.util.*;
import java.io.*;

class SWEA_1209 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {

			String line = br.readLine();
			if (line == null) break;
			int test_case_idx = Integer.parseInt(line);

			int[][] arr = new int[100][100];


			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 결과 출력 (getMax 메서드는 그대로 사용 가능)
			System.out.println("#" + test_case_idx + " " + getMax(arr));
		}
	}

	private static int getMax(int[][] arr) {
		int max = 0;
		// 행 합, 열 합 계산
		for (int i = 0; i < 100; i++) {
			int rowSum = 0, colSum = 0;
			for (int j = 0; j < 100; j++) {
				rowSum += arr[i][j];
				colSum += arr[j][i];
			}
			max = Math.max(max, Math.max(rowSum, colSum));
		}
		// 대각선 합 계산 (\ 방향)
		int diag1 = 0;
		for (int i = 0; i < 100; i++) diag1 += arr[i][i];
		max = Math.max(max, diag1);

		// 대각선 합 계산 (/ 방향) - 이 부분을 수정함
		int diag2 = 0;
		for (int i = 0; i < 100; i++) diag2 += arr[i][99 - i];
		max = Math.max(max, diag2);

		return max;
	}
}