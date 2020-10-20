package Level2;

public class 멀쩡한사각형 {
    public static void main(String[] args) {
        System.out.println(solution(2, 2));  // 80
    }

    public static long solution(int w, int h) {
        long answer = 0;

        double widthPerHeight = (double)w / h;

        // 너비
        double width = widthPerHeight;
        int count = 1;
        while (count < h){
            long deprecated = (long)Math.ceil(width);
            answer += (w - deprecated);
            width = widthPerHeight * count;
            count++;
        }

        answer *= 2;

        return answer;
    }
}
