public class DecisionMaking extends InteractionsWithString {
    DefineWinner defineWinner = new DefineWinner();
    IsGameContinue isGameContinue = new IsGameContinue();

    public void whatTheStatus(String input) {

        if (isInputValid(input)) {
            if (isStatusValid(input)) {
                System.out.println("Status correct");
                if (defineWinner.isXWin(input)) {
                    System.out.println("x won");
                } else if (defineWinner.isOWin(input)) {
                    System.out.println("o won");
                } else {
                    isGameContinue.isGameContinue(input);
                }
            } else {
                System.out.println("Status not correct");
            }
        } else {
            System.out.println("Input not correct");
        }
    }
}


