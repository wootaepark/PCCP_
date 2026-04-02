import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PR_48 {

	static ArrayList<Integer>[] arr;
	static int[] group_info;
	static boolean[] visited;
	static boolean isBinary = true;

	//https://www.acmicpc.net/problem/1707

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 테스트 케이스 수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken()); // 노드 수
			int edge = Integer.parseInt(st.nextToken()); // 케이스 수

			arr = new ArrayList[node + 1];
			group_info = new int[node + 1];
			visited = new boolean[node + 1];

			for (int j = 0; j < node + 1; j++) {
				arr[j] = new ArrayList<>();
			}

			for (int k = 0; k < edge; k++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()); // 출발 정점
				int b = Integer.parseInt(st.nextToken()); // 도착 정점
				arr[a].add(b);
				arr[b].add(a);
			}

			// 간선 리스트를 통한 로직 구현 및 결과 출력
			for (int l = 1; l <= node; l++) {
				if (!visited[l]) {
					dfs(l);
				}
				if (!isBinary)
					break;

			}
			if (isBinary) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			isBinary = true;

		}

	}

	private static void dfs(int x) {
		if (visited[x]) {
			return;
		}
		visited[x] = true;
		for (int i : arr[x]) {
			if (group_info[x] == group_info[i] && visited[i]) {
				isBinary = false;
				return;
			}
			if (group_info[x] == 0 && !visited[i]) {
				group_info[i] = 1;
			} else if(group_info[x] == 1 && !visited[i]) {
				group_info[i] = 0;
			}
			dfs(i);
		}

	}
}
