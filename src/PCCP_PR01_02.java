import java.util.*;
class PCCP_PR01_02 {


	//https://school.programmers.co.kr/learn/courses/19344/lessons/242259
	// 내가 푼 코드를 바탕으로 한 문제 정답이다. (효율 100, 정확 100)

	static int[] dx = {1, 0, -1, 0}; // 우, 하, 좌, 상 순서
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	static int[] colSums;

	public int solution(int[][] land) {

		int answer = 0;
		visited = new boolean[land.length][land[0].length];
		colSums = new int[land[0].length];

		for(int i = 0; i < land.length; i++){
			for(int j = 0; j< land[0].length; j++){
				if(land[i][j] == 1 && !visited[i][j]){
					bfs(i, j, land);
				}
			}
		}

		Arrays.sort(colSums);
		answer = colSums[land[0].length -1];



		return answer;
	}



	static void bfs(int r, int c, int[][] land){

		Set<Integer> columns = new HashSet<>();
		columns.add(c);


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
					columns.add(col);
					count ++;
				}
			}


		}

		for(int i : columns){
			colSums[i] += count;
		}




	}
}