import java.io.*;

public class SWEA_1215_1 {
    // 슬라이딩 윈도우를 활용한 예시


    public static void main(String[] args) throws Exception {
        // 속도 향상을 위해 Scanner 대신 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 10개의 테스트 케이스 고정
        for (int test_case = 1; test_case <= 10; test_case++) {
            // 1. 입력부
            String line = br.readLine();
            if (line == null) {
                break;
            }
            int size = Integer.parseInt(line.trim()); // 찾아야 하는 회문의 길이

            char[][] board = new char[8][8];
            for (int i = 0; i < 8; i++) {
                String row = br.readLine();
                for (int j = 0; j < 8; j++) {
                    board[i][j] = row.charAt(j);
                }
            }

            // 2. 해결부
            int answer = solve(board, size);

            // 3. 결과 출력
            System.out.println("#" + test_case + " " + answer);
        }
    }

    private static int solve(char[][] board, int size) {
        int count = 0;

        for (int i = 0; i < 8; i++) {
            // 가로와 세로를 한 번의 j 루프에서 검사 가능 (슬라이딩 윈도우 범위 설정)
            for (int j = 0; j <= 8 - size; j++) {

                // --- 가로 방향 회문 검사 (투 포인터 활용) ---
                boolean rowCheck = true;
                for (int k = 0; k < size / 2; k++) {
                    // 왼쪽 끝: j+k, 오른쪽 끝: j+size-1-k
                    if (board[i][j + k] != board[i][j + size - 1 - k]) {
                        rowCheck = false;
                        break;
                    }
                }
                if (rowCheck) {
                    count++;
                }

                // --- 세로 방향 회문 검사 (투 포인터 활용) ---
                boolean colCheck = true;
                for (int k = 0; k < size / 2; k++) {
                    // 위쪽 끝: j+k, 아래쪽 끝: j+size-1-k
                    if (board[j + k][i] != board[j + size - 1 - k][i]) {
                        colCheck = false;
                        break;
                    }
                }
                if (colCheck) {
                    count++;
                }
            }
        }

        return count;
    }
}
