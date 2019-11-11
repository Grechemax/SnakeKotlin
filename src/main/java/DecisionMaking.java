public class DecisionMaking extends InteractionsWithString {
    DefineWinner defineWinner = new DefineWinner();
    IsGameContinues isGameContinues = new IsGameContinues();


    public String whatTheStatus(String input) {
        switch (whatTheStatusCode(input)) {
            case 301:
                return Code.X_WON.value;
            case 302:
                return Code.O_WON.value;
            case 100:
                return Code.GAME_CONTINUES.value;
            case 404:
                return Code.STATUS_INCORRECT.value;
            case 500:
                return Code.INPUT_INCORRECT.value;
            default:
                return Code.STATUS_CORRECT.value;
        }
    }

    enum Code {
        X_WON("x won"),
        O_WON("o won"),
        STATUS_CORRECT("Status correct"),
        STATUS_INCORRECT("Status is incorrect"),
        INPUT_INCORRECT("Input is incorrect"),
        GAME_CONTINUES("Game continues");

        private String value;

        Code(String value) {
            this.value = value;
        }
    }


    public int whatTheStatusCode(String input) {
        if (isInputValid(input)) {
            if (isStatusValid(input)) {
//                System.out.println("Status correct");
//                return 200;                                   // how to fix?
                if (defineWinner.isXWin(input)) {
                    return 301;
                } else if (defineWinner.isOWin(input)) {
                    return 302;
                } else {
                    isGameContinues.isGameContinues(input);
                    return 100;
                }
            } else {
                return 404;
            }
        } else {
            return 500;
        }
    }
}


