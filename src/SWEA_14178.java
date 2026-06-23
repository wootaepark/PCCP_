import java.util.*;
import java.io.*;

public class SWEA_14178 {

	//https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AX_N3oSqcyUDFARi&categoryId=AX_N3oSqcyUDFARi&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=6#

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 길이
			int D = Integer.parseInt(st.nextToken()); // 범위

			int len = D * 2 + 1; // 총 뿌릴 수 있는 범위

			int answer = 1;
			if (N > len) {
				answer = N / len;

				if (N % len != 0) { // 나누어 떨어지지 않는 경우 1개가 더 필요하다.
					answer += 1;
				}
			}

			System.out.println("#" + test_case + " " + answer);

		}
	}
}