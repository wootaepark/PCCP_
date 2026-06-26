import java.io.*;
import java.util.*;

public class BOJ1717 {

    private static int[] parent;

    private static int find(int i){
        // 부모 반환
        if(parent[i] != i){
            parent[i] = find(parent[i]); // 경로 압축
        }
        return parent[i];
    }

    private static void union(int a, int b){
        // a와 b 합집합 연산
        int ra = find(a);
        int rb = find(b);
        if(ra != rb){
            parent[rb] = ra; // 루트 끼리 연결
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 입력 숫자 범위 (최대 N)
        int M = Integer.parseInt(st.nextToken()); // 연산의 개수

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(op == 0){
                // 합집합 연산 수행
                union(a, b);

            }
            if(op == 1){
                // 포함 여부 확인
                System.out.println(find(a) == find(b) ? "YES" : "NO");
            }


        }


    }
}
