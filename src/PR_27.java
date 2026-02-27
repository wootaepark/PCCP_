import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PR_27 {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	static int[][] arr;
	static int N, M;
	static boolean[][] visited;

	// https://www.acmicpc.net/problem/2178
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 행 크기
		M = Integer.parseInt(st.nextToken()); // 열 크기

		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}

		// 입력부 종료
		BFS(0, 0);
		System.out.println(arr[N - 1][M - 1]);

	}

	static void BFS(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {row, col});
		visited[row][col] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x = now[0] + dx[i];
				int y = now[1] + dy[i];
				if (x >= 0 && y >= 0 && x < N && y < M) {
					if (arr[x][y] != 0 && !visited[x][y]) {
						visited[x][y] = true;
						arr[x][y] = arr[now[0]][now[1]] + 1;
						queue.offer(new int[] {x, y});
					}
				}
			}
		}

	}
}
