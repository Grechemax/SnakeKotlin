public class InteractionsWithString {


    public String[] inputStringArray(String input) {
        return input.split("");
    }

    int xCount(String inputString) {
        int x = 0;
        for (String a : inputStringArray(inputString)) {
            if (a.equals("x")) {
                x++;
            }
        }
        return x;
    }

    int oCount(String inputString) {
        int x = 0;
        for (String a : inputStringArray(inputString)) {
            if (a.equals("o")) {
                x++;
            }
        }
        return x;
    }


    boolean isInputValid(String input) {
        if (input.matches("(x|o|-)+") && input.length() == 9) {
            return true;
        } else {
            return false;
        }
    }


    boolean isStatusValid(String input) {
        if (xCount(input) - oCount(input) == 0 | xCount(input) - oCount(input) == 1) {
            return true;
        } else {
            return false;
        }
    }


    // just for better look in Console
    public void beautifyOutput(String input) {
        System.out.println("You inputted: " + input);
        String[] beautifiedStr = input.split("(?<=\\G.{" + 3 + "})"); // split String for 3 symbols
        for (String b : beautifiedStr) {
            System.out.println(b);
        }
    }
}
