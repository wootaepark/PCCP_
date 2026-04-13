import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AWT-lPB6dHUDFAVT&categoryId=AWT-lPB6dHUDFAVT&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=1

	static int T, N, L, answer;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());  // 테스트 케이스 수

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			arr = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken()); // 점수
				arr[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
			}

			answer = 0; // 테스트 케이스마다 초기화
			dfs(0, 0, 0);

			System.out.println("#" + t + " " + answer);
		}

	}

	private static void dfs(int idx, int score, int kcal) {
		if (kcal > L) {
			return;
		}
		// 모든 재료를 다 확인했을 때
		if (idx == N) {
			answer = Math.max(answer, score);
			return;
		}

		// 1. 현재 재료를 선택하는 경우
		dfs(idx + 1, score + arr[idx][0], kcal + arr[idx][1]);

		// 2. 현재 재료를 선택하지 않는 경우
		dfs(idx + 1, score, kcal);
	}
}

