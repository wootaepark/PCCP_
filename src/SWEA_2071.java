import java.io.*;
import java.util.StringTokenizer;


class SWEA_2071
	// https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
{
	public static long SUM;
	public static void main(String[] args) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());


		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());

			SUM = 0;

			for(int i=0; i<10; i++)
			{
				SUM += Long.parseLong(st.nextToken());
			}

			double avg = Math.round(SUM / 10.0)  ;
			System.out.println("#"+ test_case +" " + String.format("%.0f",avg)); // 이거 포맷 정도는 알아두자



		}
	}
}