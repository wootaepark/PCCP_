import java.util.*;
import java.io.*;

public class SWEA_1486 {

    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 사람 인원 수
            int B = Integer.parseInt(st.nextToken()); // 선반의 높이

            int sum = 0;

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }
            answer = sum;

            dfs(arr, 0, 0, B);

            System.out.println("#" + test_case + " " + (answer - B));


        }
    }

    private static void dfs(int[] arr, int idx, int sum, int target) {
        // 조건 만족 시 최소 합 갱신
        if (sum >= target) {
            answer = Math.min(answer, sum);
            return;
        }

        // idx부터 시작하여 조합 탐색 (중복 제거)
        for (int i = idx; i < arr.length; i++) {
            dfs(arr, i + 1, sum + arr[i], target);
        }
    }
}
