import java.util.Scanner;

public class PR_31 {

	// https://www.acmicpc.net/problem/1300
	// 일반적인 2중 for 문 사용 시 시간 초과 및 메모리 초과 실패


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 2차원 배열의 크기 N x N
		int k = sc.nextInt(); // 1차원 배열 변환시 arr[k] 의 값 // 1,2,3, ... k 번째



		long start = 1, end = k;
		long answer = -1;

		while (start <= end) {
			long mid = (start + end) / 2;
			long count = 0; // 중앙값 보다 작은 수

			for (int i = 1; i < N + 1; i++) {
				count += Math.min(mid / i, N);
			}

			if (count < k) {
				start = mid + 1;
			} else{
				answer = mid;
				end = mid - 1;
			}
		}
		System.out.println(answer);

	}
}
