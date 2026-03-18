import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2468 {
	//https://www.acmicpc.net/problem/2468
	static int[] dc = {1, 0, -1, 0};
	static int[] dr = {0, 1, 0, -1};
	static boolean[][] visited;

	static int answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int max = 0;

		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];


		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				max = Math.max(max, tmp);
				arr[i][j] = tmp;
			}
		}

		for (int i = 0; i <= max; i++) {
			// 비를 0 부터 max 까지 내리게 한다.
			int count = 0;
			visited = new boolean[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (arr[j][k] <= i) {
						visited[j][k] = true;
					}
					if (!visited[j][k]) {
						bfs(j, k, i, arr);
						count++;
					}

				}
			}

			answer = Math.max(answer, count);

		}

		System.out.println(answer);

	}

	private static void bfs(int row, int col, int rain, int[][] arr) {

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {row, col}); // row, col
		visited[row][col] = true;

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = tmp[0] + dr[i];
				int nc = tmp[1] + dc[i];

				if (nr >= 0 && nc >= 0 && nr < arr.length && nc < arr[0].length
					&& !visited[nr][nc]) {
					visited[nr][nc] = true;

					if (arr[nr][nc] > rain) {
						queue.offer(new int[] {nr, nc});
					}
				}
			}
		}

	}
}
