import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&problemLevel=4&contestProbId=AV5Pq-OKAVYDFAUq&categoryId=AV5Pq-OKAVYDFAUq&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=JAVA&select-1=4&pageSize=10&pageIndex=2
// 배열을 올바른 for 문을 이용해서 출력하는 문제 D2 수준 치고는 조금은 까다로움

public class SWEA_1961 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = Integer.parseInt(br.readLine()); // 사이즈 입력

			int[][] arr = new int[N][N];

			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.println("#" + test_case);

			for (int i = 0; i < N; i++) { //N개의 줄을 출력

				for (int j = N - 1; j >= 0; j--) {
					System.out.print(arr[j][i]);
				}
				System.out.print(" ");

				for (int j = N - 1; j >= 0; j--) {
					System.out.print(arr[N - i - 1][j]);
				}
				System.out.print(" ");

				for (int j = 0; j < N; j++) {
					System.out.print(arr[j][N - 1 - i]);
				}

				System.out.println();
			}

		}
	}
}