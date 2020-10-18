package Level1;

import java.util.Stack;

public class 크레인인형뽑기게임 {
    public static void main(String[] args) {
        int[][] a = {{
                0, 0, 0, 0, 0
        }, {
                0, 0, 1, 0, 3
        }, {
                0, 2, 5, 0, 1
        }, {
                4, 2, 4, 4, 2
        }, {
                3, 5, 1, 3, 1
        }};
        int[] b = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(solution(a, b));  // 4
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> mStack = new Stack<>();

        for (int move: moves){
            for (int i = 0; i < board.length; i++){
                int doll = board[i][move - 1];

                if (doll != 0){
                    int top = -1;
                    if (!mStack.empty()){  // stack 안 비었을때만
                        top = mStack.peek();
                    }

                    if (top == doll){  // 같은 인형 연속 뽑음
                        answer += 2;
                        mStack.pop();
                    }else{  // 다른 인형 뽑음
                        mStack.push(doll);
                    }

                    board[i][move - 1] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}
