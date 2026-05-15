import java.util.*;
import java.io.*;

public class SWEA_3307 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int answer = 0;
            int N = Integer.parseInt(br.readLine()); // 원소의 개수
            long[] arr = new long[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                arr[i] = Long.parseLong(st.nextToken()); // 1 부터 N 까지 맞춰서 입력
            }

            int[] dp = new int[N + 1];
            Arrays.fill(dp, 1);
            for (int i = 2; i < N + 1; i++) {
                for (int j = 1; j < i; j++) {
                    if (arr[i] >= arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            Arrays.sort(dp);
            answer = dp[N];
            System.out.println("#" + test_case + " " + answer);


        }
    }


}
