class PCCP_PR_02{


	// https://school.programmers.co.kr/learn/courses/30/lessons/42860# (lv2)

	public int solution(String name) {
		int answer = 0;
		int len = name.length();
		int move = len - 1; // 초기값: 그냥 오른쪽으로 쭉 가는 경우

		for (int i = 0; i < len; i++) {
			// 1. 상하 이동 (알파벳 변경)
			char c = name.charAt(i);
			answer += Math.min(c - 'A', 'Z' - c + 1);

			// 2. 좌우 이동 (연속된 A 건너뛰기)
			int next = i + 1;
			// 내 다음부터 연속된 'A'가 어디까지 이어지는지 확인
			while (next < len && name.charAt(next) == 'A') {
				next++;
			}
			// 아래 로직이 핵심이다. (이거 찾는데 애먹음)
			move = Math.min(move, Math.min(i * 2 + (len - next), (len - next) * 2 + i));
		}

		return answer + move;
	}
}