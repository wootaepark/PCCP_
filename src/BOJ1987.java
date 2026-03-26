import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ1987 {

	//https://www.acmicpc.net/problem/1987


	static char[][] alphabet;
	static int[] dc = {1, 0, -1, 0};
	static int[] dr = {0, 1, 0, -1};
	static int answer = 1, count = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		alphabet = new char[row][col];

		for (int i = 0; i < row; i++) {
			alphabet[i] = sc.next().toCharArray();
		}

		// 입력부 종료

		Set<Character> charSet = new HashSet<>();
		dfs(0, 0, alphabet, charSet);
		System.out.println(answer);

	}

	private static void dfs(int row, int col, char[][] arr,
		Set<Character> charSet) { // 시작점, 알파벳 배열, 방문 배열

		count++;
		charSet.add(arr[row][col]);

		for (int i = 0; i < 4; i++) {
			int newRow = row + dr[i];
			int newCol = col + dc[i];

			if (newRow >= 0 && newCol >= 0 && newRow < arr.length && newCol < arr[0].length
				&& !charSet.contains(arr[newRow][newCol])) {

				dfs(newRow, newCol, arr,  charSet);
				count--;
				charSet.remove(arr[newRow][newCol]);

			}

		}
		answer = Math.max(answer, count);
	}
}
