import java.util.Scanner;

public class SWEA_2817 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            // dp[i]: 합계 i를 만들 수 있는 경우의 수
            int[] dp = new int[K + 1];

            // 0을 만드는 경우의 수는 1가지 (공집합)
            dp[0] = 1;

            for (int num : nums) {
                // 뒤에서부터 계산해야 현재 숫자가 중복 계산되지 않음 (1차원 배열 사용 시)
                for (int j = K; j >= num; j--) {
                    dp[j] += dp[j - num];
                }
            }

            System.out.println("#" + tc + " " + dp[K]);
        }
        sc.close();
    }
}
