import java.util.Scanner;

public class SWEA_1954 {
    private static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 우, 하, 좌, 상 방향

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            // 1. 입력부
            int size = sc.nextInt(); // 달팽이 숫자의 크기 // size, size-1, size-1, size-2, size-2, size-3, size-3, ... 이후 두번씩 1까지
            int[][] arr = new int[size][size];

            for (int i = 0; i < size; i++) {
                arr[0][i] = i + 1;
            }

            int direction = 0, startRow = 0, startCol = size - 1, count = size - 1, start = size;
            while (count > 0) {
                for (int i = 0; i < 2; i++) {
                    // 2번씩 같은 size 로 출력하여 채운다.
                    direction = (direction + 1) % 4;
                    for (int k = 0; k < count; k++) {
                        startRow = startRow + dir[direction][0];
                        startCol = startCol + dir[direction][1];
                        arr[startRow][startCol] = ++start;
                    }
                }
                count--;

            }

            // 출력
            System.out.println("#" + test_case);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }


        }
    }
}
