import java.util.*;
import java.io.*;


public class SWEA_1861 {
    private static int[] dRow = {0, 1, 0, -1}, dCol = {1, 0, -1, 0}; // 우, 하, 좌, 상
    private static int answer, answerNumber = Integer.MAX_VALUE, size;
    private static int[][] dp, arr;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            answer = 0;
            size = Integer.parseInt(br.readLine());
            arr = new int[size][size];
            dp = new int[size][size];

            for (int i = 0; i < size; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < size; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int currentDist = solve(i, j);

                    // 케이스 1: 더 긴 경로를 찾은 경우 (무조건 갱신)
                    if (currentDist > answer) {
                        answer = currentDist;
                        answerNumber = arr[i][j];
                    }
                    // 케이스 2: 경로는 같은데, 방 번호가 더 작은 경우 (문제 조건)
                    else if (currentDist == answer) {
                        if (arr[i][j] < answerNumber) {
                            answerNumber = arr[i][j];
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + answerNumber + " " + answer);


        }
    }

    private static int solve(int r, int c) {

        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        dp[r][c] = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r + dRow[i];
            int nc = c + dCol[i];

            if (nr >= 0 && nc >= 0 && nr < size && nc < size) {
                if (arr[nr][nc] == arr[r][c] + 1) {
                    dp[r][c] = solve(nr, nc) + 1;
                    break;
                }
            }
        }
        return dp[r][c];
    }
}
