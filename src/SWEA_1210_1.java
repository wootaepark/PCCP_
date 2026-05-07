import java.util.*;
import java.io.*;

class SWEA_1210_1 {
    // 0: 좌, 1: 우, 2: 상 (좌우를 먼저 체크해야 사다리 규칙에 맞음)
    private static int[] dRow = {0, 0, -1};
    private static int[] dCol = {-1, 1, 0};
    private static int startRow, startCol;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            String line = br.readLine();
            if (line == null) break;
            int tc = Integer.parseInt(line.trim());

            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 2) {
                        startRow = i;
                        startCol = j;
                    }
                }
            }
            int answer = solve(arr);
            System.out.println("#" + tc + " " + answer);
        }
    }

    private static int solve(int[][] arr) {
        boolean[][] visited = new boolean[100][100];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        int finalCol = -1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            // arr[r][c] = 0; // visit 배열을 쓰지 않으면 (이 문제는 가능하지만 arr 을 다시 쓰게 될 경우 visit 추천)

            // 0행에 도달하면 그때의 열(Column)이 정답
            if (r == 0) {
                finalCol = c;
                break;
            }

            // 좌, 우, 상 순서대로 탐색
            for (int i = 0; i < 3; i++) { // 4가 아니라 3입니다!
                int nr = r + dRow[i];
                int nc = c + dCol[i];

                if (nr >= 0 && nr < 100 && nc >= 0 && nc < 100) {
                    if (arr[nr][nc] == 1 && !visited[nr][nc]) { // visit 배열 안쓰면 && 뒤 문장 불필요
                        visited[nr][nc] = true; // visit 배열 미사용 시 불필요
                        queue.add(new int[]{nr, nc});
                        // 핵심: 한 방향으로 이동했다면 이번 좌표에서 다른 방향은 더 이상 볼 필요 없음 (사다리 특징)
                        break;
                    }
                }
            }
        }
        return finalCol;
    }
}
