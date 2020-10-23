package Level3;

import java.util.Arrays;

public class 추석트래픽 {
    public static void main(String[] args) {
        String[] temp = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
        System.out.println(solution(temp));
    }

    public static int solution(String[] lines) {
        int answer = 1;

        int length = lines.length;
        int[][] traffics = new int[length][2];

        int index = 0;
        for (String info: lines){
            String[] temp = info.split(" ");

            String time = temp[1];
            int endTimeMilli = timeToMilli(time);
            String second = temp[2].substring(0, temp[2].length() - 1);  // 뒤에 s빼기

            int millisecond = (int)(Double.parseDouble(second) * 1000);
            int startTimeMilli = endTimeMilli - millisecond + 1;

            traffics[index++] = new int[]{startTimeMilli, endTimeMilli};
        }

        // 끝난시간으로 오름차순
        Arrays.sort(traffics, (s1, s2) -> ((int[])s1)[1] - ((int[])s2)[1]);

        for (int i = 0; i < length - 1; i++) {
            int pivotEndTime = traffics[i][1];
            int count = 1;

            for (int j = i + 1; j < length; j++) {
                int startTime = traffics[j][0];

                if (pivotEndTime + 1000 - 1 < startTime){
                    continue;
                }

                count++;
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }

    private static int timeToMilli(String time) {
        String[] temp = time.split(":");
        int result = 0;

        result += Integer.parseInt(temp[0]) * 60 * 60 * 1000;
        result += Integer.parseInt(temp[1]) * 60 * 1000;
        result += Double.parseDouble(temp[2])* 1000;

        return result;
    }
}
