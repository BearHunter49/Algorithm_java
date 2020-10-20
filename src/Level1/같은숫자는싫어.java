package Level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 같은숫자는싫어 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
    }

    public static int[] solution(int []arr) {
        ArrayList<Integer> temp = new ArrayList<>();

        int pivot = -1;
        for (int num: arr){
            if (pivot != num){
                temp.add(num);
                pivot = num;
            }
        }

        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++){
            answer[i] = temp.get(i);
        }

        return answer;
    }
}
