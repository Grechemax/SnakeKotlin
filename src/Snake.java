import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String snake;

        System.out.println("Enter a string. Length: 9 characters min");
        snake = myObj.nextLine();
        System.out.println("You inputted: " + snake);
        String[] arrOfStr = snake.split("");

        // for better look
        String[] beautifiedStr = snake.split("(?<=\\G.{" + 3 + "})");
        for (String b : beautifiedStr) {
            System.out.println(b);
        }

        // if status is correct
        if (snake.matches("(x|o|-)+")) {
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
                };
                if (b.matches("(xxx)")) {
                    System.out.println("Корректный статус, игра закончена, крестики  выиграли");
                };
            }
        } else if (snake.length() == 9 && !snake.matches("(x|o|-)+")) {
            System.out.println("Правильный ввод, некорректный статус");
        } else {
            System.out.println("Неправильный ввод");
        }
    } // end of main method
}




