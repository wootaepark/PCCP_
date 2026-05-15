import java.util.*;
import java.io.*;

public class SWEA_6485 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            // 1. 5000번 정류장까지 카운트할 배열 생성
            int[] busCount = new int[5001];

            // 2. 노선 입력 및 카운팅
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                // 노선이 지나는 구간의 모든 정류장에 +1
                for (int j = A; j <= B; j++) {
                    busCount[j]++;
                }
            }

            // 3. 확인하고 싶은 정류장 P개 입력
            int P = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ");

            for (int i = 0; i < P; i++) {
                int stationNum = Integer.parseInt(br.readLine());
                // 미리 계산된 배열에서 값만 가져옴
                sb.append(busCount[stationNum]).append(" ");
            }

            System.out.println(sb.toString().trim());
        }
    }
}
