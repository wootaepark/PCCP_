import java.util.*;
import java.io.*;


public class SWEA_1493 {
    private static int[][] arr;
    private static int num = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        arr = new int[500][500];
        for (int i = 1; i < 500; i++) {
            for (int j = 1; j <= i; j++) {
                arr[j][i - j + 1] = num++;
            }
        }

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int tmpX = 0, tmpY = 0;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == x || arr[i][j] == y) {
                        tmpX += i;
                        tmpY += j;
                        if (x == y) {
                            tmpX += i;
                            tmpY += j;
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + arr[tmpX][tmpY]);


        }
    }
}
