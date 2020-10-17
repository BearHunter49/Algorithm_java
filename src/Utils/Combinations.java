package Utils;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    static ArrayList<List<String>> totalResult = new ArrayList<>();

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("a");
        arr.add("b");
        arr.add("c");

        List<String> result = new ArrayList<>();
        combinations(arr, result, 0, arr.size(), 2);

        System.out.println(totalResult);
    }

    /**
     * 조합 구하기
     *
     * @param arr    : 기준 리스트
     * @param result : 결과를 담아줄 리스트
     * @param index  : 반복문 시작 인덱스
     * @param n      : 전체 갯수
     * @param r      : 뽑을 갯수
     */
    private static void combinations(List<String> arr, List<String> result, int index, int n, int r) {

        if (r == 0) {
            List<String> temp = new ArrayList<>(result);
            totalResult.add(temp);
            return;
        }

        for (int i = index; i < n; i++) {

            result.add(arr.get(i));
            combinations(arr, result, i + 1, n, r - 1);
            result.remove(result.size() - 1);
        }
    }
}
