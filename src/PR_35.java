
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PR_35 {

	// https://www.acmicpc.net/problem/1931 (골드 5)
	// PriorityQueue 이용

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 회의 개수

		PriorityQueue<int[]> timeQueue = new PriorityQueue<>((a, b) -> {
			if (a[1] == b[1]) {
				return Integer.compare(a[0], b[0]); // 종료 시간이 같으면 시작 시간 오름차순
			}
			return Integer.compare(a[1], b[1]); // 기본은 종료 시간 오름차순
		});

		for (int i = 0; i < N; i++) {
			int startTime = sc.nextInt();
			int endTime = sc.nextInt();

			timeQueue.add(new int[] {startTime, endTime});
		}

		// 첫번째 회의 시간
		int[] initialTime = timeQueue.remove();
		int endTime = initialTime[1];
		int answer = 1;

		while (!timeQueue.isEmpty()) {
			int[] time = timeQueue.remove();
			if (time[0] >= endTime) {
				answer++;
				endTime = time[1];
			}

		}
		System.out.println(answer);
	}
}
