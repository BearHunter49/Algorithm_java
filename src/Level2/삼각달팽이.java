package Level2;

import java.util.Arrays;

public class 삼각달팽이 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
    }

    public static int[] solution(int n) {
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
        }

        int total = (n * (n + 1)) / 2;
        int now = 0;
        int now_height = -1;
        int now_index = 0;
        int count = n;
        while (count > 0 || now < total){

            // 왼쪽 아래로
            for (int i = count--; i > 0; i--){
                triangle[++now_height][now_index] = ++now;
            }

            // 맨 아래
            for (int i = count--; i > 0; i--) {
                triangle[now_height][++now_index] = ++now;
            }

            // 오른쪽 위로
            for (int i = count--; i > 0; i--) {
                triangle[--now_height][--now_index] = ++now;
            }
        }

        int[] answer = new int[total];
        int index = 0;
        for (int[] floor: triangle){
            for (int number: floor){
                answer[index++] = number;
            }
        }

        return answer;
    }
}
