public class DefineWinner {

    int[][] combinations() {
        int[][] combinations = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {2, 4, 6}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}};
        return combinations;
    }

    boolean isXWin(String input) {
        boolean isXwon = false;
        for (int i = 0; i < combinations().length; i++) {
            isXwon = input.charAt(combinations()[i][0]) == 'x' &
                    input.charAt(combinations()[i][1]) == 'x' &
                    input.charAt(combinations()[i][2]) == 'x';
            if (isXwon) {
                break;
            }
        }
        return isXwon;
    }

    boolean isOWin(String input) {
        boolean isOwon = false;
        for (int i = 0; i < combinations().length; i++) {
            isOwon = input.charAt(combinations()[i][0]) == 'o' &
                    input.charAt(combinations()[i][1]) == 'o' &
                    input.charAt(combinations()[i][2]) == 'o';
            if (isOwon) {
                break;
            }
        }
        return isOwon;
    }
}


