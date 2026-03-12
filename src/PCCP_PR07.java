// 07 문제의 정답 코드
// https://school.programmers.co.kr/learn/courses/30/lessons/60058#
class PCCP_PR07 {
	public String solution(String p) {
		// 1. 입력이 빈 문자열인 경우, 빈 문자열 반환
		if (p.isEmpty()) return "";

		// 이미 올바른 문자열이라면 그대로 반환 (선택 사항이지만 안전함)
		if (isCorrect(p)) return p;

		return recursive(p);
	}

	// 알고리즘의 핵심 재귀 함수
	String recursive(String s) {
		if (s.isEmpty()) return "";

		// 2. u, v로 분리
		int index = getSplitIndex(s);
		String u = s.substring(0, index + 1);
		String v = s.substring(index + 1);

		// 3. u가 "올바른 괄호 문자열" 이라면
		if (isCorrect(u)) {
			// 3-1. v에 대해 재귀 수행 후 u에 붙여서 반환
			return u + recursive(v);
		}
		// 4. u가 "올바른 괄호 문자열"이 아니라면
		else {
			// 4-1 ~ 4-3 과정
			StringBuilder sb = new StringBuilder();
			sb.append("(");
			sb.append(recursive(v)); // 4-2. v에 대해 재귀 수행
			sb.append(")");

			// 4-4. u의 앞뒤 제거 후 나머지 괄호 방향 뒤집기
			for (int i = 1; i < u.length() - 1; i++) {
				if (u.charAt(i) == '(') sb.append(")");
				else sb.append("(");
			}
			// 4-5. 생성된 문자열 반환
			return sb.toString();
		}
	}

	// 균형잡힌 문자열 u의 끝 인덱스를 찾는 함수
	int getSplitIndex(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') count++;
			else count--;
			if (count == 0) return i;
		}
		return s.length() - 1;
	}

	// "올바른 괄호 문자열"인지 확인하는 함수
	boolean isCorrect(String s) {
		int count = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') count++;
			else {
				count--;
				if (count < 0) return false; // )가 (보다 먼저 나오면 바로 false
			}
		}
		return count == 0;
	}
}