package Level1;

public class p_2016년 {
    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }

    static String[] weekDay = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    static int[] monthDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static String solution(int a, int b) {
        String answer = "";

        checkLeapYear(2016);

        // 2016년 1월 1일은 금요일
        int totalDay = b + 5 - 1;
        for (int i = 0; i < a - 1; i++){
            totalDay += monthDay[i];
        }

        answer = weekDay[totalDay % 7];

        return answer;
    }

    public static void checkLeapYear(int year){
        // 윤년
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            monthDay[1] = 29;
        }
    }

}
