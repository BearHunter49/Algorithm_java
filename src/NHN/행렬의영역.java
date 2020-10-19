package NHN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 행렬의영역 {
    public static void main(String[] args) {
        solution(6, new int[][]{{0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 1, 0},
                {1, 1, 1, 0, 0, 0}});
    }

    private static void solution(int sizeOfMatrix, int[][] matrix) {
        Queue<int[]> mQueue = new LinkedList<>();
        int totalCount = 0;
        ArrayList<Integer> sizeOfArea = new ArrayList<>();

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};  // 상, 하, 좌, 우

        for (int i = 0; i < sizeOfMatrix; i++){
            for (int j = 0; j < sizeOfMatrix; j++){
                if (matrix[i][j] == 1){
                    totalCount++;
                    mQueue.offer(new int[]{i, j});

                    int tempAreaSize = 0;
                    while (!mQueue.isEmpty()){
                        int[] position = (int[])mQueue.poll();
                        int x = position[0];
                        int y = position[1];

                        if (matrix[x][y] == 0){
                            continue;
                        }
                        matrix[x][y] = 0;
                        tempAreaSize++;

                        for (int[] direction: directions){
                            int nx = x + direction[0];
                            int ny = y + direction[1];
                            if (nx >= 0 && nx < sizeOfMatrix && ny >= 0
                                    && ny < sizeOfMatrix && matrix[nx][ny] == 1){
                                mQueue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    sizeOfArea.add(tempAreaSize);
                }
            }
        }

        if (totalCount == 0){
            System.out.println(0);
        }else {
            System.out.println(totalCount);
            Collections.sort(sizeOfArea);
            for (Integer size: sizeOfArea){
                System.out.print(size);
                System.out.print(" ");
            }
        }


    }

}
