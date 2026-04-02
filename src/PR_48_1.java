import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PR_48_1 {

	// https://www.acmicpc.net/problem/1707
	// PR_48 은 직접 푼 코드, 이 코드는 책의 코드
	static ArrayList<Integer>[] A;
	static int[] check;
	static boolean[] visited;
	static boolean isEven;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int t = 0; t < N; t++) {
			String[] s = br.readLine().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			A = new ArrayList[V + 1];
			visited = new boolean[V + 1];
			check = new int[V + 1];
			isEven = true; // 초기는 이분 그래프라고 생각

			for (int i = 1; i <= V; i++) {
				A[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				s = br.readLine().split(" ");
				int start = Integer.parseInt(s[0]);
				int end = Integer.parseInt(s[1]);
				A[start].add(end);
				A[end].add(start);
			}
			for (int i = 1; i <= V; i++) {
				if (isEven) {
					DFS(i);
				} else
					break;
			}
			if (isEven) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

	private static void DFS(int v) {
		visited[v] = true;
		for (int i : A[v]) {
			if (!visited[i]) {
				// 인접한 노드는 같은 집합이 아니므로 이전 노드와 다른 집합으로 처리
				check[i] = (check[v] + 1) % 2; // 0 또는 1
				DFS(i);
			}
			// 이미 방문한 노드가 현재 노드와 같은 집합이면 이분 그래프 아님
			else if (check[v] == check[i]) {
				isEven = false;
			}
		}
	}
}
