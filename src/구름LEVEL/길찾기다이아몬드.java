package 구름LEVEL;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class 길찾기다이아몬드 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        ArrayList<int[]> arr = new ArrayList<>();
        int n = Integer.parseInt(input);

        for (int i = 0; i < 2 * n - 1; i++) {
            String info = sc.nextLine();
            String[] temp1 = info.split(" ");
            int[] temp2 = new int[temp1.length];
            for (int j = 0; j < temp1.length; j++) {
                temp2[j] = Integer.parseInt(temp1[j]);
            }
            arr.add(temp2);
        }



        // 위 삼각형
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < arr.get(i).length; j++) {
                int leftParent = 0;
                int rightParent = 0;
                if (j - 1 >= 0){
                     leftParent = arr.get(i - 1)[j - 1];
                }
                if (j < arr.get(i - 1).length){
                    rightParent = arr.get(i - 1)[j];
                }

                int bigger = Math.max(leftParent, rightParent);
                arr.get(i)[j] += bigger;  // 큰 길이 더하기

            }
        }

        // 아래 삼각형
        for (int i = n; i < 2 * n - 1; i++) {
            for (int j = 0; j < arr.get(i).length; j++) {
                int leftParent = arr.get(i - 1)[j];
                int rightParent = arr.get(i - 1)[j + 1];

                int bigger = Math.max(leftParent, rightParent);
                arr.get(i)[j] += bigger;
            }
        }

        System.out.println(arr.get(2 * n - 2)[0]);

//        int n = Integer.parseInt(input);
//        int total_num = n * n;
//        ArrayList<ArrayList<int[]>> edges = new ArrayList<>();
//        for (int i = 0; i < total_num; i++) {
//            edges.add(new ArrayList<>());
//        }
//
//        // 위 삼각형
//        int parent = 0;
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < arr.get(i).length; j++){
//                int leftChildDistance = Integer.parseInt(arr.get(i + 1)[j]);
//                int leftChild = (((i + 1) * (i + 2)) / 2) + j;
//                int rightChildDistance = Integer.parseInt(arr.get(i + 1)[j + 1]);
//                int rightChild = (((i + 1) * (i + 2)) / 2) + (j + 1);
//
//                edges.get(parent++).add(new int[]{leftChild, leftChildDistance});
//                edges.get(parent++).add(new int[]{rightChild, rightChildDistance});
//            }
//        }
//
//        // 아래 삼각형
//        for (int i = n - 1; i < n * 2 - 1; i++) {
//
//        }
//
//
//
//        System.out.println(input);


    }
}
