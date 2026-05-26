import java.io.*;

public class SWEA_9658 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String input = br.readLine().trim();

			int value_i = Integer.parseInt(input.substring(0, 3));
			double value = value_i / 100.0;

			int count = input.length() - 1;

			// 내가 이전에 푼 코드는 999만 처리하고 998, 997 과 같은 건 9.9 로
			// 처리 되어서 오답
			String formattedValue = String.format("%.1f", value);

			if (formattedValue.equals("10.0")) {
				formattedValue = "1.0";
				count++;
			}

			System.out.println("#" + test_case + " " + formattedValue + "*10^" + count);
		}
	}
}