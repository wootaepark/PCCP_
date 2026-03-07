import java.util.Scanner;

public class PR_38 {

	// https://www.acmicpc.net/problem/1456 (골드 5)
	// 38_2 에 비해 메모리는 덜 먹는다. long 배열 에서 boolean 배열로 변경했기 때문

	static boolean[] isNotPrime;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();

		isNotPrime = new boolean[(int)Math.sqrt(B) + 1]; // ex) B = 1000  이면 index 범위는 0부터 31 (size = 32)

		for (int i = 2; i < Math.sqrt(isNotPrime.length); i++) {
			if (isNotPrime[i]) {
				continue;
			}

			for (int j = i + i; j < isNotPrime.length; j = j + i) {
				isNotPrime[j] = true; // 소수가 아닌경우
			}
		}

		int count = 0;
		for (int i = 2; i < isNotPrime.length; i++) {
			int expo = 2;
			if (!isNotPrime[i]) { // 소수 인 경우
				while ((double)i <= (double)B / Math.pow(i, expo - 1)) {
					if ((double)i >= (double)A / Math.pow(i, expo - 1)) {
						count++;
					}
					expo++;
				}

			}

		}

		System.out.println(count);

	}

}
