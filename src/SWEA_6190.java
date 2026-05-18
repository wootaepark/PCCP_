import java.util.*;
import java.io.*;


public class SWEA_6190 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[0][j] = Integer.parseInt(st.nextToken());
                arr[j][0] = arr[0][j];
            }

            for (int i = 1; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    if (i != j) {
                        arr[i][j] = arr[0][j] * arr[i][0];
                    }
                }

            }

            int answer = -1;

            for (int i = 1; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    if (arr[i][j] != 0) {
                        if (isAscending(arr[i][j])) {
                            answer = Math.max(answer, arr[i][j]);
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + answer);


        }
    }

    private static boolean isAscending(int n) {
        String number = String.valueOf(n);
        for (int i = 0; i < number.length() - 1; i++) {
            if (number.charAt(i) > number.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
