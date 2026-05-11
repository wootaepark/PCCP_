import java.util.Scanner;

// 11315 문제를 특정 방향의 놓은 돌의 개수를 이용한 경우
public class SWEA_11315_DIRECTION {
    // 왼쪽 대각선 아래, 아래, 오른쪽 대각선 아래, 오른쪽 방향
    static int[][] drc = {{1, -1}, {1, 0}, {1, 1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            // 배열 입력 받기
            int N = sc.nextInt();
            char[][] arr = new char[N][N];
            for (int i = 0; i < N; i++) {
                char[] tempArr = sc.next().toCharArray();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = tempArr[j];
                }
            }
            // 현재 위치에 돌이 있다면, 방향별 앞의 4칸에 돌이 있는지 확인한다.
            // boolean 변수를 이용해서 출력한다.
            boolean flag = false;
            outer:
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (arr[r][c] == 'o') {
                        flag = check(arr, r, c, N);
                        if (flag) {
                            break outer;
                        }
                    }
                }
            }
            if (flag) {
                System.out.println("#" + t + " " + "YES");
            } else {
                System.out.println("#" + t + " " + "NO");
            }
        }
    }

    static boolean check(char[][] arr, int r, int c, int size) {
        // 4방향을 델타 탐색(s로 인덱스 번호를 줘서 방향을 달리한다)
        for (int s = 0; s < 4; s++) {
            // 방향별 앞의 4개의 돌을 1개씩 체크한다.
            for (int k = 1; k <= 4; k++) {
                int nr = r + drc[s][0] * k;
                int nc = c + drc[s][1] * k;
                if (nr >= 0 && nr < size && nc >= 0 && nc < size && arr[nr][nc] == 'o') {
                    if (k == 4) {
                        return true;
                    }
                } else {
                    break;
                }
            } // end for: 방향별 앞의 4개의 돌 체크

        } // end for: 4개의 방향 체크
        return false; // 4개의 방향 체크 다 했지만 조건 만족하는 경우 없다.
    }

}
