import java.io.*;

public class SWEA_1954_RECURSIVE {

    // SWEA 1954 문제를 재귀를 이용하여 풀이한 문제

    public static final int[] dr = {0, 1, 0, -1};
    public static final int[] dc = {1, 0, -1, 0};

    public static int TC;
    public static int N;
    public static int[][] map;
    public static int number = 1;
    public static int r, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            N = Integer.parseInt(br.readLine());

            int size = N;
            int dec = 1;
            int dir = 0;

            map = new int[N][N];
            number = 1;
            r = 0;
            c = -1;

            goDalpang(size, dec, dir);

            System.out.printf("#%d\n", tc + 1);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void goDalpang(int size, int dec, int dir) {
        if (size == 0) {
            return;
        } else {

            for (int i = 0; i < size; i++) {
                r += dr[dir];
                c += dc[dir];
                map[r][c] = number++;
            }

            dec = (dec + 1) % 2;
            if (dec == 0) {
                size--;
            }
            dir = (dir + 1) % 4;

            goDalpang(size, dec, dir);
        }
    }
}
