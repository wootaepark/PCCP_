import java.io.*;

public class SWEA_4047 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			String input = br.readLine();

			int[][] arr = new int[5][14]; // 1 : S, 2 : D, 3 : H, 4 : C

			StringBuilder answer = new StringBuilder();

			for (int i = 0; i < input.length(); i += 3) {
				if (input.charAt(i) == 'S') {
					int num = Integer.parseInt(input.substring(i + 1, i + 3));
					if (arr[1][num] == 0) {
						arr[1][num]++;
					} else {
						answer.append("ERROR");
						break;
					}
				} else if (input.charAt(i) == 'D') {
					int num = Integer.parseInt(input.substring(i + 1, i + 3));
					if (arr[2][num] == 0) {
						arr[2][num]++;
					} else {
						answer.append("ERROR");
						break;
					}
				} else if (input.charAt(i) == 'H') {
					int num = Integer.parseInt(input.substring(i + 1, i + 3));
					if (arr[3][num] == 0) {
						arr[3][num]++;
					} else {
						answer.append("ERROR");
						break;
					}
				} else if (input.charAt(i) == 'C') {
					int num = Integer.parseInt(input.substring(i + 1, i + 3));
					if (arr[4][num] == 0) {
						arr[4][num]++;
					} else {
						answer.append("ERROR");
						break;
					}
				}

			}

			if (!answer.toString().equals("ERROR")) {
				for (int i = 1; i <= 4; i++) {
					int count = 13;
					for (int j = 1; j <= 13; j++) {
						if (arr[i][j] == 1) {
							count--;
						}
					}
					answer.append(count).append(" ");
				}
			}

			System.out.println("#" + test_case + " " + answer);

		}
	}
}