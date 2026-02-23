import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PR_23 {

	// https://www.acmicpc.net/problem/11724
	static ArrayList<Integer>[] A; // 그래프 데이터 저장
	static boolean[] visited; // 방문 여부 확인 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 노드의 개수
		int m = Integer.parseInt(st.nextToken()); // 에지의 개수

		A = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < n + 1; i++) { // 인접 리스트 초기화
			A[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s); // 양방향 에지이므로 약쪽에 에지 추가
		}

		int count = 0;
		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) {
				count++;
				DFS(i);
			}
		}
		System.out.println(count);
	}

	static void DFS(int v) {
		if (visited[v]) {  // 이 문제 한정으로는 이 조건문 없어도 정답 (이 조건을 통해 return 되는 경우가 없다.)
			return;
		}
		visited[v] = true;
		for (int i : A[v]) {
			if (!visited[i]) {
				DFS(i);
			}
		}
	}
}
