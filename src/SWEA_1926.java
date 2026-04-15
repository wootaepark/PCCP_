import java.util.Scanner;

public class SWEA_1926 {

	// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PTeo6AHUDFAUq&categoryId=AV5PTeo6AHUDFAUq&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=JAVA&select-1=2&pageSize=10&pageIndex=1
	// (D2 문제)

	public static void main(String[] args) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{

			print369(test_case);

		}
	}

	private static void print369(int number){

		int count =get369Count(number);

		if(count > 0){
			for(int i = 0; i<count; i++){
				System.out.print("-");
			}
			System.out.print(" ");
		}
		else{
			System.out.print(number + " ");
		}
	}

	private static int get369Count(int number){
		int count = 0;
		String[] value = String.valueOf(number).split("");

		for(String s : value){
			if(s.equals("3") || s.equals("6") || s.equals("9")){
				count ++;
			}
		}
		return count;
	}


}
