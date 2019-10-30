import java.util.Scanner;

public class Snake {
    public static int x = 0;
    public static int o = 0;

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String snake;

        System.out.println("Enter a string of length 9:");
        snake = myObj.nextLine();
        String[] arrOfStr = snake.split("");
        System.out.println("You inputted: " + snake);

        // for better look
        String[] beautifiedStr = snake.split("(?<=\\G.{" + 3 + "})"); // split String for 3 symbols
        for (String b : beautifiedStr) {
            System.out.println(b);
        }


        for (String a : arrOfStr) {
            if (a.equals("x")) {
                x++;
            }
            if (a.equals("o")) {
                o++;
            }
        }

        if (isInputValid(snake)) {
            isStatusValid();
        }

        if (isStatusValid()) {
            proceedGame(arrOfStr, beautifiedStr);
        }
    }// end of main method

    static boolean isInputValid(String snake) {
        if (snake.matches("(x|o|-)+") && snake.length() == 9) {
            return isStatusValid();
        } else {
            System.out.println("Неправильный ввод");
            return false;
        }
    }

    static boolean isStatusValid() {
        if ((x > o) && (x != o) && (x + o < 8)) {
            System.out.println("Корректный статус");
            return true;
        } else {
            System.out.println("Правильный ввод, некорректный статус или ничья");
            return false;
        }
    }

    static void proceedGame(String[] arr1, String[] arr2) {
        if (x > o) {
            System.out.println("игра прод. нолики ходят");
        } else if (x < o){
            System.out.println("игра прод. крестики ходят");
        } else {
            defineWinner(arr1, arr2);
        }
    }

    static void defineWinner(String[] arrOfStr, String[] beautifiedStr) {
        //Diagonal 1
        if (arrOfStr[0].equals("x") && arrOfStr[4].equals("x") && arrOfStr[8].equals("x")) {
            System.out.println("Корректный статус, игра закончена, крестики  выиграли");
        }
        if (arrOfStr[0].equals("o") && arrOfStr[4].equals("o") && arrOfStr[8].equals("o")) {
            System.out.println("Корректный статус, игра закончена, нолики  выиграли");
        }

        //Diagonal 2
        if (arrOfStr[2].equals("x") && arrOfStr[4].equals("x") && arrOfStr[6].equals("x")) {
            System.out.println("Корректный статус, игра закончена, крестики  выиграли");
        }
        if (arrOfStr[2].equals("o") && arrOfStr[4].equals("o") && arrOfStr[6].equals("o")) {
            System.out.println("Корректный статус, игра закончена, нолики  выиграли");
        }
        //Horizontal 1, Horizontal 2, Horizontal 3
        for (String b : beautifiedStr) {
            if (b.matches("(ooo)")) {
                System.out.println("Корректный статус, игра закончена, нолики  выиграли");
            }
            if (b.matches("(xxx)")) {
                System.out.println("Корректный статус, игра закончена, крестики  выиграли");
            }
        }

        //Vertical 1
        if (arrOfStr[0].equals("x") && arrOfStr[3].equals("x") && arrOfStr[6].equals("x")) {
            System.out.println("Корректный статус, игра закончена, крестики  выиграли");
        }
        if (arrOfStr[0].equals("o") && arrOfStr[3].equals("o") && arrOfStr[6].equals("o")) {
            System.out.println("Корректный статус, игра закончена, нолики  выиграли");
        }
        //Vertical 2
        if (arrOfStr[1].equals("x") && arrOfStr[4].equals("x") && arrOfStr[7].equals("x")) {
            System.out.println("Корректный статус, игра закончена, крестики  выиграли");
        }
        if (arrOfStr[1].equals("o") && arrOfStr[4].equals("o") && arrOfStr[7].equals("o")) {
            System.out.println("Корректный статус, игра закончена, нолики  выиграли");
        }
        // Vertical 3
        if (arrOfStr[2].equals("x") && arrOfStr[5].equals("x") && arrOfStr[8].equals("x")) {
            System.out.println("Корректный статус, игра закончена, крестики  выиграли");
        }
        if (arrOfStr[2].equals("o") && arrOfStr[5].equals("o") && arrOfStr[8].equals("o")) {
            System.out.println("Корректный статус, игра закончена, нолики  выиграли");
        }
    }
}


