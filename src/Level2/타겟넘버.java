package Level2;

public class 타겟넘버 {
    static int answer = 0;
    static int mTarget = 0;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int solution(int[] numbers, int target) {
        mTarget = target;

        my_dfs(numbers, 0, 0);
        return answer;
    }

    public static void my_dfs(int[] numbers, int total, int index){
        if (index == numbers.length && total == mTarget){
            answer++;
            return;
        }

        if (index == numbers.length){
            return;
        }

        my_dfs(numbers, total + numbers[index], index + 1);
        my_dfs(numbers, total - numbers[index], index + 1);

    }
}
