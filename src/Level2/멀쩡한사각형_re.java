package Level2;

public class 멀쩡한사각형_re {
    public static void main(String[] args) {
        System.out.println(solution(2, 2));  // 80
    }

    public static long solution(int w, int h) {
        long answer = 0;

        answer = ((long)w * (long)h) - (w + h - gcd(w, h));

        return answer;
    }

    private static int gcd(int a, int b) {
        int bigger = Math.max(a, b);
        int smaller = Math.min(a, b);

        while (smaller != 0){
            int r = bigger % smaller;

            bigger = smaller;
            smaller = r;
        }

        return bigger;
    }
}
