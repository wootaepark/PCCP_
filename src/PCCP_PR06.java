public class PCCP_PR06 {

	// 문제 : https://school.programmers.co.kr/learn/courses/15008/lessons/121685
	// PCCP 3번 수준 문제

	public String[] solution(int[][] queries) {
		String[] result = new String[queries.length];
		for(int i = 0; i < queries.length; i++)
			result[i] = queries[i][0] == 1 ? "Rr" : recursive(queries[i][0], queries[i][1]);
		return result;
	}

	private String recursive(int n, int p) {
		int cnt = (int) Math.pow(4, n - 1);
		if(p <= cnt / 4) return "RR";
		if(p > cnt / 4 * 3) return "rr";
		if(n == 2) return "Rr";

		if(p > cnt / 4 && p <= cnt / 2)
			return recursive(n - 1, p - cnt / 4);

		return recursive(n - 1, p - cnt / 2);
	}
}
