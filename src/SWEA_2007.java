import java.io.*;


class Solution
{
	public static void main(String[] args) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());


		for(int test_case = 1; test_case <= T; test_case++)
		{
			String str = br.readLine();

			int n = getPatternLen(str);

			System.out.println("#" + test_case + " " + n);

		}
	}

	private static int getPatternLen(String str) {
		for (int len = 1; len <= 10; len++) {
			boolean isMatch = true;
			String pattern = str.substring(0, len);

			// 문제 자체의 요구 조건이 애매해서 이런 판단로직을 추가하였다. (최대 10개의 길이이고 i + 1 이 3이 넘어가면 안되기 때문에 범위 설정)
			for (int i = 1; i < 3; i++) {
				if (!pattern.equals(str.substring(len * i, len * (i + 1)))) {
					isMatch = false;
					break;
				}
			}

			if (isMatch) return len; // 모든 검사를 통과하면 그게 정답
		}
		return 10;
	}
}