import java.util.*;


class PCCP_PR01_01 {

	//https://school.programmers.co.kr/learn/courses/19344/lessons/242259
	// 이 코드의 경우 모든 테스트는 통과했지만 효율성 측면에서 0점이다.
	// bfs 호출 빈도가 너무 잦기 때문


	static int[] dx = {1, 0, -1, 0}; // 우, 하, 좌, 상 순서
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;

	public int solution(int[][] land) {

		int answer = 0;
		Map<Integer, Integer> map = new HashMap<>(); // 그룹 정보 담을 곳

		visited = new boolean[land.length][land[0].length]; // 방문 여부 판단해서 해당 그룹의 수 파악

		for(int j = 0; j < land[0].length; j++){ // 열 방향으로 탐색
			int tmp = 0;
			visited = new boolean[land.length][land[0].length];
			for(int i = 0; i< land.length; i++){ // 행 방향 탐색 (아래로)
				if(!visited[i][j]){
					tmp += bfs(i,j,land);
				}
			}
			answer = Math.max(answer, tmp);

		}



		return answer;
	}



	static int bfs(int r, int c, int[][] land){


		if(land[r][c] == 0) return 0;

		Queue<int[]> queue = new LinkedList<>();
		int count = 1;

		queue.offer(new int[] {r, c});
		visited[r][c] = true;

		while(!queue.isEmpty()){

			int[] now = queue.poll();

			for(int i = 0 ; i < 4; i++){
				int row = now[0] + dy[i];
				int col = now[1] + dx[i];

				if(row>= 0 && col >=0 && row < land.length && col < land[0].length && !visited[row][col] && land[row][col] == 1){ // 연결된 상태
					visited[row][col] = true;
					queue.add(new int[] {row, col});
					count ++;
				}
			}

		}



		return count;


	}
}