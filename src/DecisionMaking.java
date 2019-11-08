public class DecisionMaking extends InteractionsWithString {
    DefineWinner defineWinner = new DefineWinner();
    IsGameContinue isGameContinue = new IsGameContinue();


    public void whatTheStatus(String input) {
        switch (whatTheStatusCode(input)) {
            case 301:
                System.out.println(Code.X_WON);
                break;
            case 302:
                System.out.println(Code.O_WON);
                break;
            case 100:
                System.out.println(Code.GAME_CONTINUES);
                break;
            case 404:
                System.out.println(Code.STATUS_INCORRECT);
                break;
            case 500:
                System.out.println(Code.INPUT_INCORRECT);
                break;
        }


    }

    enum Code {
        X_WON,
        O_WON,
        STATUS_CORRECT,
        STATUS_INCORRECT,
        INPUT_INCORRECT,
        GAME_CONTINUES
    }

    public int whatTheStatusCode(String input) {
        if (isInputValid(input)) {
            if (isStatusValid(input)) {
//                System.out.println("Status correct");
//                return 200;
                if (defineWinner.isXWin(input)) {
                    return 301;
                } else if (defineWinner.isOWin(input)) {
                    return 302;
                } else {
                    isGameContinue.isGameContinue(input);
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


