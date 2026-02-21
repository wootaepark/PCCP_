import java.util.Scanner;

public class PR_37 {

	// https://www.acmicpc.net/problem/1929

	static int START;
	static int END;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		START = scanner.nextInt();
		END = scanner.nextInt();

		int[] arr = new int[END + 1];

		for (int i = 2; i <= END; i++) {
			arr[i] = i; // 수 채우기
		}

		for (int i = 2; i <= Math.sqrt(END); i++) {
			if (arr[i] == 0) {
				continue;
			}

			for (int j = i + i; j <= END; j = j + i) {
				arr[j] = 0;
			}
		}

		for (int i = START; i <= END; i++) {
			if (arr[i] != 0) {
				System.out.println(arr[i]);
			}
		}

	}
}
