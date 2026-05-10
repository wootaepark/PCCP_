
import java.util.*;
import java.io.*;

public class SWEA_1860
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for(int test_case = 1; test_case <= T; test_case++)
        {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 손님 수
            int M = Integer.parseInt(st.nextToken()); // M 초 동안
            int K = Integer.parseInt(st.nextToken()); // K개의 붕어빵 제조

            int[] arr = new int[N]; // N 명 손님의 도착 시간 정보
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i<N; i++){ // 손님 도착 시간 정보 입력
                arr[i] = Integer.parseInt(st.nextToken());
            }

            if(solve(arr,M,K)){
                System.out.println("#" + test_case + " Possible" );
            }
            else{
                System.out.println("#" + test_case + " Impossible" );
            }


        }
    }

    // 개선 코드
    private static boolean solve(int[] arr, int M, int K) {
        // 1. 손님 도착 시간을 오름차순 정렬 (O(N log N))
        Arrays.sort(arr);

        // 2. 각 손님이 올 때마다 붕어빵 개수 체크
        for (int i = 0; i < arr.length; i++) {
            int arrivalTime = arr[i];

            // 현재 시간(arrivalTime)까지 만들어진 총 붕어빵 개수 계산
            // 0초부터 시작하므로 (시간 / M) * K 가 총 생산량입니다.
            int totalBread = (arrivalTime / M) * K;

            // 현재 손님을 포함해 지금까지 온 손님의 수는 (i + 1)명
            // 생산된 빵보다 손님 수가 많으면 불가능
            if (totalBread < i + 1) {
                return false;
            }
        }

        return true;
    }

    // 정답이지만 개선이 필요한 코드 (내가 푼 코드)

   /* private static boolean solve(Integer[] arr, int M, int K){ // 손님 도착 시간 정보 배열, M초 동안 K개의 붕어빵 제작

        boolean answer = true;

    	Arrays.sort(arr, Collections.reverseOrder());

        Stack<Integer> stack = new Stack<>();
        for(int i : arr){
        	stack.push(i); // 큰 숫자 부터 push
        }

        int remain = 0; // 현재 만들어진 붕어빵의 개수
        for(int i = 0; i<=arr[0] ; i++){ // 1초당 한번 돈다. (필요 없는 작업 발생)

            if(i % M == 0){
                remain += K;
            }
            while(!stack.isEmpty() && stack.peek() == i){
                if(remain <=0){
                    answer = false;
                    break;
                }
                else{
                    stack.pop();
                    remain--;
                }
            }
        }

        if(!stack.isEmpty()){
        	answer = false;
        }

        return answer;
    }*/
}

