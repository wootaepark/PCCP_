import java.util.*;
import java.io.*;


public class SWEA_1240
{

    private static int evenResult, oddResult; // even 은 그냥 더하기, odd 는 더하고 3곱하기
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());


        for(int test_case = 1; test_case <= T; test_case++)
        {
            evenResult = 0;
            oddResult = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 세로 길이
            int M = Integer.parseInt(st.nextToken()); // 가로 길이

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i <M; i++){
                sb.append("0");  // 공갈 확인
            }

            String code = "", tmp = "";
            for(int i = 0; i<N; i++){
                String str = br.readLine();
                if(!str.equals(sb.toString())){
                    tmp = str;
                }
            }

            int start = -1;
            for(int j =tmp.length() - 1; j>=0; j--){

                if(tmp.charAt(j) == '1'){
                    start = j;
                    break;
                }

            }

            if(start != -1){
                code = tmp.substring(start - 55, start + 1);

            }

            for(int i = 0; i<8; i++){
                solve(code.substring(i * 7,  (i+1) * 7), i+1);
            }

            int totalResult = oddResult * 3 + evenResult;
            if(totalResult % 10 != 0){
                totalResult = 0;
            }
            else{
                totalResult = evenResult + oddResult;
            }
            System.out.println("#" + test_case + " " + totalResult);
        }
    }
    private static void solve(String number, int seq){

        int result = -1;
        switch(number){
            case "0001101" :
                result = 0;
                break;
            case "0011001" :
                result = 1;
                break;
            case "0010011" :
                result = 2;
                break;
            case "0111101" :
                result = 3;
                break;
            case "0100011" :
                result = 4;
                break;
            case "0110001" :
                result = 5;
                break;
            case "0101111" :
                result = 6;
                break;
            case "0111011" :
                result = 7;
                break;
            case "0110111" :
                result = 8;
                break;
            case "0001011" :
                result = 9;
                break;
        }

        if(seq % 2 == 0){
            evenResult += result;
        }
        else{
            oddResult += result;
        }

    }
}
