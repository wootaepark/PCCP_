import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PR_30 {

	static int max = 0;

	// https://www.acmicpc.net/problem/2343

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 레슨 수
		int M = Integer.parseInt(st.nextToken()); // 블루레이 개수

		int[] arr = new int[N]; // 레슨 길이 (레슨 순서대로)
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int end = getSum(0, N - 1, arr);
		int start = max;
		int answer = 0;

		while (start <= end) {
			int mid = (start + end) / 2;

			int sum = 0, count = 0; // 현재 합과 사용한 블루레이 개수
			for (int i = 0; i < N; i++) {
				sum += arr[i];
				if (sum > mid) {
					i--;
					count++;
					sum = 0;
				}
			}
			if(sum != 0){
				count++;
			}
			if (count <= M) {
				answer = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(answer);

	}

	private static int getSum(int startIndex, int endIndex, int[] arr) {
		int sum = 0;
		for (int i = startIndex; i <= endIndex; i++) {
			max = Math.max(max, arr[i]);
			sum += arr[i];
		}
		return sum;
	}
}
