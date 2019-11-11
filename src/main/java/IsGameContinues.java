public class IsGameContinues extends InteractionsWithString {
    public void isGameContinues(String input) {
        if (xCount(input) - oCount(input) == 1 && xCount(input) + oCount(input) < 9) {
            System.out.println("o - your turn");
        } else if (xCount(input) - oCount(input) == 0 && xCount(input) + oCount(input) < 9) {
            System.out.println("x - your turn");
        } else {
            System.out.println("Draw. Nobody won");
        }
    }
}
