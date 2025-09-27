package lv1;

public class 소수만들기 {
    public static void main(String[] args) {
        solution(new int[]{1,2,3,4});
//        solution(new int[]{1,2,8,4,5});
    }

    public static int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (isPrime(nums[i] + nums[j] + nums[k]))
                        answer++;
                }
            }
        }
        return answer;
    }

    static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
