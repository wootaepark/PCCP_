import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PR_04_SELF {

	// https://www.acmicpc.net/problem/11660

	public static int N; // 2차원 배열의 크기
	public static int Q; // 구간 합 질의 개수

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// arr 배열을 이용하여 sum 관련 정보를 담고 있는 2차원 배열 생성
		int[][] sumArr = getSumArray(arr);

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			getSum(x1, y1, x2, y2, sumArr);

		}

	}

	static int[][] getSumArray(int[][] arr) {
		int[][] sumArray = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sumArray[i][j] = sumArray[i - 1][j] + sumArray[i][j - 1] - sumArray[i - 1][j - 1] + arr[i][j];
			}
		}
		return sumArray;
	}

	static void getSum(int x1, int y1, int x2, int y2, int[][] sum) {
		int result = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
		System.out.println(result);
	}
}
