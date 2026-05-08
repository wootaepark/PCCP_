import java.util.*;

public class SWEA_2806 {
    private static int answer = 0;
    private static boolean[] colUsed;       // 열 체크
    private static boolean[] diag1;         // 우하향 대각선 체크 (row - col)
    private static boolean[] diag2;         // 좌하향 대각선 체크 (row + col)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            answer = 0;
            colUsed = new boolean[N];
            diag1 = new boolean[2 * N]; // r - c + N-1 // 우하향은 row - col 이 일정하다. (r - c 의 범위 : -(N-1) ~ (N-1))
            diag2 = new boolean[2 * N]; // r + c // 좌하향은 row + col 이 일정하다. (범위 : 0 ~ 2(N-1))

            dfs(0, N);
            System.out.println("#" + test_case + " " + answer);
        }
    }

    private static void dfs(int row, int N) {
        if (row == N) {
            answer++;
            return;
        }

        for (int col = 0; col < N; col++) {
            // 현재 위치에 퀸을 놓을 수 있는지 체크
            if (!colUsed[col] && !diag1[row - col + (N - 1)] && !diag2[row + col]) {


                colUsed[col] = diag1[row - col + (N - 1)] = diag2[row + col] = true;

                dfs(row + 1, N);

                colUsed[col] = diag1[row - col + (N - 1)] = diag2[row + col] = false;
            }
        }
    }
}
