package Level1;

import java.util.Arrays;

public class 소수찾기 {
    public static void main(String[] args) {
        System.out.println(solution(10));  // 4
    }

    public static int solution(int n) {
        int answer = 0;

        // 에라토스테네스의 체
        int[] filter = new int[n + 1];
        Arrays.fill(filter, 1);
        // 0, 1은 소수가 아님
        filter[0] = 0;
        filter[1] = 0;

        for (int i = 2; i < Math.sqrt(n) + 1; i++){

            if (filter[i] == 1){
                for (int j = i * 2; j <= n; j+=i){
                    filter[j] = 0;
                }
            }
        }

        for (int check: filter){
            if (check == 1){
                answer++;
            }
        }

        return answer;
    }
}
