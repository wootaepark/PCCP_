import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PR_34_1 {
	// https://www.acmicpc.net/problem/1744
	// 우선순위 큐를 이용한 예제 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 정렬 (큰 수 먼저 get)
		PriorityQueue<Integer> minPq = new PriorityQueue<>();

		int one = 0;
		int zero = 0; // 1과 0의 입력 개수

		for (int i = 0; i < N; i++) {
			int data = sc.nextInt();
			if (data > 1) {
				plusPq.add(data);
			} else if (data == 1) {
				one++;
			} else if (data == 0) {
				zero++;
			} else {
				minPq.add(data);
			}
		}

		int sum = 0;
		while (plusPq.size() > 1) {
			int first = plusPq.remove();
			int second = plusPq.remove();
			sum += (first * second);
		}
		if (!plusPq.isEmpty()) {
			sum += plusPq.peek();
		}

		while (minPq.size() > 1) {
			int first = minPq.remove();
			int second = minPq.remove();
			sum += (first * second);
		}
		if (!minPq.isEmpty()) {
			if (zero == 0) {
				sum += minPq.remove();
			}
		}
		sum += one;
		System.out.println(sum);

	}

}
