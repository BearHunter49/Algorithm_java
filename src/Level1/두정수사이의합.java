package Level1;

public class 두정수사이의합 {
    public static void main(String[] args) {
        System.out.println(solution(3, 5));
    }

    public static long solution(int a, int b) {
        long answer = 0;
        int bigger = Math.max(a, b);
        int smaller = Math.min(a, b);

        for (int i = smaller; i <= bigger; i++){
            answer += i;
        }
        return answer;
    }
}
