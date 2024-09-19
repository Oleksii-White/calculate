package org.example;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        String answerToContinue;

        do {
            System.out.println("Do you want to make math operation? \nPrint Y or N");
            answerToContinue = sc.next();
            System.out.println("How many numbers do you want to count?");
            int countNumbers;

            do {
                countNumbers = sc.nextInt();
                System.out.println("Enter more then 1 number");
            } while (countNumbers < 2);

            double [] arrNumbers = new double [countNumbers];
            for (int i = 0; i < arrNumbers.length; i++) {
               arrNumbers[i] = getNumbers("Enter the number", sc);
            }
            String symbol = getSymbol("Enter the symbol for the math operation: +, -, *, /", sc);
            calculate(arrNumbers, symbol);
        } while (!Objects.equals(answerToContinue, "N"));
        System.out.println("Have a good day!");
    }


    public static double getNumbers (String message, Scanner sc){
        System.out.println(message);
        return sc.nextDouble();
    }


    public static String getSymbol (String message, Scanner sc){
        System.out.println(message);
        return sc.next();
    }

    public static void calculate (double [] arrNumbers, String symbol){
        double result = 0;
        for (int i = 0; i < arrNumbers.length; i++) {
            result = calculate(result, arrNumbers[i], symbol);
        }
        System.out.println("Result of math operation is " + result);
    }

    public static double calculate (double num, double num2, String symbol){
        double res = 0;
        switch (symbol) {
            case "+":
                res = num + num2;
                return res;
            case "-":
                res = num - num2;
                return res;
            case "*":
                res = num * num2;
                return res;
            case "/":
                if (num2 == 0) {
                    System.out.println("you can't divide by zero.");
                    break;
                }
                res = (double) num / num2;
                return res;

            default:
                System.out.println("You have entered non-supported operation");
                return res;
        }
        return res;
    }
}