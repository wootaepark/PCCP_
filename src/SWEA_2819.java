import java.util.*;
import java.io.*;

public class SWEA_2819 {
    private static int[] dRow = {0, 1, 0, -1}, dCol = {1, 0, -1, 0}; // 우, 하, 좌, 상

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            int[][] arr = new int[4][4];
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Set<String> numbers = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    solve(numbers, arr, i, j, 0, "");
                }
            }

            System.out.println("#" + test_case + " " + numbers.size());

        }
    }

    private static void solve(Set<String> numbers, int[][] arr, int row, int col, int depth,
                              String str) { // 배열과 시작 점을 부여

        if (depth == 7) {
            numbers.add(str);
            return;
        }

        str = str + String.valueOf(arr[row][col]);

        for (int i = 0; i < 4; i++) {
            int nr = row + dRow[i];
            int nc = col + dCol[i];
            if (nr >= 0 && nc >= 0 && nr < arr.length && nc < arr[0].length) {
                solve(numbers, arr, nr, nc, depth + 1, str);
            }
        }


    }
}
