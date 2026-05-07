
import java.util.*;
import java.io.*;


class SWEA_1210
    // 일반적인 거꾸로 올라가기 형태로 풀이했으나 BFS 로 활용 가능할것 같다. (해당 풀이는 SWEA_1210_1 에)
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        for(int test_case = 1; test_case <= 10; test_case++)
        {

            int tc = Integer.parseInt(br.readLine().trim());

            // 1. 입력부
            int[][] arr = new int[100][100];

            StringTokenizer st ;

            int x = 0, y = 0; // 초기 도착 좌표

            for(int i = 0; i<100; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<100; j++){
                    int value = Integer.parseInt(st.nextToken());
                    if(value == 2){
                        x = j;
                        y = i;
                    }
                    arr[i][j] = value;
                }
            }

            // 2. 문제 해결부
            // 행방향 y , 열방향 x
            while(y >0){

                arr[y][x] = 0;


                if(x-1 >=0 && arr[y][x-1] == 1){
                    x--;
                    continue;

                }

                if(x+1 <= 99 && arr[y][x+1] == 1){
                    x++;
                    continue;

                }
                if(arr[y-1][x] == 1){
                    y--;

                }



            }

            System.out.println("#" + tc + " " + x);

        }
    }
}
