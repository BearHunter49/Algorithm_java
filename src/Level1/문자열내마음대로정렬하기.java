package Level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 문자열내마음대로정렬하기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"sun", "bed", "car"}, 1)));
    }

    public static String[] solution(String[] strings, int n) {
        List<String> temp = Arrays.asList(strings);
        Collections.sort(temp);
        Collections.sort(temp, (s1, s2) -> s1.charAt(n) - s2.charAt(n));

        String[] answer = new String[temp.size()];
        for (int i = 0; i < temp.size(); i++){
            answer[i] = temp.get(i);
        }
        int a = 3;
        return answer;
    }
}
