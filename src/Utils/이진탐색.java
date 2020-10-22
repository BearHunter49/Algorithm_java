package Utils;

import java.util.Arrays;

public class 이진탐색 {
    public static void main(String[] args) {
        int[] myArr = {5, 3, 7, 9, 1, 10, 2};
        Arrays.sort(myArr);  // 오름차순 기준
        System.out.println(Arrays.toString(myArr));
        System.out.println(my_binary_search(myArr, 7, 0, myArr.length - 1));
    }

    // target 인덱스 찾기
    public static int my_binary_search(int[] arr, int target, int start, int end){
        if (start > end){  // 못찾음
            return -1;
        }

        int mid = (start + end) / 2;

        if (arr[mid] == target){
            return mid;
        }

        if (arr[mid] < target){  // 오른쪽 봐야함
            return my_binary_search(arr, target, mid + 1, end);
        }else{  // 왼쪽 봐야함
            return my_binary_search(arr, target, start, mid - 1);
        }

    }
}
