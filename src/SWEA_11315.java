import java.io.*;

public class SWEA_11315 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            // 1. 입력부
            int N = Integer.parseInt(br.readLine()); // 오목판의 크기
            String[][] arr = new String[N][N];

            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = line[j];
                }
            }

            boolean isCorrect = false;

            // 2. 출력부
            // 가로 구하기
            int result = 0;
            for (int i = 0; i < N; i++) {
                result = getAnswerCross(arr[i]);
                if (result >= 5) {
                    isCorrect = true;
                    break;
                }
            }
            // 세로 구하기
            for (int i = 0; i < N; i++) {
                String[] tmp = new String[N];
                for (int j = 0; j < N; j++) {
                    tmp[j] = arr[j][i];
                }
                result = getAnswerCross(tmp);
                if (result >= 5) {
                    isCorrect = true;
                    break;
                }
            }

            // 좌하단 대각선
            result = 0;

            for (int i = 0; i < (N * 2 - 1) / 2; i++) {
                if (getAnswerDiagonal(arr, 0, i) >= 5) {
                    isCorrect = true;
                    break;
                }
                if (getAnswerDiagonal(arr, i, N - 1) == 5) {
                    isCorrect = true;
                    break;
                }
            }

            // 우하단 대각선

            for (int i = 0; i < (N * 2 - 1) / 2; i++) {
                if (getAnswerDiagonal2(arr, 0, i) >= 5) {
                    isCorrect = true;
                    break;
                }
                if (getAnswerDiagonal(arr, i, 0) >= 5) {
                    isCorrect = true;
                    break;
                }
            }

            if (isCorrect) {
                System.out.println("#" + test_case + " YES");
            } else {
                System.out.println("#" + test_case + " NO");
            }


        }
    }

    private static int getAnswerCross(String[] arr) {
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("o")) {
                answer++;
                if (answer >= 5) { // 연속하게 5개가 나와야 하므로 이 if 문과 아래 else 문이 필요함
                    break;
                }
            } else {
                answer = 0;
            }
        }
        return answer;
    }

    // 좌하단 대각선
    private static int getAnswerDiagonal(String[][] arr, int startRow, int startCol) {
        int answer = 0;
        while (startRow < arr.length && startCol >= 0) {
            if (arr[startRow][startCol].equals("o")) {
                answer++;
                if (answer >= 5) {
                    break;
                }
            } else {
                answer = 0;
            }

            startRow++;
            startCol--;
        }
        return answer;

    }

    // 우하단 대각선
    private static int getAnswerDiagonal2(String[][] arr, int startRow, int startCol) {
        int answer = 0;
        while (startRow < arr.length && startCol < arr.length) {
            if (arr[startRow][startCol].equals("o")) {
                answer++;
                if (answer >= 5) {
                    break;
                }
            } else {
                answer = 0;
            }
            startRow++;
            startCol++;
        }
        return answer;

    }


}
