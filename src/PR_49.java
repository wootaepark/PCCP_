import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PR_49 {

	// https://www.acmicpc.net/problem/2251

	static int[] sender = {0, 0, 1, 1, 2, 2};
	static int[] receiver = {1, 2, 0, 2, 0, 1};
	static boolean[][] visited; // A, B 의 무게만 있으면 C 의 무게가 고정된다.
	static boolean[] answer;
	static int[] now;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		now = new int[3]; // A, B, C 물의 양을 저장
		now[0] = sc.nextInt();
		now[1] = sc.nextInt();
		now[2] = sc.nextInt();

		visited = new boolean[201][201]; // a 최대 200L, b 최대 200L
		answer = new boolean[201]; // 정답인(true) 상태 == c 의 물상태

		BFS();
		for (int i = 0; i < answer.length; i++) {
			if (answer[i]) //
				System.out.print(i + " ");
		}
	}

	private static void BFS() {
		Queue<AB> q = new LinkedList<>();
		q.add(new AB(0, 0));
		visited[0][0] = true;
		answer[now[2]] = true;

		while (!q.isEmpty()) {
			AB p = q.poll();
			int A = p.A;
			int B = p.B;
			int C = now[2] - A - B;
			for (int k = 0; k < 6; k++) {
				int[] next = {A, B, C}; // 다음 상태
				next[receiver[k]] += next[sender[k]];
				next[sender[k]] = 0;

				if (next[receiver[k]] > now[receiver[k]]) { // 물이 넘치는 경우
					// 초과 한 만큼 다시 이전 물통에 넣어줌
					next[sender[k]] = next[receiver[k]] - now[receiver[k]];
					next[receiver[k]] = now[receiver[k]];

				}

				if (!visited[next[0]][next[1]]) { // A, B 의 물의 양을 이용해서 방문 배열 체크
					visited[next[0]][next[1]] = true;
					q.add(new AB(next[0], next[1]));
					if (next[0] == 0) { // A의 물의 양이 0 일때 C 의 물 무게로 정답배열 업데이트
						answer[next[2]] = true;
					}
				}
			}

		}
	}
}

class AB {
	int A;
	int B;

	public AB(int a, int b) {
		this.A = a;
		this.B = b;
	}
}
