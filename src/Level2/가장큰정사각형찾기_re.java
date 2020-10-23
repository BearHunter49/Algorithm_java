package Level2;

public class 가장큰정사각형찾기_re {
    public static void main(String[] args) {
        int[][] myBoard = new int[][]{{0,0,1,1},{1,1,1,1}};
        System.out.println(solution(myBoard));
    }

    public static int solution(int [][]board)
    {
        int answer = 0;
        int row = board.length;
        int column = board[0].length;

        if (row == 1 || column == 1){
            return 1;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 || j == 0){
                    continue;
                }

                if (board[i][j] == 1){
                    board[i][j] = Math.min(board[i - 1][j - 1], Math.min(board[i - 1][j],
                            board[i][j - 1])) + 1;
                    if (answer < board[i][j]){
                        answer = board[i][j];
                    }
                }
            }
        }


        return answer * answer;
    }


}
