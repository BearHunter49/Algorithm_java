package Level1;

import java.util.Arrays;
import java.util.HashSet;

public class 두개뽑아서더하기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2,1,3,4,1})));
    }

    public static int[] solution(int[] numbers) {
        HashSet<Integer> mSet = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++){
            for (int j = i + 1; j < numbers.length; j++){
                mSet.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[mSet.size()];
        Object[] oSet = mSet.toArray();
        Arrays.sort(oSet);

        for (int i = 0; i < mSet.size(); i++){
            answer[i] = (int)oSet[i];
        }


        return answer;
    }

}





