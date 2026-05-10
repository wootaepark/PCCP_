
import java.util.*;
import java.io.*;


public class SWEA_3752
{
    public static void main(String[] args) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine()); // 문제의 개수
            int[] points = new int[N]; // 각 배점
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<N; i++){
                points[i] = Integer.parseInt(st.nextToken());
            }


            boolean[] visited = new boolean[10001];
            visited[0] = true;
            int currentMax = 0;

            for (int point : points) { // 이 부분이 핵심이다.
                for (int j = currentMax; j >= 0; j--) {
                    if (visited[j]) {
                        if (!visited[j + point]) {
                            visited[j + point] = true;
                        }
                    }
                }
                currentMax += point;
            }


            int answer = 0;
            for(int i = 0; i<10001 ; i++){
                if(visited[i]){
                    answer++;
                }
            }


            System.out.println("#" + test_case + " " + answer);



        }
    }
}
