import java.util.*;
import java.io.*;

public class SWEA_1229 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine()); // 원본 암호문의 길이

            List<String> list = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(st.nextToken());
            }

            int c = Integer.parseInt(br.readLine()); // 명령어의 개수
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String input = st.nextToken();

                if (input.equals("I")) {
                    int idx = Integer.parseInt(st.nextToken());
                    int count = Integer.parseInt(st.nextToken());
                    for (int i = 0; i < count; i++) {
                        list.add(idx++, st.nextToken());
                    }
                } else if (input.equals("D")) {
                    int idx = Integer.parseInt(st.nextToken());
                    int count = Integer.parseInt(st.nextToken());
                    for (int i = 0; i < count; i++) {
                        if (!list.isEmpty()) {
                            list.remove(idx);
                        }
                    }
                } else {
                    break;
                }

            }
            System.out.print("#" + test_case + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }

    }
}
