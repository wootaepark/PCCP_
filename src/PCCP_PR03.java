import java.util.*;

class PCCP_PR03 {

	//https://school.programmers.co.kr/learn/courses/30/lessons/43164#

	static ArrayList<String> list = new ArrayList<>();
	static boolean useTickets[];

	public String[] solution(String[][] tickets) {
		useTickets = new boolean[tickets.length];

		dfs(0, "ICN", "ICN", tickets);

		Collections.sort(list); // 여러 경로 문자열 중에 사전순 가장 적은 거 정렬

		return list.get(0).split(" ");
	}

	static void dfs(int depth, String now, String path, String[][] tickets){ // path 는 여행 경로
		if (depth == tickets.length) {
			list.add(path);
			return;
		}

		for (int i = 0; i < useTickets.length; i++) { // 모든 경로를 찾는다. (알파벳 순서 상관 없이)
			if (!useTickets[i] && now.equals(tickets[i][0])) {
				useTickets[i] = true;
				dfs(depth+1, tickets[i][1], path + " " +tickets[i][1], tickets);
				useTickets[i] = false;
			}
		}
	}
}