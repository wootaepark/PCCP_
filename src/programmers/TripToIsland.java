package programmers;

// 정답률 : 51%
// https://school.programmers.co.kr/learn/courses/30/lessons/154540

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TripToIsland {
    private static boolean[][] visited;
    private static int[] dRow = {1, 0, -1, 0};
    private static int[] dCol = {0, 1, 0, -1};

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"}));
    }

    private static List<Integer> solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();

        int len = maps.length;
        int len2 = maps[0].length();
        char[][] arr = new char[len][len2];
        visited = new boolean[len][len2];

        for (int i = 0; i < len; i++) {
            String tmp = maps[i];

            for (int j = 0; j < len2; j++) {
                arr[i][j] = tmp.charAt(j);
            }
        }

        for (int i = 0; i < len; i++) {

            for (int j = 0; j < len2; j++) {
                int result = bfs(arr, i, j);
                if (result != -1) {
                    answer.add(result);
                }
            }
        }

        if (answer.isEmpty()) {
            answer.add(-1);
        }

        Collections.sort(answer);

        return answer;
    }

    private static int bfs(char[][] arr, int row, int col){

        if(arr[row][col] == 'X' || visited[row][col]) return -1;

        int sum = 0;
        sum += arr[row][col] - '0';

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while(!queue.isEmpty()){

            int[] tmp = queue.poll();
            int tRow = tmp[0];
            int tCol = tmp[1];

            for(int i = 0; i<4; i++){
                if(isValid(arr, tRow, tCol, i)){

                    sum += arr[tRow+dRow[i]][tCol+dCol[i]] - '0';
                    visited[tRow+dRow[i]][tCol+dCol[i]] = true;
                    queue.add(new int[]{tRow+dRow[i], tCol+dCol[i]});

                }
            }



        }

        return sum;


    }

    private static boolean isValid(char[][] arr, int tRow, int tCol, int i){
        return tRow+dRow[i] < arr.length && tCol+dCol[i] < arr[0].length
                && tRow+dRow[i] >= 0 && tCol+dCol[i] >= 0
                && !visited[tRow+dRow[i]][tCol+dCol[i]]
                && arr[tRow+dRow[i]][tCol+dCol[i]] != 'X';
    }
}
