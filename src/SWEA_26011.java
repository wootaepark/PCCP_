import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class SWEA_26011 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long N = Long.parseLong(st.nextToken());
			long K = Long.parseLong(st.nextToken());

			long totalCount = 0;

			// X = a + b, Y = c + d
			// (a + b) = (c + d) + K 꼴

			// Y = c + d 가 가질 수 있는 범위는 2부터 2N까지
			for (long Y = 2; Y <= 2 * N; Y++) {
				long X = Y + K; // a + b 의 값

				// X도 반드시 2 ~ 2N 범위 안에 있어야 함
				if (X >= 2 && X <= 2 * N) {
					totalCount += getCount(X, N) * getCount(Y, N);
				}
			}

			System.out.println(totalCount);
		}
	}

	// 1~N 사이의 두 수의 합이 S가 되는 경우의 수를 구하는 함수
	private static long getCount(long S, long N) {
		if (S <= N + 1) {
			return S - 1;
		} else {
			return 2 * N - S + 1;
		}
	}
}