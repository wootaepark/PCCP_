import java.util.Scanner;

public class PR_24 {

	// https://www.acmicpc.net/problem/2023

	static int N;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt(); // 자릿수
		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);

	}

	static void DFS(int value, int position) { // 숫자, 자릿수
		if (isPrime(value) && position == N) {
			System.out.println(value);
			return;
		}

		// ------------------------------ 1 ----------------------------------
		// if (!isPrime(value)) {
		// 	return; // 사실 이걸 쓰려고 tmp 값에 value 값을 임시 저장 (없애도 가능함)
		// }

		// 위 코드 주석 해제된 경우 아래 코드

		// int tmp = value;
		// for (int i = 1; i <= 9; i += 2) {
		// 	value = value * 10 + i;
		// 	DFS(value, position + 1);
		// 	value = tmp;
		// }

		// ------------------------------ 2 ----------------------------------

		for (int i = 1; i <= 9; i += 2) { // 더 최적화 하려면 끝자리 5도 제외 할 수 있다.
			if (isPrime(value * 10 + i)) {
				DFS(value * 10 + i, position + 1);
			}

		}

	}

	static boolean isPrime(int value) {
		if (value == 1)
			return false;
		if (value == 2)
			return true;
		if (value % 2 == 0)
			return false;

		for (int i = 3; i * i <= value; i += 2) {
			if (value % i == 0)
				return false; // 홀수만 본다는 mind
		}

		return true;

	}
}
