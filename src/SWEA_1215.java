import java.io.*;

public class SWEA_1215 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {

            // 1. 입력부
            int size = Integer.parseInt(br.readLine().trim()); // 찾아야 하는 회문 (ex : ABBA) 의 길이

            String[][] arr = new String[8][8];

            for (int i = 0; i < 8; i++) {
                String str = br.readLine();
                arr[i] = str.split("");

//                for(int j = 0; j<8; j++){
//                    arr[i][j] = str.charAt(j);
                // 단 이경우는 arr 배열을 char 2차원 배열로 생성해야 한다.
//                }
            }

            // 2. 해결부 (메서드 사용)
            int answer = solve(arr, size);

            // 3. 결과 출력
            System.out.println("#" + test_case + " " + answer);

        }
    }

    private static int solve(String[][] arr, int size) {
        int answer = 0;

        StringBuffer sb;

        for (int i = 0; i < arr.length; i++) { // col
            for (int j = 0; j < arr[0].length; j++) { // row

                // 오른쪽 , 아래쪽만 훑어도 된다.
                if (j + size <= arr[0].length) {
                    sb = new StringBuffer();
                    for (int k = 0; k < size; k++) {
                        sb.append(arr[i][j + k]);
                    }
                    if (sb.toString().equals(sb.reverse().toString())) {
                        answer++;
                    }
                }

                if (i + size <= arr.length) {
                    sb = new StringBuffer();
                    for (int k = 0; k < size; k++) {
                        sb.append(arr[i + k][j]);
                    }
                    if (sb.toString().equals(sb.reverse().toString())) {
                        answer++;
                    }
                }


            }
        }

        return answer;
    }
}
