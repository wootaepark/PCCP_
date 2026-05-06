import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1208 {
    // https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&problemLevel=4&contestProbId=AV139KOaABgCFAYh&categoryId=AV139KOaABgCFAYh&categoryType=CODE&problemTitle=&orderBy=INQUERY_COUNT&selectCodeLang=JAVA&select-1=4&pageSize=10&pageIndex=1


    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++)
        {

            int N = Integer.parseInt(br.readLine().trim()); // 블럭을 움직이는 제한 횟수

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr =new int[100];

            // 1. 배열에 높이 정보 입력
            for(int i = 0; i<100; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 2. 배열 오름차순 정렬 (만약 정해진 횟수 만큼 배열 정렬을 계속해도 될까?)

            int size = arr.length;
            for(int i = 0; i<N; i++){
                Arrays.sort(arr);
                arr[0]++;
                arr[size-1]--;
            }

            Arrays.sort(arr);
            int answer = arr[size-1] - arr[0];



            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(answer);
            System.out.println(sb.toString());

        }
    }
}
