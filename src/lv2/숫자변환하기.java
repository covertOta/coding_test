package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 숫자변환하기 {
    public static void main(String[] args) {
        System.out.println(me(10,40,5));
    }

    static int me(int x, int y, int n) {
        if (x==y) return 0;
        Queue<Integer> q = new LinkedList();
        int[] cnt = new int[y + 1];
        q.offer(x);

        while (!q.isEmpty()) {
            int cur = q.poll();
            int[] nextVal = {cur + n, cur * 2, cur * 3};

            for (int next : nextVal) {
                if (next > y || cnt[next] != 0)
                    continue;

                cnt[next] = cnt[cur] + 1;

                if (next == y)
                    return cnt[next];

                q.offer(next);

            }
        }

        return -1;
    }
}