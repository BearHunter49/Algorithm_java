package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 나누어떨어지는숫자배열 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5, 9, 7, 10}, 5)));
    }

    public static int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> temp = new ArrayList<>();

        for (int number: arr){
            if (number % divisor == 0){
                temp.add(number);
            }
        }

        Collections.sort(temp);

        int length = temp.size();
        if (length == 0){
            return new int[]{-1};
        }

        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++){
            answer[i] = temp.get(i);
        }

        return answer;
    }

}
