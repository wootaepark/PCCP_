import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class PR_47 {
    //https://www.acmicpc.net/problem/1325 (실버 1)
    // 자바로 풀기엔 빡빡한 문제이다.

    static List<List<Integer>> trust;
    static int[] visitCount;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        // 1. 입력부

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 컴퓨터 개수 (노드)
        int M = Integer.parseInt(st.nextToken()); // 신뢰 관계 개수 (에지)

        trust = new ArrayList<>();
        visitCount = new int[N + 1]; // 0 제외 해킹 가능한 회사 개수 정보
        for (int i = 0; i < N + 1; i++) {
            visitCount[i] = 1; // 자기 자신을 해킹가능하므로
        }

        for (int i = 0; i <= N; i++) { // 0 사용 안하고 1번 회사 부터 N 번 회사 까지의 해킹 가능 관계 포함 그래프
            trust.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            trust.get(b).add(a); // a 와 b 가 신뢰 관계 이므로 b로 a 를 해킹할 수 있다는 의미
        }

        // 2. 로직 수행
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            visitCount[i] = bfs(i);
        }
        // 3. 출력부

        int max = Arrays.stream(visitCount).max().orElseThrow(); // 가장 큰 값
        int[] indices = IntStream.range(0, visitCount.length)
                .filter(i -> visitCount[i] == max)
                .sorted()
                .toArray();

        StringBuilder sb = new StringBuilder();
        for (int i : indices) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);


    }


    // dfs 사용시에는 순환경로에서 무한루프임
    private static int bfs(int x) {

        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            List<Integer> tmp = trust.get(queue.poll());
            for (int i : tmp) {
                if(!visited[i]) {
                    visited[i] = true;
                    count++;
                    queue.offer(i);
                }

            }
        }

        return count;

    }
}
