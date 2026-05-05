import java.util.Queue;
import java.util.LinkedList;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class SWEA_1249 {

	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD

	static int[][] map;
	static int[][] visit;

	static int[] dirX = {-1, 1, 0, 0};
	static int[] dirY = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visit = new int[n][n];
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = line.charAt(j) - '0';
					visit[i][j] = -1; // 방문하지 않은 경우는 -1
				}
			}
			bfs();
			sb.append("#").append(tc).append(" ").append(visit[n - 1][n - 1]).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0});
		visit[0][0] = 0;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curTime = visit[cur[0]][cur[1]];

			for (int i = 0; i < dirX.length; i++) {
				int nX = cur[0] + dirX[i];
				int nY = cur[1] + dirY[i];

				if (check(nX, nY)) {
					continue;
				}

				if (visit[nX][nY] == -1 || (visit[nX][nY] > curTime + map[nX][nY])) {
					// 방문하지 않았거나 || 방문했지만 지금 경로가 원래 경로 코스트보다 작은경우
					visit[nX][nY] = curTime + map[nX][nY];
					queue.offer(new int[] {nX, nY});
				}
			}
		}
	}

	private static boolean check(int nX, int nY) {
		return nX < 0 || nX >= map.length || nY < 0 || nY >= map[nX].length;
	}
}