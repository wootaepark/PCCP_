import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PR_48_2 {
	// 48번 문제 bfs 풀이

	static ArrayList<Integer>[] adj;
	static int[] group_info; // 0: 미방문, 1: 그룹A, 2: 그룹B
	static int V, E;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine()); // 테스트 케이스

		while (K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			adj = new ArrayList[V + 1];
			group_info = new int[V + 1];

			for (int i = 1; i <= V; i++) {
				adj[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				// 핵심 1: 무방향 그래프이므로 양쪽에 추가
				adj[u].add(v);
				adj[v].add(u);
			}

			boolean isBipartite = true;
			for (int i = 1; i <= V; i++) {
				// 핵심 2: 방문하지 않은 모든 노드에 대해 BFS 실행 (연결 성분 고려)
				if (group_info[i] == 0) {
					if (!bfs(i)) {
						isBipartite = false;
						break;
					}
				}
			}

			System.out.println(isBipartite ? "YES" : "NO");
		}
	}

	private static boolean bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		group_info[start] = 1; // 시작 노드 색칠

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			for (int next : adj[curr]) {
				// 인접한 노드가 같은 색이라면 이분 그래프가 아님!
				if (group_info[next] == group_info[curr]) {
					return false;
				}

				// 방문하지 않은 노드라면 반대 색으로 칠하고 큐에 삽입
				if (group_info[next] == 0) {
					group_info[next] = (group_info[curr] == 1) ? 2 : 1;
					queue.add(next);
				}
			}
		}
		return true;
	}
}
