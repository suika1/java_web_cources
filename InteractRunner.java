import java.util.Scanner;

/**
 * Главный класс
 * Чтение аргументов, вывод результата.
 * @author Suika
 * @since 05.01.2018
 */
public class InteractRunner{
    public static void main(String[] arg){
        Scanner reader = new Scanner(System.in);
        try{
            Calculator calc = new Calculator();
            String action = "no";
            while (!action.equals("exit")){
                System.out.println("Enter first arg: ");
                String first = reader.next();
                System.out.println("Enter second arg: ");
                String second = reader.next();
                System.out.println("Choose action: + - / * % pow  OR exit : ");
                action = reader.next();
                if (action.equals("exit")) { // If programm needs to be shut down
                    reader.close();
                    System.exit(0);
                }
                calc.action(action, Integer.valueOf(first), Integer.valueOf(second));
                calc.getResult();
                calc.cleanResult();
            }
        } finally{
            reader.close();
        }
    }
}