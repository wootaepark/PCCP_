import java.util.*;
import java.io.*;


public class SWEA_3289 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr = new int[n + 1]; // 1 부터 n 까지의 집합 정보
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i; // 자기 자신을 부모 원소로 가지도록
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int question = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (question == 0) {

                    union(arr, a, b);
                }
                if (question == 1) {
                    if (a == b || find(arr, a) == find(arr, b)) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                }

            }

            System.out.println("#" + test_case + " " + sb);

        }
    }

    private static int find(int[] arr, int a) {
        if (a == arr[a]) {
            return a;
        }
        return arr[a] = find(arr, arr[a]); // 부모의 부모의 부모의.. 최고 부모를 찾는다.
    }

    private static void union(int[] arr, int a, int b) {
        int rootA = find(arr, a);
        int rootB = find(arr, b);
        if (rootA != rootB) {
            arr[rootB] = rootA;
        }
    }


}
