import java.io.*;

public class SWEA_1289 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            String string_value = br.readLine();

            int answer = 1;
            for (int i = string_value.length() - 1; i > 0; i--) {
                if (string_value.charAt(i) != string_value.charAt(i - 1)) {
                    answer++;
                }
            }
            if (string_value.charAt(0) == '0') {
                answer--;
            }

            System.out.println("#" + test_case + " " + answer);


        }
    }
}
