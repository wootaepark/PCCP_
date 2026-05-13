import java.io.*;

public class SWEA_1216 {
    private static int answer = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = Integer.parseInt(br.readLine().trim()); // 테스트 케이스 번호 읽기
            char[][] arr = new char[100][100];
            answer = 1; // 최소 길이는 1

            for (int i = 0; i < 100; i++) {
                arr[i] = br.readLine().toCharArray();
            }

            // 가장 긴 길이 k부터 1까지 역순 탐색 (찾으면 바로 중단 가능)
            if (findMaxPalindrome(arr)) {
                System.out.println("#" + T + " " + answer);
            }
        }
    }

    private static boolean findMaxPalindrome(char[][] arr) {
        // 길이 k를 100부터 줄여가며 찾기
        for (int k = 100; k > 1; k--) {
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j <= 100 - k; j++) {
                    // 가로 검사 (행 i 고정, 열 j부터 j+k까지)
                    if (isPalindRow(arr, i, j, k)) {
                        answer = k;
                        return true;
                    }
                    // 세로 검사 (열 i 고정, 행 j부터 j+k까지)
                    if (isPalindCol(arr, j, i, k)) {
                        answer = k;
                        return true;
                    }
                }
            }
        }
        return true;
    }

    // 가로 방향 회문 체크
    private static boolean isPalindRow(char[][] arr, int row, int start, int len) {
        for (int i = 0; i < len / 2; i++) {
            if (arr[row][start + i] != arr[row][start + len - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    // 세로 방향 회문 체크
    private static boolean isPalindCol(char[][] arr, int start, int col, int len) {
        for (int i = 0; i < len / 2; i++) {
            if (arr[start + i][col] != arr[start + len - 1 - i][col]) {
                return false;
            }
        }
        return true;
    }
}
