import java.util.Scanner;

public class PR_38_2 {
	// https://www.acmicpc.net/problem/1456
	// 정답 코드
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long Min = sc.nextLong();
		long Max = sc.nextLong();
		long[] A = new long[10000001]; // 1 ~ 10000000 저장

		for (int i = 2; i < A.length; i++) {
			A[i] = i;
		}
		for (int i = 2; i <= Math.sqrt(A.length); i++) { // 배수의 대칭성
			// 위 조건을 루트 안씌워도 시간초과 없이 잘 되기는 하지만 루트 씌우는게 더 좋음
			if (A[i] == 0)
				continue;
			for (int j = i + i; j < A.length; j = j + i) { // 배수 지우기
				A[j] = 0;
			}

		}

		int count = 0;
		for (int i = 2; i < 10000001; i++) {
			long tmp = A[i];
			if (A[i] != 0) { // 소수 인경우
				while ((double)A[i] <= (double)Max / tmp) {
					if ((double)A[i] >= (double)Min / tmp) {
						count++;
					}
					tmp = tmp * A[i];
				}
			}
		}
		System.out.println(count);
	}
}
