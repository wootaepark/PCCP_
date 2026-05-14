
import java.util.*;
import java.io.*;

public class SWEA_1234 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            String content = st.nextToken();

            String answer = solve(content);

            System.out.println("#" + test_case + " " + answer);

        }
    }

    private static String solve(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            int len = sb.length();
            // sb의 마지막 문자가 현재 문자와 같다면 제거 (중복 발견)
            if (len > 0 && sb.charAt(len - 1) == c) {
                sb.deleteCharAt(len - 1);
            } else {
                // 다르다면 추가
                sb.append(c);
            }
        }
        // sb 라는 저장공간에 문자를 넣고 마지막에 넣은 문자가 현재 탐색하는 문자와 같다면 sb 에서 제거
        // 유사 Stack 자료구조

        return sb.toString();
    }


}
