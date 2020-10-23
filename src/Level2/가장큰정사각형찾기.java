package Level2;

public class 가장큰정사각형찾기 {
    public static void main(String[] args) {
        int[][] myBoard = new int[][]{{0,0,1,1},{1,1,1,1}};
        System.out.println(solution(myBoard));
    }

    public static int solution(int [][]board)
    {
        int answer = 0;
        int maxLength = 1;
        int row = board.length;
        int column = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 1){

                    for (int n = maxLength; n < column - j + 1; n++) {  // 길이
                            int area = get_area(board, i, j, n);
                            if (answer < area){
                                answer = area;
                                maxLength = n;
                            }
                        }
                    }

                }
            }

        return answer;
    }

    private static int get_area(int[][] board, int x, int y, int n) {
        int rowLength = board.length;
        int columnLength = board[0].length;
        int row = x + n;
        int column = y + n;

        // 정사각형 아님
        if (row > rowLength){
            return 0;
        }
        if (column > columnLength){
            return 0;
        }

        for (int i = x; i < row; i++) {
            for (int j = y; j < column; j++) {
                if (board[i][j] == 0){  // 정사각형 아님
                    return 0;
                }
            }
        }

        return n * n;
    }


}
