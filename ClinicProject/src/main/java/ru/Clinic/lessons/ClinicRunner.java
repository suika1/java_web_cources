package ru.Clinic.lessons;

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
            if (s.equals("add")) {
                System.out.printf("Введите id клиента:\n");
                id = scanner.nextLine();
                System.out.printf("Введите тип питомца(Cat/Dog/CatDog):\n");
                type = scanner.nextLine();
                if (type.equals("CatDog")) {
                    System.out.printf("Введите имя кота\n");
                    catName = scanner.nextLine();
                    System.out.printf("Введите имя собаки\n");
                    name = scanner.nextLine();
                    clinic.addClient(position, new Client(id, new CatDog(new Cat(new Animal(catName)), new Dog(new Animal(name)))));
                } else if (type.equals("Dog")||type.equals("Cat")){
                    System.out.printf("Введите имя питомца\n");
                    name = scanner.nextLine();
                    if (type.equals("Cat")) {
                        clinic.addClient(position, new Client(id, new Cat(new Animal(name))));
                    } else if (type.equals("Dog")) {
                        clinic.addClient(position, new Client(id, new Dog(new Animal(name))));
                    }
                } else {
                    System.out.printf("Неверный тип питомца\n");
                }
                position++;
            } else if (s.equals("show")) {
                clinic.showDataBase();
            } else if (s.equals("find clients")) {
                System.out.printf("Введите имя питомца искомого клиента:\n");
                name = scanner.nextLine();
                clinic.findClientsByPetName(name);
            } else if (s.equals("find pets")) {
                System.out.printf("Введите id хозяина искомого питомца:\n");
                id = scanner.nextLine();
                clinic.findPetsByClientId(id);
            } else if (s.equals("change client id")) {
                System.out.printf("Введите имя питомца искомого клиента:\n");
                name = scanner.nextLine();
                System.out.printf("Введите новое id клиента:\n");
                id = scanner.nextLine();
                clinic.changeClientId(name, id);
            } else if (s.equals("change pet name")) {
                System.out.printf("Введите id клиента искомого питомца:\n");
                id = scanner.nextLine();
                System.out.printf("Введите новое имя питомца:\n");
                name = scanner.nextLine();
                clinic.changePetName(id, name);
            } else {
                System.out.printf("Неверно выбрано действие\n");
            }
        }
        scanner.close();
    }
}