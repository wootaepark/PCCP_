import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class PR_46 {

	// 그래프 워밍업 문제
	// https://www.acmicpc.net/problem/18352 (실버 2)
	// 책 코드와 달리 입출력 최적화를 통한 메모리 및 시간 단축

	static List<List<Integer>> arr; // 현재 도로 가중치는 1로 일정
	// 1번 도시와 2번 도시, 1번 도시와 3번 도시가 이어진 경우
	// 1 -> {2, 3}
	static int[] visited;

	public static void main(String[] args) throws IOException {

		// Scanner 대신 BufferedReader 사용으로 입력 최적화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		visited = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			visited[i] = -1;
		}

		arr = new ArrayList<>();

		// 0 (사용 x) 부터 N 번 까지 접근 가능하도록
		for (int i = 0; i <= N; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr.get(start).add(end);

		}

		// 입력부 종료
		bfs(X);
		StringBuilder sb = new StringBuilder();
		
		
		// 출력 최적화
		for (int i = 1; i <= N; i++) {
			if (visited[i] == K) {
				sb.append(i).append("\n");
			}
		}
		if (sb.isEmpty()) { // 백준 제출시에는 sb.length() == 0 으로 제출함 (java version 차이)
			sb.append(-1);
		}
		System.out.println(sb);

	}

	private static void bfs(int start) {

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start]++;

		while (!queue.isEmpty()) {
			int nowCity = queue.poll();
			List<Integer> tmp = arr.get(nowCity);
			for (int i : tmp) {
				if (visited[i] == -1) {
					visited[i] = visited[nowCity] + 1;
					queue.offer(i);
				}
			}
		}
	}
}
