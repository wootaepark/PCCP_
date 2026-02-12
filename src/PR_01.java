import java.util.Scanner;

// https://www.acmicpc.net/problem/11720

public class PR_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 숫자 N개

		String sNum = sc.next();
		char[] cNum = sNum.toCharArray();
		int sum = 0;

		for (int i = 0; i < cNum.length; i++) {
			sum += Integer.parseInt(String.valueOf(cNum[i])); // cNum[i] - '0';
		}
		System.out.println(sum);
	}
}
