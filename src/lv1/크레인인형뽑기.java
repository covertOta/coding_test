package lv1;

import java.util.Stack;

public class 크레인인형뽑기 {
    public static void main(String[] args) {
        me(
                new int[][]{{4,0,0,0,0}
                        ,{3,0,0,0,0}
                        ,{3,0,0,0,0}
                        ,{2,0,0,0,0}
                        ,{2,0,0,0,0}}
                , new int[]{1}
        );
    }

    public static int me(int[][] board, int[] moves) {
        int size = board.length;
        int[] height = new int[size];

        for (int i = 0; i < height.length; i++) {
            height[i] = -1;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != 0 && height[j] == -1)
                    height[j] = i;
            }
        }

        Stack<Integer> basket = new Stack<>();
        int answer = 0;

        for (int i = 0; i < moves.length; i++) {
            int col = moves[i] - 1;
            int row = height[col] == -1 ? 0 : height[col];

            int selected = board[row][col];

            if (selected == 0) continue;

            if (!basket.isEmpty() && basket.peek() == selected) {
                basket.pop();
                answer += 2;
            } else
                basket.push(selected);

            board[height[col]][col] = 0;
            if (height[col] != size - 1)
                height[col] += 1;
        }

        return answer;
    }
}