import java.util.*;

public class BOJ11000 {

	// https://www.acmicpc.net/problem/11000

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] lectures = new int[N][2];

		for (int i = 0; i < N; i++) {
			lectures[i][0] = sc.nextInt(); // 시작 시간
			lectures[i][1] = sc.nextInt(); // 종료 시간
		}

		// 시작 시간을 기준으로 오름차순 정렬
		Arrays.sort(lectures, Comparator.comparingInt(a -> a[0]));

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(lectures[0][1]); // 종료 시간만 넣는다.

		for (int i = 1; i < N; i++) {

			if (pq.peek() <= lectures[i][0]) {
				pq.poll();
			}


			pq.offer(lectures[i][1]);
		}

		System.out.println(pq.size());
	}
}