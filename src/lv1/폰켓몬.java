package lv1;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
    public static void main(String[] args) {
        me(new int[]{3,1,2,3});
    }

    public static int me(int[] nums) {
        int pickableCount = nums.length / 2;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
            if (set.size() == pickableCount) break;
        }

        return set.size();
    }
}
