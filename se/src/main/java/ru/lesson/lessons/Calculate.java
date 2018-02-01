package ru.lesson.lessons;


public class Calculate {

    public static void main(String[] arg){
        System.out.println("Calculate");

        int first = Integer.valueOf(arg[0]);
        int second = Integer.valueOf(arg[1]);
        int sum = first+second;
        System.out.println("Sum = " + sum);
        int raz = first-second;
        int div = first/second;
        int ost = first%second;
        int mult = first*second;
        int pow = (int)Math.pow(first, second);
        System.out.println("raz = " + raz);
        System.out.println("div = " + div);
        System.out.println("ost = " + ost);
        System.out.println("mult = " + mult);
        System.out.println("pow = " + pow);

    }
}
