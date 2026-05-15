import java.util.*;
import java.io.*;

public class SWEA_9229 {
    private static int max = -1;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            max = -1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 상품의 개수
            int M = Integer.parseInt(st.nextToken()); // 무게 합 제한

            // N 개의 과자 봉지 무게 정보
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            solve(arr, 0, 0, 0, M);

            // 출력부
            System.out.println("#" + test_case + " " + max);
        }
    }

    private static void solve(int[] arr, int idx, int count, int currentSum, int M) {
        // 1. 무게 초과 시 즉시 종료
        if (currentSum > M) {
            return;
        }

        // 2. 2개를 모두 골랐을 때
        if (count == 2) {
            max = Math.max(max, currentSum);
            return;
        }

        // 3. 배열 끝까지 탐색했거나 더 이상 고를 수 없을 때
        if (idx == arr.length) {
            return;
        }

        // 현재 과자를 선택하는 경우
        solve(arr, idx + 1, count + 1, currentSum + arr[idx], M);

        // 현재 과자를 선택하지 않는 경우
        solve(arr, idx + 1, count, currentSum, M);
    }
}
