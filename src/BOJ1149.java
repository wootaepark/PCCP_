import java.util.Scanner;

public class BOJ1149 {

	// https://www.acmicpc.net/problem/1149

	static int[][] rgb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		rgb = new int[N][3];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				rgb[i][j] = sc.nextInt();
			}
		}

		// 입력 부 종료

		int[][] dp = new int[N][3];

		dp[0][0] = rgb[0][0];
		dp[0][1] = rgb[0][1];
		dp[0][2] = rgb[0][2];
		// 각각 r, g, b 로 칠했을때 i번째 집까지 최소 총합

		for (int i = 1; i < N; i++) {
			dp[i][0] = rgb[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = rgb[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = rgb[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}

		System.out.println(Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));

	}
}
