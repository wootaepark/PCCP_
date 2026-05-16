import java.util.*;
import java.io.*;

public class SWEA_2814 {
	static boolean[] visited;
	static ArrayList<Integer>[] A;
	static int maxPath;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			A = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				A[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				A[S].add(E);
				A[E].add(S);
			}

			maxPath = 0;
			visited = new boolean[N + 1];

			for (int i = 1; i <= N; i++) {
				visited[i] = true;
				dfs(i, 1);
				visited[i] = false;
			}

			System.out.println("#" + test_case + " " + maxPath);
		}
	}

	private static void dfs(int v, int cnt) {

		maxPath = Math.max(maxPath, cnt);

		for (int next : A[v]) {
			if (!visited[next]) {
				visited[next] = true;
				dfs(next, cnt + 1);
				visited[next] = false;
			}
		}
	}
}