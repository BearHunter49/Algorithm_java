package Utils;

import java.util.ArrayList;
import java.util.List;


public class Permutations {

    static ArrayList<List<String>> totalResult = new ArrayList<>();

    public static void main(String[] args) {

        List<String> arr = new ArrayList<>();
        arr.add("a");
        arr.add("b");
        arr.add("c");

        List<String> result = new ArrayList<>();
        permutations(arr, result, arr.size(), 2);

        System.out.println(totalResult);
    }

    /**
     * 순열 구하기
     *
     * @param arr    : 기준 리스트
     * @param result : 결과를 담아줄 리스트
     * @param n      : 전체 갯수
     * @param r      : 뽑을 갯수
     */
    private static void permutations(List<String> arr, List<String> result, int n, int r) {

        if (r == 0) {
            List<String> temp = new ArrayList<>(result);
            totalResult.add(temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            result.add(arr.remove(i));
            permutations(arr, result, n - 1, r - 1);
            arr.add(i, result.remove(result.size() - 1));
        }
    }
}
