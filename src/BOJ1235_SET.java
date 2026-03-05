import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ1235_SET { // set 을 이용하여 문제 해결 하기
	//https://www.acmicpc.net/problem/1235

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Set<String> stringSet = new HashSet<>();
		int answer = 0;

		String[] arr = new String[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}

		for (int i = arr[0].length() - 1; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				stringSet.add(arr[j].substring(i));
			}

			if (stringSet.size() == N) {
				answer = arr[0].length() - i;
				break;
			}
			stringSet.clear();


		}

		System.out.println(answer);

	}
}
