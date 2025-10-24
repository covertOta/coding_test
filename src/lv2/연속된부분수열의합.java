package lv2;

public class 연속된부분수열의합 {
    public static void main(String[] args) {
        me(new int[]{1,2,3,4,5}, 7);
    }

    static int[] me(int[] sequence, int k) {
        int left = 0;
        int sum = 0;
        int minLength = sequence.length;

        int[] answer = new int[2];

        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == k)
                return new int[]{i, i};

            sum += sequence[i];
            if (sum > k) {
                while (i > left + 1 && sum > k) {
                    sum -= sequence[left++];
                }
            }

            if (sum == k && minLength > i - left) {
                minLength = i - left;
                answer[0] = left;
                answer[1] = i;
            }
        }

        return answer;
    }
}