import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PR_35_1 {
	// https://www.acmicpc.net/problem/1931 (골드 5)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2]; // 시작, 종료 정보 취합
		for(int i = 0; i<N; i++){
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}

		Arrays.sort(arr, new Comparator<int[]>() { // 람다 식으로 바꿀 수도 있음
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]){
					return o1[0] - o2[0]; // o1 오름차순
				}
				return o1[1] - o2[1];
			}
		});

		int count = 0;
		int end = -1;
		for (int i = 0; i < N; i++) {
			if(arr[i][0] >= end){
				end = arr[i][0];
				count++;
			}
		}
		System.out.println(count);


	}
}
