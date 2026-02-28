import java.util.Arrays;
import java.util.Scanner;

public class PR_29 {
	static int[] arr;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 데이터 개수

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		int M = sc.nextInt(); // 찾아야 할 숫자 개수
		for (int i = 0; i < M; i++) {
			System.out.println(binarySearch(sc.nextInt(), arr));
		}
	}

	static int binarySearch(int target, int[] arr) {

		int start = 0, end = arr.length - 1;
		boolean found = false;

		while (end >= start) {

			int mid = (start + end) / 2;
			if (arr[mid] == target) {
				found = true;
				break;
			}

			else if (arr[mid] > target) {
				end = mid - 1;

			}
			else {
				start = mid +1 ;
			}
		}
		return found ? 1 : 0;

	}
}
