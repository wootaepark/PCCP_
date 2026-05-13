
import java.util.*;
import java.io.*;

// 어렵지만 재밌던 문제 (해결하긴 했지만 오래 걸림 한 2시간 반)

public class SWEA_4615 {
    private static int[][] direction = {{0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0},
            {-1, -1}}; // 12시 방향 부터 시계방향

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 보드의 크기 N x N
            int[][] arr = new int[N][N]; // 보트판 생성 

            arr[N / 2 - 1][N / 2] = 1;
            arr[N / 2][N / 2 - 1] = 1;
            arr[N / 2 - 1][N / 2 - 1] = 2;
            arr[N / 2][N / 2] = 2;

            int M = Integer.parseInt(st.nextToken()); // 착수할 횟수

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // -> 방향 좌표 (1 ~) -- col (열)
                int y = Integer.parseInt(st.nextToken()); // 아래 방향 좌표 (1 ~ ) -- row(행)
                int color = Integer.parseInt(st.nextToken()); // 알의 색 (1 : 흑, 2: 백)

                for (int d = 0; d < 8; d++) {
                    arr[y - 1][x - 1] = -1; // 원점 구별위함
                    turn(arr, x + direction[d][0], y + direction[d][1], color, d);

                }
                arr[y - 1][x - 1] = color; // 뒤집힘 방어

                //System.out.println(Arrays.deepToString(arr));

            }

            // 전체 보드에서 색깔 세기
            int black = 0, white = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 1) {
                        black++;
                    } else if (arr[i][j] == 2) {
                        white++;
                    }
                }
            }

            System.out.println("#" + test_case + " " + black + " " + white);


        }
    }

    private static void turn(int[][] arr, int x, int y, int color, int d) { // d 는 방향, color 색으로 바꾸는것을 하는 역할
        // 한방향 전용

        if (isValid(arr, x, y) && arr[y - 1][x - 1] == -1) {
            return;
        }

        if (!isValid(arr, x, y) || arr[y - 1][x - 1] == 0) { // 벽을 만나거나 빈공간을 만나면 바꾼거 초기화
            turn(arr, x + direction[(d + 4) % 8][0], y + direction[(d + 4) % 8][1], color % 2 + 1,
                    (d + 4) % 8); // 반대 전환
            return;
        }

        if (arr[y - 1][x - 1] == color) {
            return; // 동일한 색을 만나면 바로 종료
        }

        if (arr[y - 1][x - 1] == color % 2 + 1) { // 다른색인 경우
            arr[y - 1][x - 1] = color; // 색변환
        }

        int nx = x + direction[d][0];
        int ny = y + direction[d][1];

        turn(arr, nx, ny, color, d);


    }

    private static boolean isValid(int[][] arr, int x, int y) {
        if (x >= 1 && y >= 1 && x <= arr[0].length && y <= arr.length) {
            return true;
        }
        return false;
    }


}
