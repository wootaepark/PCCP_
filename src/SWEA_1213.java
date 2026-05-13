import java.io.*;


public class SWEA_1213 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = Integer.parseInt(br.readLine().trim());

            String search = br.readLine(); // 찾고자 하는 문자열
            String original = br.readLine(); // 탐색할 문자열

            int answer = 0;
            for (int i = 0; i <= original.length() - search.length(); i++) {
                String result = original.substring(i, i + search.length());
                if (result.equals(search)) {
                    answer++;
                }
            }

            System.out.println("#" + T + " " + answer);


        }
    }
}
