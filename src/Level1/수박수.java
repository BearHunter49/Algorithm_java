package Level1;

import java.util.Arrays;

public class 수박수 {
    public static void main(String[] args) {
        System.out.println(solution(3));
    }

    public static String solution(int n) {
        String answer = "";

        int q = n / 2;
        int r = n % 2;

        for (int i = 0; i < q; i++){
            answer = answer.concat("수박");
        }

        if (r != 0){
            answer = answer.concat("수");
        }

        return answer;
    }
}
