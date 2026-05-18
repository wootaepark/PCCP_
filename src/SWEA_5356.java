import java.util.*;
import java.io.*;


public class SWEA_5356 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            char[][] arr = new char[5][15];

            // 기본적으로 null 문자로 초기화 되기 때문에 아래 조건 사용하려면
            // 이렇게 채워줘야 함 
            for (int i = 0; i < 5; i++) {
                Arrays.fill(arr[i], ' ');
            }
            for (int i = 0; i < 5; i++) {
                String input = br.readLine();
                for (int j = 0; j < input.length(); j++) {
                    arr[i][j] = input.charAt(j);
                }

            }

            StringBuilder sb = new StringBuilder("#");
            sb.append(test_case).append(" ");

            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 5; j++) {
                    if (arr[j][i] != ' ') {
                        sb.append(String.valueOf(arr[j][i]));
                    }
                }
            }

            System.out.println(sb);


        }
    }
}
