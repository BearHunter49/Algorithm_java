package Level2;

public class 문자열압축 {
    public static void main(String[] args) {
        System.out.println(solution("a"));
    }

    public static int solution(String s) {
        int answer = s.length();
        int length = s.length();

        if (length == 1){
            return 1;
        }

        for (int cut = 1; cut < length / 2 + 1; cut++) {  // 자를 길이

            String pre_string = "";
            int total = 0;  // 총 길이
            int count = 1;  // 압축 개수
            for (int i = 0; i < length; i += cut) {
                String now;
                if (i + cut < length){
                    now = s.substring(i, i + cut);
                }else{
                    now = s.substring(i, length);
                }

                if (now.equals(pre_string)){  // 압축
                    count++;
                }else{  // 압축 불가

                    if (count != 1){  // 1개는 안세기
                        total += Integer.toString(count).length();  // 숫자 길이 더하기
                    }
                    total += pre_string.length();  // 문자열 길이 더하기

                    pre_string = now;  // 기준 문자열 변경
                    count = 1;
                }
            }

            // 마지막 처리
            if (count != 1){  // 1개는 안세기
                total += Integer.toString(count).length();  // 숫자 길이 더하기
            }
            total += pre_string.length();  // 문자열 길이 더하기

            answer = Math.min(answer, total);  // 더 작은값 저장
        }

        return answer;
    }
}
