public class PCCP_PR05 {

	// 문제 : https://school.programmers.co.kr/learn/courses/15008/lessons/121684
	// PCCP 2번 수준 문제


	static int max_stat = 0;
	static boolean[] used_students;
	public int solution(int[][] ability) {

		// dfs(현재 결정 중인 종목 번호, 현재까지 사용된 학생들의 목록)

		used_students = new boolean[ability.length];

		dfs(0,used_students, ability, 0);


		return max_stat;

	}

	void dfs(int event, boolean[] used_students, int[][] ability, int max_score){

		if(event > ability[0].length-1){
			max_stat = Math.max(max_stat, max_score);
			return;
		}

		for(int i = 0; i<ability.length; i++){
			if(!used_students[i]){
				used_students[i] = true;
				max_score += ability[i][event];
				dfs(event+1, used_students, ability, max_score);
				max_score -= ability[i][event];
				used_students[i] = false;
				
				// 비트 마스크로도 풀 수 있음 (from GEMINI)

			}

		}





	}
}
