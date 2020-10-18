package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class K번째수 {
    public static void main(String[] args) {
        int[] a = {1, 5, 2, 6, 3, 7, 4};
        int[][] b = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution(a, b)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int index = 0;
        for (int[] command: commands){
            ArrayList<Integer> temp = new ArrayList<>();

            for (int i = command[0] - 1; i < command[1]; i++){
                temp.add(array[i]);
            }

            Collections.sort(temp);
            answer[index++] = temp.get(command[2] - 1);
        }


        return answer;
    }
}
