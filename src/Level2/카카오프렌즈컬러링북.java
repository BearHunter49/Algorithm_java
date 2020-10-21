package Level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 4, new int[][]{{1, 1, 1, 0},
                {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        long[][] mPicture = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mPicture[i][j] = picture[i][j];
            }
        }

        Queue<int[]> mQueue = new LinkedList<>();
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};  // 상, 하, 좌, 우

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (mPicture[i][j] != 0){
                    long kind = mPicture[i][j];
                    numberOfArea++;

                    mQueue.offer(new int[]{i, j});
                    int size = 0;
                    while (!mQueue.isEmpty()){
                        int[] coordinate = mQueue.poll();
                        int x = coordinate[0];
                        int y = coordinate[1];

                        if (mPicture[x][y] == 0){  // 중복 방지
                            continue;
                        }
                        mPicture[x][y] = 0;
                        size++;

                        for (int[] direction: directions){
                            int nx = x + direction[0];
                            int ny = y + direction[1];
                            if (nx >= 0 && nx < m && ny >= 0 && ny < n
                                    && mPicture[nx][ny] == kind){  // 같은 색
                                mQueue.offer(new int[]{nx, ny});
                            }
                        }
                    }

                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
