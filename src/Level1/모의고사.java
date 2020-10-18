package Level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(a)));
    }

    public static int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] count = {0, 0, 0};

        int length = answers.length;
        for (int i = 0; i < length; i++){
            int answer = answers[i];

            int one_index = i % 5;
            int two_index = i % 8;
            int three_index = i % 10;

            // 1번째
            if (answer == one[one_index]){
                count[0] += 1;
            }

            // 2번째
            if (answer == two[two_index]){
                count[1] += 1;
            }

            if (answer == three[three_index]){
                count[2] += 1;
            }
        }

        int max = -1;
        for (int num: count){
            if (num > max){
                max = num;
            }
        }

        ArrayList<Integer> most = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            if (count[i] == max){
                most.add(i + 1);
            }
        }

        int[] myAnswer = new int[most.size()];
        for (int i = 0; i < most.size(); i++){
            myAnswer[i] = most.get(i);
        }

        return myAnswer;
    }
}
