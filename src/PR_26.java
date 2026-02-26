import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PR_26 {

	//https://www.acmicpc.net/problem/1260

	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> arr;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 노드 개수
		int M = Integer.parseInt(st.nextToken()); // 에지 개수

		int V = Integer.parseInt(st.nextToken()); // 시작 점
		visited = new boolean[N + 1]; // 노드가 1부터니까 편의성 위함

		arr = new ArrayList<>();

		for (int i = 0; i < N + 1; i++) {
			// 인접 노드 정보 초기화
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		for (int i = 0; i < N + 1; i++) {
			Collections.sort(arr.get(i));
			// 정렬
		}
		DFS(V);
		System.out.println();

		Arrays.fill(visited, false);
		BFS(V);

		// 입력부
	}

	static void DFS(int node) {
		if (visited[node])
			return;

		visited[node] = true;

		System.out.print(node + " ");

		for (int i : arr.get(node)) {
			DFS(i);
		}
	}

	static void BFS(int node) {

		visited[node] = true;
		q.offer(node);

		while (!q.isEmpty()) {
			int cur = q.poll();

			System.out.print(cur + " ");

			for(int i : arr.get(cur)){
				if(!visited[i]){
					visited[i] = true;
					q.offer(i);
				}
			}
		}

	}
}
