import java.util.Scanner;

public class BOJ1235 {
	//https://www.acmicpc.net/problem/1235

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 학생 수
		int answer = 0;

		String[] arr = new String[N];

		// 학생 번호 입력
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}

		boolean flag = false; // 같은 것이 있는 경우 true 로 바뀜
		for (int i = arr[0].length() - 1; i >= 0; i--) { // 마지막 자리수 부터 1개씩 늘려가면서
			flag = false;
			for (int j = 0; j < N - 1; j++) {
				String tmp = arr[j].substring(i);
				for (int k = j + 1; k < N; k++) {
					if (tmp.equals(arr[k].substring(i))) {
						flag = true;
						break;
					}

				}
				if (flag)
					break;

			}
			if (!flag) {
				answer = arr[0].length() - i;
				break;
			}

		}
		System.out.println(answer);
	}
}
