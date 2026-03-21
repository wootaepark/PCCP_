import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {

	static int[] dr = {-1, 0, 1, 0}; // 상, 우, 하, 좌
	static int[] dc = {0, 1, 0, -1};

	//https://www.acmicpc.net/problem/14503

	static int answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		// 시작 위치
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		int direction = Integer.parseInt(st.nextToken()); // 0 (north), 1 (east), 2 (south), 3 (west)

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 입력 부 종료

		move(row, col, direction, arr);
		System.out.println(answer);

	}

	private static void move(int row, int col, int direction, int[][] arr) {

		// 1. 현재 칸이 아직 정소되지 않은 경우, 현재칸을 청소 한다.
		if (arr[row][col] == 0) {
			arr[row][col] = -1; // 청소된 경우를 -1 이라고 놓는다.
			answer++;

		}

		// 2 and 3 . 현재칸의 주변 4칸 검색
		boolean flag = false; // 하나라도 청소 가능하면 true
		int tmpDirection = direction;

		for (int i = 0; i < 4; i++) {
			int tmpRow = row + dr[i];
			int tmpCol = col + dc[i];

			// 3. 주변 4칸중 청소되지 않은 빈 칸 (0) 이 있는 경우
			if (tmpRow >= 0 && tmpCol >= 0 && tmpRow < arr.length && tmpCol < arr[0].length) { // 유효성 검사

				if (arr[tmpRow][tmpCol] == 0) {
					flag = true;
					break;

				}

			}
		}

		if (flag) {
			for (int i = 0; i < 4; i++) {
				tmpDirection = (tmpDirection - 1 + 4) % 4;
				if (arr[row + dr[tmpDirection]][col + dc[tmpDirection]] == 0) { // 바라보는 방향 기준으로 앞쪽칸의 청소여부
					// 청소가 안됐으면 전진 후 청소
					move(row + dr[tmpDirection], col + dc[tmpDirection], tmpDirection, arr); // 재귀
					break;

				}

			}
		}



		if (!flag) {
			// 2. 주변 4칸중 청소되지 않은 빈 칸 (0) 이 없는 경우

			// 후진 할 수 있으면 후진
			int tmpRow = row - dr[direction];
			int tmpCol = col - dc[direction];
			if (tmpRow >= 0 && tmpCol >= 0 && tmpRow < arr.length && tmpCol < arr[0].length) {
				if (arr[tmpRow][tmpCol] != 1) {
					move(tmpRow, tmpCol, direction, arr);
				}
			}

		}

	}
}
