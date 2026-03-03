import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PR_34 {

	// https://www.acmicpc.net/problem/1744
	// 우선순위 큐 말고 정렬 후 조건에 맞게 stack, queue 를 사용함

	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;

		Queue<Integer> negative = new LinkedList<>();
		int zero = 0;
		int one = 0;
		Stack<Integer> positive = new Stack<>();

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			arr[i] = n;
		}
		Arrays.sort(arr);

		for (int i = 0; i < N; i++) {
			if (arr[i] == 0) {
				zero++;
			} else if (arr[i] == 1) {
				one++;
			} else if (arr[i] < 0) {
				negative.offer(arr[i]);
			} else {
				positive.push(arr[i]);
			}
		}

		// 1 처리
		sum += one;

		// 양수 처리
		while (positive.size() > 1) {
			int n1 = positive.pop();
			int n2 = positive.pop();
			sum += (n1 * n2);
		}
		if (!positive.isEmpty()) {
			sum += positive.pop();
		}

		// 음수 처리
		while (negative.size() > 1) {
			int n1 = negative.poll();
			int n2 = negative.poll();
			sum += (n1 * n2);
		}
		if (!negative.isEmpty()) {
			if (zero == 0) {
				sum += negative.poll();
			}
		}
		System.out.println(sum);

	}

}
