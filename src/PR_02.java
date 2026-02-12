import java.util.Arrays;
import java.util.Scanner;

public class PR_02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // 시험을 본 과목의 수
		int[] A = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = scanner.nextInt();
		}

		long sum = 0;
		long max = 0;
		for (int i = 0; i < N; i++) {
			if(A[i] > max) {
				max = A[i];
			}
			sum += A[i];
		}
		System.out.println(sum * 100.0 / max / N);

	}
}
