package lv1;

public class 공원산책 {
    public static void main(String[] args) {
/*        me(new String[]{"OSO",
                        "OOO",
                        "OXO",
                        "OOO"}
            , new String[]{"E 2","S 3","W 1"}
        );*/
        me(new String[]{"OXO",
                        "XSX",
                        "OXO"}
            , new String[]{"S 1", "E 1", "W 1", "N 1"}
        );
    }

    static int[] me(String[] park, String[] routes) {
        int startX  = 0;
        int startY  = 0;

        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                startY  = i;
                startX = park[i].indexOf("S");
                break;
            }
        }

        for (String route : routes) {
            String heading = route.split(" ")[0];
            int distance = Integer.parseInt(route.split(" ")[1]);
            int dx = 0, dy = 0;
            switch (heading) {
                case "N": dy = -distance; break;
                case "S": dy = distance; break;
                case "W": dx = -distance; break;
                case "E": dx = distance; break;
            }
            if(!isMovable(heading, distance, park, startX, startY )) {
                startX += dx;
                startY += dy;
            }
        }

        return new int[]{startY,startX};
    }

    static boolean isMovable(String heading, int distance, String[] park, int currentX, int currentY) {
        int dx = 0, dy = 0;

        switch (heading) {
            case "N": dy = -1; break;
            case "S": dy = 1; break;
            case "W": dx = -1; break;
            case "E": dx = 1; break;
        }

        int finalX = currentX + dx * distance;
        int finalY = currentY + dy * distance;

        if (finalX < 0 || finalX >= park[0].length() || finalY < 0 || finalY >= park.length)
            return true;

        for (int i = 1; i <= distance; i++) {
            int nextX = currentX + dx * i;
            int nextY = currentY + dy * i;

            if (park[nextY].charAt(nextX) == 'X')
                return true;
        }

        return false;
    }

}
