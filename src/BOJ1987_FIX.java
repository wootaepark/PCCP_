import java.io.*;
import java.util.*;

public class BOJ1987_FIX { // 백준 1987 문제 개선 버전
	static int R, C;
	static int[][] board;
	static int maxDist = 0;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new int[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				// 문자를 미리 숫자로 변환 (A=0, B=1, ...)
				board[i][j] = line.charAt(j) - 'A';
			}
		}

		// 비트마스크: (1 << board[0][0]) -> 시작점의 알파벳 비트 켜기
		dfs(0, 0, 1 << board[0][0], 1); // 1 을 맨 오른쪽 부터 board[0][0] 칸 만큼 이동

		// 예를 들어 0번재 비트는 'A' 를 사용했는가 ~ 25번째 비트는 'Z' 를 사용했는가 ..

		System.out.println(maxDist);
	}

	private static void dfs(int r, int c, int visitedBit, int count) {
		maxDist = Math.max(maxDist, count);

		// 모든 방향을 다 가봐도 더 이상 갈 곳이 없으면 자동 종료 (백트래킹)
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
				int nextCharBit = 1 << board[nr][nc];

				// 해당 알파벳을 아직 사용하지 않았다면 (& 연산 결과가 0이면)
				if ((visitedBit & nextCharBit) == 0) {
					dfs(nr, nc, visitedBit | nextCharBit, count + 1); // 인자로서 변환된 정보를 넘기는것 자체가 백트래킹의 목적
					// | 연산을 통해 해당 알파벳의 방문 정보 비트에 추가
				}
			}
		}
	}
}