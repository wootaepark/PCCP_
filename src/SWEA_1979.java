
import java.util.*;
import java.io.*;


public class SWEA_1979 { // 여기서는 상하좌우 다 살폈지만 하단, 우측 만 살피면 마지막 "/2" 할 필요 x
    private static int[] dRow = {0, 1, 0, -1}, dCol = {1, 0, -1, 0};
    private static int answer = 0;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 판의 크기
            int K = Integer.parseInt(st.nextToken()); // 문자의 크기

            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    solve(arr, i, j, K);
                }
            }

            System.out.println("#" + test_case + " " + answer / 2); // 방향 고려


        }
    }

    private static void solve(int[][] arr, int row, int col, int len) {
        if (arr[row][col] == 0) {
            return;
        }

        // 상하좌우 방향 보기
        for (int i = 0; i < 4; i++) {
            if (!isAvailable(arr, row - dRow[i], col - dCol[i])) { // 뒤가 막혀있는 경우
                for (int j = 1; j <= len; j++) {
                    int nr = row + dRow[i] * j;
                    int nc = col + dCol[i] * j;
                    if (!isAvailable(arr, nr, nc)) {
                        if (j == len) {
                            answer++;
                        } else {
                            break;
                        }
                    }

                }
            }


        }

    }

    private static boolean isAvailable(int[][] arr, int row, int col) {
        if (row >= 0 && col >= 0 && row < arr.length && col < arr[0].length && arr[row][col] == 1) {
            return true;
        }
        return false;
    }
}
