package 구름LEVEL;

import java.io.*;
import java.lang.*;
import java.util.*;

public class 놀이공원 {
//    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        testCase(1);
    }

    public static void testCase(int caseIndex) {
        int N = 5;  // 지도의 크기
        int K = 3;  // 놀이공원의 크기

        int[][] wastes = new int[][]{{1, 0, 0, 1, 0}, {0,1, 0, 0, 1}, {0,0,0,1,0},{0,0,0,0,0},{0,0,1,0,0}}; // 각 칸의 쓰레기 존재 여부
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N - K + 1; i++) {
            for (int j = 0; j < N - K + 1; j++) {
                int thrash = calculateArea(wastes, i, j, K);
                answer = Math.min(answer, thrash);
            }
        }


        System.out.println(answer);
    }

    public static int calculateArea(int[][] arr, int x, int y, int length){
        int answer = 0;
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (arr[i][j] == 1){
                    answer++;
                }
            }
        }

        return answer;
    }


}
