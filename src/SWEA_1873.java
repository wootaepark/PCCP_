
import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AV5LyE7KD2ADFAXc&categoryId=AV5LyE7KD2ADFAXc&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=2

class SWEA_1873
{
	static int hPos, wPos;
	public static void main(String[] args) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;


		for(int test_case = 1; test_case <= T; test_case++)
		{

			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken()); // 높이
			int W = Integer.parseInt(st.nextToken()); // 너비

			String[][] arr = new String[H][W];

			for(int i = 0; i<H; i++){
				String[] line = br.readLine().split("");
				for(int j = 0; j<W; j++){
					if(line[j].equals("<") || line[j].equals("v") || line[j].equals(">") || line[j].equals("^")){
						hPos = i;
						wPos = j;
					}
					arr[i][j] = line[j];
				}
			}

			int size = Integer.parseInt(br.readLine());
			String[] inputs = br.readLine().split("");

			for(int i = 0; i<size; i++){
				play(arr, inputs[i]);
			}


			System.out.print("#" + test_case + " ");

			for(int i = 0; i<H; i++){
				StringBuilder sb = new StringBuilder();
				for(int j= 0; j<W; j++){
					sb.append(arr[i][j]);
				}
				System.out.println(sb.toString());

			}

		}
	}

	private static void play(String[][] arr, String input){

		if(input.equals("S")){
			shootingPlay(arr);
		}
		else if(input.equals("U")){
			arr[hPos][wPos] = "^";
			if(hPos-1 >= 0 &&arr[hPos-1][wPos].equals(".")){
				arr[hPos][wPos] = ".";
				arr[--hPos][wPos] = "^";
			}
		}
		else if(input.equals("D")){
			arr[hPos][wPos] = "v";
			if(hPos+1 < arr.length && arr[hPos+1][wPos].equals(".")){
				arr[hPos][wPos] = ".";
				arr[++hPos][wPos] = "v";
			}
		}
		else if(input.equals("R")){
			arr[hPos][wPos] = ">";
			if(wPos+1 < arr[0].length && arr[hPos][wPos+1].equals(".")){
				arr[hPos][wPos] = ".";
				arr[hPos][++wPos] = ">";
			}
		}
		else if(input.equals("L")){
			arr[hPos][wPos] = "<";
			if(wPos-1 >=0 && arr[hPos][wPos-1].equals(".")){
				arr[hPos][wPos] = ".";
				arr[hPos][--wPos] = "<";
			}
		}


	}
	private static void shootingPlay(String[][] arr){
		if(arr[hPos][wPos].equals("<")){
			int tmp = wPos;
			while(tmp>0){
				tmp--;
				if(arr[hPos][tmp].equals("*")){
					arr[hPos][tmp] = ".";
					break;
				}
				if(arr[hPos][tmp].equals("#")){
					break;
				}

			}
		}
		else if(arr[hPos][wPos].equals(">")){
			int tmp = wPos;
			while(tmp<arr[0].length-1){
				tmp++;
				if(arr[hPos][tmp].equals("*")){
					arr[hPos][tmp] = ".";
					break;
				}
				if(arr[hPos][tmp].equals("#")){
					break;
				}

			}
		}
		else if(arr[hPos][wPos].equals("v")){
			int tmp = hPos;
			while(tmp<arr.length-1){
				tmp++;
				if(arr[tmp][wPos].equals("*")){
					arr[tmp][wPos] = ".";
					break;
				}
				if(arr[tmp][wPos].equals("#")){
					break;
				}

			}
		}
		else if(arr[hPos][wPos].equals("^")){
			int tmp = hPos;
			while(tmp>0){
				tmp--;
				if(arr[tmp][wPos].equals("*")){
					arr[tmp][wPos] = ".";
					break;
				}
				if(arr[tmp][wPos].equals("#")){
					break;
				}

			}
		}


	}


}