import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {

	static int[][] arr;
	static int white_count = 0, blue_count = 0;

	// https://www.acmicpc.net/problem/2630

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		// ---------- 입력 부 종료 --------------

		recursive(0, 0, N, arr);
		System.out.println(white_count);
		System.out.println(blue_count);

	}

	private static void recursive(int row, int col, int size, int[][] arr) {

		//1 . 종료조건
		if (isSame(row, col, size, arr)) {
			if (arr[row][col] == 0) {
				white_count += 1;
			} else {
				blue_count += 1;
			}
			return;
		}

		recursive(row, col, size / 2, arr);
		recursive(row, col + size / 2, size / 2, arr);
		recursive(row + size / 2, col, size / 2, arr);
		recursive(row + size / 2, col + size / 2, size / 2, arr);
	}

	private static boolean isSame(int row, int col, int size, int[][] arr) {
		int tmp = arr[row][col];
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (arr[i][j] != tmp) {
					return false;
				}
			}
		}
		return true;
	}
}
