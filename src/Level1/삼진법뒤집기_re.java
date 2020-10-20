package Level1;

public class 삼진법뒤집기_re {
    public static void main(String[] args) {
        System.out.println(solution(45));  // 7
    }

    public static int solution(int n) {
        String ternary = Integer.toString(n, 3);
        String reversed = new StringBuffer(ternary).reverse().toString();
        return Integer.parseInt(reversed, 3);
    }

}
