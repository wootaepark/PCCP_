import java.io.*;

class SWEA_2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            int size = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[size][size];

            for (int i = 0; i < size; i++) {
                String[] strArr = br.readLine().split("");
                for (int j = 0; j < size; j++) {
                    arr[i][j] = Integer.parseInt(strArr[j]);
                }

            }

            int answer = getAmounts(arr);

            StringBuilder sb = new StringBuilder();

            sb.append("#").append(test_case).append(" ").append(answer);

            System.out.println(sb);

        }
    }

    private static int getAmounts(int[][] arr) { // 농작물의 총 수확물을 반환하는 메서드

        int center = (arr.length - 1) / 2; // 행 하나에서의 열의 가운데 인덱스

        int sum = 0;

        for (int i = 0; i <= arr.length / 2; i++) { // 행방향 위쪽 (가운데 포함)
            for (int j = center - i; j <= center; j++) { // 왼쪽(sum 포함)
                sum += arr[i][j];
            }

            for (int j = center; j <= center + i; j++) { // 오른쪽 (sum 포함)
                sum += arr[i][j];
            }

            sum -= arr[i][center];

        }

        for (int i = arr.length / 2 + 1; i < arr.length; i++) { // 행방향 아래쪽 (가운데 미포함)

            int d = i - center;
            for (int j = d; j <= center; j++) { // 왼쪽 (center 포함)
                sum += arr[i][j];
            }

            for (int j = center; j < arr.length - d; j++) { // 오른쪽 (center 포함)
                sum += arr[i][j];
            }

            sum -= arr[i][center];
        }

        // 0 1 2 3 4

        return sum;
    }
}
/*
* // 훨씬 간단한 버전 (idea 확인)
* public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			for (int i=0; i<n; i++) { // 입력
				String str = sc.next();
				int[] line = new int[n];
				for (int j=0; j<n; j++) {
					line[j] = str.charAt(j)-'0';
				}
				map[i] = line;
			}

			int ans = 0;
			int start = n/2;
			int end = n/2;
			for (int i=0; i<n; i++) {
				for (int j=start; j<=end; j++) { // 각 행마다
					ans += map[i][j];
				}
				if (i < n/2) { // 행의 절반 전이면
					start -= 1; // 시작을 줄여주고
					end += 1; // 끝을 늘려서 열의 범위를 키움
				} else { // 행의 절반이 지나면
					start += 1; // 시작을 늘리고
					end -= 1; // 끝을 줄여서 열의 범위를 좁힘
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}*/
