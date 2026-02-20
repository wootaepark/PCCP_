import java.io.IOException;
import java.util.Scanner;


public class PR_36 {

	// https://www.acmicpc.net/problem/1541

	static int answer = 0;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String content = sc.nextLine();


		String[] terms = content.split("-");
		for (int i = 0; i < terms.length; i++) {
			if(i == 0) answer += mySum(terms[i]);
			else answer -= mySum(terms[i]);
		}
		System.out.println(answer);

	}

	public static int mySum(String s){
		int sum = 0;

		String[] strArr = s.split("\\+");
		for(String str : strArr){
			sum += Integer.parseInt(str);
		}
		return sum;
	}
}
