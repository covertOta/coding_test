package lv1;

public class 키패드누르기 {
    public static void main(String[] args) {
        me(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"); // LRLLRRLLLRR
    }

    static String me(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[] rightPos = {3,2};
        int[] leftPos = {3,0};

        for (int number : numbers) {
            int[] nextPosition = getLocation(number);

            switch (nextPosition[1]) {
                case 0:
                    sb.append("L");
                    leftPos = nextPosition;
                    break;
                case 1:
                    int rightDistance = Math.abs((rightPos[0] - nextPosition[0])) + Math.abs((rightPos[1] - nextPosition[1]));
                    int leftDistance = Math.abs((leftPos[0] - nextPosition[0])) + Math.abs((leftPos[1] - nextPosition[1]));

                    char handToUse;
                    if (rightDistance > leftDistance) {
                        handToUse = 'L';
                    } else if (leftDistance > rightDistance) {
                        handToUse = 'R';
                    } else {
                        handToUse = hand.equals("rigth") ? 'R' : 'L';
                    }

                    if (handToUse == 'R') {
                        sb.append("R");
                        rightPos = nextPosition;
                    } else {
                        sb.append("L");
                        leftPos = nextPosition;
                    }
                    break;
                case 2:
                    sb.append("R");
                    rightPos = nextPosition;
                    break;
            }
        }
        System.out.println(sb);
        return sb.toString();
    }

    static int[] getLocation(int num) {
        int[] location = new int[1];

        if (num == 0)
            return new int[]{3, 1};

        int remainder = num % 3;

        if (remainder == 0)
             location = new int[]{(num / 3) - 1, 2};
        else if (remainder == 1)
            location = new int[]{num / 3, 0};
        else if (remainder == 2)
            location = new int[]{num / 3, 1};

        return location;
    }
}
