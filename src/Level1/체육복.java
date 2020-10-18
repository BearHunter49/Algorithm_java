package Level1;

import java.util.Arrays;

public class 체육복 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));  // 5
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] students = new int[n + 2];  // 인덱스 0, n + 1 빼주기
        Arrays.fill(students, 1);
        students[0] = -1;
        students[n + 1] = -1;

        for (int student :
                lost) {
            students[student] -= 1;
        }
        for (int student :
                reserve) {
            students[student] += 1;
        }

        for (int i = 1; i < n + 1; i++){
            if (students[i] == 0){
                if (students[i - 1] == 2){
                    students[i - 1] -= 1;
                    students[i] += 1;
                }else if (students[i + 1] == 2){
                    students[i + 1] -= 1;
                    students[i] += 1;
                }
            }
        }

        for (int student :
                students) {
            if (student > 0){
                answer += 1;
            }
        }

        return answer;
    }
}
