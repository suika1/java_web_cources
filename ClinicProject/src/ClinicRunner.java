import java.util.Scanner;
/**
 * Работа клиники
 * Created by suika1 on 07.01.2018.
 */
public class ClinicRunner {

     public static void main(String[] arg) {
         final Clinic clinic = new Clinic(10);
         final Scanner scanner = new Scanner(System.in);
         String id, name, catName , type;
         catName = " ";
         String s = " ";
         int position = 0;


         /**
          * Считывание действий, обработка каждого действия.
          */
         while (!s.equals("exit")){
             System.out.printf("Выбирайте действия\n Список действий:\nadd|show\nfind clients|find pets\nchange pet name\nchange client id|exit\n");
             s = scanner.nextLine();
             switch (s){
                 case "add":{
                     System.out.printf("Введите id клиента:\n");
                     id = scanner.nextLine();
                     System.out.printf("Введите тип питомца(Cat/Dog/CatDog):\n");
                     type = scanner.nextLine();
                     if (type.equals("CatDog")){
                         System.out.printf("Введите имя кота\n");
                         catName = scanner.nextLine();
                         System.out.printf("Введите имя собаки\n");
                         name = scanner.nextLine();
                     }else {
                         System.out.printf("Введите имя питомца\n");
                         name = scanner.nextLine();
                     }
                     if (type.equals("Cat")){
                         clinic.addClient(position,new Client(id,new Cat(name)));
                     }else if (type.equals("Dog")){
                         clinic.addClient(position,new Client(id,new Dog(name)));
                     }else if (type.equals("CatDog")){
                         clinic.addClient(position,new Client(id,new CatDog(new Cat(catName),new Dog(name))));
                     } else {
                         System.out.printf("Неверный тип питомца\n");
                     }
                     position++;
                     break;
                 }
                 case "show": {
                     clinic.showDataBase();
                     break;
                 }
                 case "find clients": {
                     System.out.printf("Введите имя питомца искомого клиента:\n");
                     name = scanner.nextLine();
                     clinic.findClientsByPetName(name);
                     break;
                 }
                 case "find pets": {
                     System.out.printf("Введите id хозяина искомого питомца:\n");
                     id = scanner.nextLine();
                     clinic.findPetsByClientId(id);
                     break;
                 }
                 case "change client id": {
                     System.out.printf("Введите имя питомца искомого клиента:\n");
                     name = scanner.nextLine();
                     System.out.printf("Введите новое id клиента:\n");
                     id = scanner.nextLine();
                     clinic.changeClientId(name,id);
                     break;
                 }
                 case "change pet name": {
                     System.out.printf("Введите id клиента искомого питомца:\n");
                     id = scanner.nextLine();
                     System.out.printf("Введите новое имя питомца:\n");
                     name = scanner.nextLine();
                     clinic.changePetName(id,name);
                     break;
                 }
                 case "exit":{
                     break;
                 }
                 default:{
                     System.out.printf("Неверно выбрано действие\n");
                     break;
                 }
             }
         }
         scanner.close();
     }
}
