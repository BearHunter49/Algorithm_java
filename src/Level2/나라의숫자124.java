package Level2;

public class 나라의숫자124 {
    public static void main(String[] args) {
        System.out.println(solution(9));
    }

    public static String solution(int n) {
        String answer = "";

        String[] numbers = {"4", "1", "2"};
        String ternary = Integer.toString(n, 3);

        int length = ternary.length();
        int borrow = 0;
        for (int i = length - 1; i > 0; i--){
            int ternaryInt = ternary.charAt(i) - '0';

            if (borrow != 0){  // 숫자 빌림
                ternaryInt -= borrow;
            }

            if (ternaryInt < 0){  // 또 빌리는 경우
                ternaryInt = 2;
                borrow = 1;
                answer = numbers[ternaryInt].concat(answer);
            }else{
                answer = numbers[ternaryInt].concat(answer);

                if (ternaryInt == 0){
                    borrow = 1;
                }else{
                    borrow = 0;
                }
            }
        }

        int first = ternary.charAt(0) - '0';
        if (borrow != 0){
            first -= borrow;
            if (first != 0){
                answer = numbers[first].concat(answer);
            }
        }else{
            answer = numbers[first].concat(answer);
        }

        return answer;
    }
}
