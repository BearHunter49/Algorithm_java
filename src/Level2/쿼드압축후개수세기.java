package Level2;

import java.util.Arrays;

public class 쿼드압축후개수세기 {
    static int[] myAnswer = {0, 0};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}})));
    }

    public static int[] solution(int[][] arr) {
        my_solution(arr, 0, 0, arr.length);
        return myAnswer;
    }

    public static void my_solution(int[][] arr, int x, int y, int length){
        Boolean flag = true;

        int pivot = arr[x][y];
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (arr[i][j] != pivot){
                    flag = false;
                    break;
                }
            }
            if (!flag){
                break;
            }
        }

        if (flag){  // 정사각형 다 같은 숫자
            myAnswer[pivot] += 1;
            return;
        }

        // 다름
        int next_length = length / 2;

        my_solution(arr, x, y, next_length);
        my_solution(arr, x, y + next_length, next_length);
        my_solution(arr, x + next_length, y, next_length);
        my_solution(arr, x + next_length, y + next_length, next_length);
    }
}
