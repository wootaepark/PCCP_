import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PR_03 {
	// https://www.acmicpc.net/problem/11659

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 데이터의 개수
		int Q = Integer.parseInt(st.nextToken()); // 질의 개수

		long[] sum = new long[N + 1]; // 합 데이터 저장용

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			long result = sum[end] - sum[start - 1];
			System.out.println(result);
		}

	}
}
