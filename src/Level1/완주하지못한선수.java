package Level1;

import java.util.HashMap;

public class 완주하지못한선수 {
    public static void main(String[] args) {
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> mHashMap = new HashMap<>();

        for (String name :
                participant) {
            mHashMap.merge(name, 1, Integer::sum);
        }

        for (String name :
                completion) {
            mHashMap.put(name, mHashMap.get(name) - 1);
        }

        for (String key :
                mHashMap.keySet()) {
            if (mHashMap.get(key) != 0) {
                answer = key;
                break;
            }
        }

        return answer;
    }
}
