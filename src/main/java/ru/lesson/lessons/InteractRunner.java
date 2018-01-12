package ru.lesson.lessons;

import java.util.Scanner;

/**
 * Главный класс
 * Чтение аргументов, вывод результата.
 * @author Suika
 * @since 05.01.2018
 */
public class InteractRunner{
    public static void main(String[] arg){
        boolean divzer;
        Scanner reader = new Scanner(System.in);
        try{
            Calculator calc = new Calculator();
            String action = " ";
            System.out.println("Write \"exit\" if you want to close program ");
            while (true){
                System.out.println("Enter first arg: ");
                String first = reader.next();
                if (first.equals("exit")) break;
                System.out.println("Enter second arg: ");
                String second = reader.next();
                if (second.equals("exit")) break;
                System.out.println("Choose action: + - / * %  ^  : ");
                action = reader.next();
                if (action.equals("+")){
                    try {
                        calc.add(Integer.valueOf(first), Integer.valueOf(second));
                    } catch (UserException e) {
                        System.out.println(e.getMessage());
                    }
                }else if (action.equals("-")){
                    try {
                        calc.subtraction(Integer.valueOf(first), Integer.valueOf(second));
                    } catch (UserException e) {
                        System.out.println(e.getMessage());
                    }
                }else if (action.equals("/")){
                    try {
                        calc.division(Integer.valueOf(first), Integer.valueOf(second));
                    } catch (UserException e) {
                        System.out.println(e.getMessage());
                    }
                }else if (action.equals("*")){
                    try {
                        calc.mult(Integer.valueOf(first), Integer.valueOf(second));
                    } catch (UserException e) {
                        System.out.println(e.getMessage());
                    }
                }else if (action.equals("%")){
                    try {
                        calc.mod(Integer.valueOf(first), Integer.valueOf(second));
                    } catch (UserException e) {
                        System.out.println(e.getMessage());
                    }
                }else if (action.equals("^")){
                    try {
                        calc.pow(Integer.valueOf(first), Integer.valueOf(second));
                    } catch (UserException e) {
                        System.out.println(e.getMessage());
                    }
                }else{
                    break;
                }
                System.out.printf("Result is : %d \n" , calc.getResult());
                calc.cleanResult();
            }
        } finally{
            reader.close();
        }
    }
}