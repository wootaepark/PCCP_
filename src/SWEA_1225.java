
import java.util.*;
import java.io.*;

class SWEA_1225 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            StringTokenizer st;

            int tc = Integer.parseInt(br.readLine().trim());
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[8];
            for (int i = 0; i < 8; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Queue<Integer> queue = new LinkedList<>();
            solve(arr, queue);

            System.out.print("#" + tc + " ");
            for (int i = 0; i < 8; i++) {
                if (!queue.isEmpty()) {
                    System.out.print(queue.poll() + " ");
                }

            }
            System.out.println();

        }
    }

    private static void solve(int[] arr, Queue<Integer> queue) {

        for (int i : arr) {
            queue.add(i);
        }

        int minus_num = 1; // 뺄 수 (1, 2, 3, 4, 5 순환)
        while (true) {
            if (queue.size() == 8) {
                int tmp = queue.poll();
                tmp -= minus_num;
                if (tmp <= 0) {
                    tmp = 0;
                    queue.add(tmp);
                    break;
                }
                minus_num = minus_num % 5 + 1;
                queue.add(tmp);
            }


        }

    }
}
