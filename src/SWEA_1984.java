import java.util.*;
import java.io.*;


public class SWEA_1984 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[10];

            for (int i = 0; i < 10; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int sum = 0;
            for (int i = 1; i < arr.length - 1; i++) {
                sum += arr[i];
            }

            System.out.printf("#%d %.0f %n", test_case, sum / 8.0);

        }
    }
}
