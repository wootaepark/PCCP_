import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PR_25 {

	//https://www.acmicpc.net/problem/13023

	static int N;
	static int M;

	static ArrayList<Integer>[] arr; // 친구 사이 배열
	static boolean[] visited;
	static boolean arrive;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 노드 수
		M = Integer.parseInt(st.nextToken()); // 에지 수

		arr = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}
		visited = new boolean[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}

		for (int i = 0; i < N; i++) {
			DFS(i, 1);
			if (arrive)
				break;
		}
		if (arrive)
			System.out.println("1");
		else
			System.out.println("0");

	}

	static void DFS(int node, int depth) {

		if (depth == 5) {
			arrive = true;
			return;
		}
		visited[node] = true;

		for (int i : arr[node]) {
			if (!visited[i]) {
				DFS(i, depth + 1);
			}
		}
		visited[node] = false;

	}
}
