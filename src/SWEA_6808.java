import java.util.*;
import java.io.*;

public class SWEA_6808 {
    private static int[] kyuCards = new int[9];
    private static int[] inCards = new int[9];
    private static boolean[] visited = new boolean[9];
    private static int win, lose;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            win = 0;
            lose = 0;

            boolean[] isKyuCard = new boolean[19]; // 1~18번 카드 체크
            for (int i = 0; i < 9; i++) {
                kyuCards[i] = Integer.parseInt(st.nextToken());
                isKyuCard[kyuCards[i]] = true;
            }

            // 인영이 카드 확정 (규영이가 없는 카드들)
            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!isKyuCard[i]) {
                    inCards[idx++] = i;
                }
            }

            dfs(0, 0, 0);

            System.out.println("#" + test_case + " " + win + " " + lose);
        }
    }


    private static void dfs(int round, int kyuScore, int inScore) {
        // 9라운드까지 다 마쳤을 때
        if (round == 9) {
            if (kyuScore > inScore) {
                win++;
            } else if (kyuScore < inScore) {
                lose++;
            }
            return;
        }

        // 인영이의 카드 9장 중 하나를 선택하는 순열 생성
        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;

                int kCard = kyuCards[round];
                int iCard = inCards[i];
                int sum = kCard + iCard;

                if (kCard > iCard) {
                    dfs(round + 1, kyuScore + sum, inScore);
                } else {
                    dfs(round + 1, kyuScore, inScore + sum);
                }

                visited[i] = false; // 백트래킹: 다음 경우의 수를 위해 방문 해제
            }
        }
    }
}
