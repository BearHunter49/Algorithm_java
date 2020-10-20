package Level1;

public class 가운데글자가져오기 {
    public static void main(String[] args) {
        System.out.println(solution("abcde"));  // "c"
    }

    public static String solution(String s) {
        String answer = "";

        int length = s.length();
        if (length % 2 == 0){
            answer = Character.toString(s.charAt(length / 2 - 1)) + (s.charAt(length / 2));
        }else{
            answer = Character.toString(s.charAt(length / 2));
        }

        return answer;
    }
}
