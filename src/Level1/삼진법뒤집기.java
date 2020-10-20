package Level1;

public class 삼진법뒤집기 {
    public static void main(String[] args) {
        System.out.println(solution(45));  // 7
    }

    public static int solution(int n) {
        String ternary = decimalToTernary(n);
        String reversed = (new StringBuffer(ternary)).reverse().toString();

        return ternaryToDecimal(reversed);
    }

    private static int ternaryToDecimal(String reversed) {
        int length = reversed.length();
        int factor = 1;
        int answer = 0;

        for (int i = length - 1; i > -1; i--){
            answer += (reversed.charAt(i) - '0') * factor;
            factor *= 3;
        }
        return answer;
    }

    private static String decimalToTernary(int n) {
        String answer = "";

        while (n >= 3){
            String r = Integer.toString(n % 3);
            n /= 3;

            answer = r.concat(answer);
        }
        answer = Integer.toString(n).concat(answer);

        return answer;
    }
}
