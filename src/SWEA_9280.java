import java.util.*;
import java.io.*;

public class SWEA_9280 {
    private static int answer, remain;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 주차 자리 수
            int M = Integer.parseInt(st.nextToken()); // 차량 수

            remain = N; // 남은 주차 자리수

            int[] park = new int[N];
            for (int i = 0; i < N; i++) {
                park[i] = Integer.parseInt(br.readLine()); // 주차 자리 무게당 요금 입력
            }

            int[] cars = new int[M + 1];
            for (int i = 1; i < M + 1; i++) {
                cars[i] = Integer.parseInt(br.readLine()); // 각 차량의 무게 정보 입력
            }

            // 출입 과정 입력

            int[] isParking = new int[N]; // 각 자리 차량 정보
            Queue<Integer> queue = new LinkedList<>(); // 기본 큐
            Queue<Integer> tmpQueue = new LinkedList<>(); // 대기 큐

            for (int i = 0; i < 2 * M; i++) { // 차가 입차, 출차 각 두번씩이므로
                int carNum = Integer.parseInt(br.readLine()); // 해당 차의 인덱스
                queue.add(carNum);
            }

            while (!queue.isEmpty()) {
                int carIdx = queue.poll();
                if (carIdx > 0) {
                    if (remain > 0) {
                        input(carIdx, park, isParking, cars);
                    } else {
                        tmpQueue.add(carIdx);
                    }
                } else {
                    output(carIdx, park, isParking, cars);
                    if (!tmpQueue.isEmpty()) {
                        int c = tmpQueue.poll();
                        input(c, park, isParking, cars);
                    } else if (!queue.isEmpty()) {
                        int c = queue.peek();
                        if (c > 0) {
                            c = queue.poll();
                            input(c, park, isParking, cars);
                        }

                    }
                }

            }

            System.out.println("#" + test_case + " " + answer);
        }
    }

    private static void input(int carIdx, int[] park, int[] isParking, int[] cars) {

        for (int i = 0; i < isParking.length; i++) {
            if (isParking[i] == 0) {
                isParking[i] = carIdx;
                answer += cars[carIdx] * park[i];
                remain--;
                break;
            }
        }

    }

    private static void output(int carIdx, int[] park, int[] isParking, int[] cars) {
        carIdx = -1 * carIdx;
        for (int i = 0; i < isParking.length; i++) {
            if (isParking[i] == carIdx) {
                isParking[i] = 0;
                remain++;
                break;
            }
        }
    }
}
