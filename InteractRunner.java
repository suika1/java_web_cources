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
            String action = " ";
            System.out.println("Write \"exit\" if you want to close program ");
            while (true){
                System.out.println("Enter first arg: ");
                String first = reader.next();
                if (first.equals("exit")) break;
                System.out.println("Enter second arg: ");
                String second = reader.next();
                if (second.equals("exit")) break;
                System.out.println("Choose action: + - / * % pow : ");
                action = reader.next();
                if (action.equals("exit")) break;
                calc.action(action, Integer.valueOf(first), Integer.valueOf(second));
                calc.getResult();
                calc.cleanResult();
            }
        } finally{
            reader.close();
        }
    }
}