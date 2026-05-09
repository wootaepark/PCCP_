
import java.util.*;
import java.io.*;


public class SWEA_1220
{
	public static void main(String[] args) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		// 입력에서 1은 N 극 2 는 S 극을 나타낸다.
		// 위쪽이 N 극 아래쪽이  S극 자석이 존재

		for(int test_case = 1; test_case <= T; test_case++)
		{

			// 1. 입력
			int size = Integer.parseInt(br.readLine());
			int[][] arr = new int[size][size];
			for(int i = 0; i<size; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<size; j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 2. 정답 도출 & 출력
			int answer = 0;
			for(int i = 0; i<size; i++){
				answer += getConflictCount(arr, i);
			}

			System.out.println("#" + test_case + " " + answer);


		}
	}

	// 특정 행방향(열)의 총 교착상태의 개수를 반환하는 메서드 제작하기
	private static int getConflictCount(int[][] arr, int col){ //
		int total = 0;
		boolean isNorth = false; // 현재 가장 아래 있는 극이 N 극인지 (S극 과 결합하면 flase 로 변화)
		for(int i = 0; i<arr.length; i++){
			if(arr[i][col] == 1){
				isNorth = true;
			}
			if(arr[i][col] == 2 && isNorth){
				isNorth = false;
				total ++;
			}
		}

		return total;
	}
}