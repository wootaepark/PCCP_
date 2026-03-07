import java.util.Scanner;

public class PR_38_1 {
	// https://www.acmicpc.net/problem/1456 (골드 5)
	// 답은 부합하지만 시간초과 발생

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();

		int count = 0;

		for (int i = 2; i<= (int)Math.pow(10,7); i++) {
			int dec = 2;
			if (isPrime(i)) {
				while (i <= (B / Math.pow(i, dec - 1))) {
					if (Math.pow(i, dec) >= A) {
						count++;
					}
					dec++;
				}

			}
		}
		System.out.println(count);

	}

	static boolean isPrime(int n) {
		if (n < 2)
			return false;
		if (n == 2)
			return true;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0 && n != i) {
				return false;
			}
		}
		return true;
	}
}
