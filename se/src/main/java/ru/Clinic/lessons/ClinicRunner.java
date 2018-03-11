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
            System.out.printf("----------------\nВыбирайте действия\n Список действий:\nadd|show\nfind clients|find pets\nchange pet name\ndelete by id|delete by name\nchange client id|exit\n----------------\n");
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
                    try {
                        clinic.addClient(position, new Client(id, new CatDog(new Cat(new Animal(catName)), new Dog(new Animal(name)))));
                    } catch (UserException e){
                        System.out.println(e.getMessage());
                    }
                } else if (type.equals("Dog")||type.equals("Cat")){
                    System.out.printf("Введите имя питомца\n");
                    name = scanner.nextLine();
                    if (type.equals("Cat")) {
                        try {
                            clinic.addClient(position, new Client(id, new Cat(new Animal(name))));
                        } catch (UserException e){
                        System.out.println(e.getMessage());
                    }
                    } else if (type.equals("Dog")) {
                        try {
                        clinic.addClient(position, new Client(id, new Dog(new Animal(name))));
                        } catch (UserException e){
                            System.out.println(e.getMessage());
                        }
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
                try {
                    clinic.findClientsByPetName(name);
                } catch (UserException e){
                    System.out.println(e.getMessage());
                }
            } else if (s.equals("find pets")) {
                System.out.printf("Введите id хозяина искомого питомца:\n");
                id = scanner.nextLine();
                try {
                    clinic.findPetsByClientId(id);
                } catch (UserException e){
                    System.out.println(e.getMessage());
                }
            } else if (s.equals("change client id")) {
                System.out.printf("Введите имя питомца искомого клиента:\n");
                name = scanner.nextLine();
                System.out.printf("Введите новое id клиента:\n");
                id = scanner.nextLine();
                try {
                    clinic.changeClientId(name, id);
                } catch (UserException e){
                    System.out.println(e.getMessage());
                }
            } else if (s.equals("change pet name")) {
                System.out.printf("Введите id клиента искомого питомца:\n");
                id = scanner.nextLine();
                System.out.printf("Введите новое имя питомца:\n");
                name = scanner.nextLine();
                try {
                    clinic.changePetName(id, name);
                } catch (UserException e){
                    System.out.println(e.getMessage());
                }
            }else if (s.equals("delete by id")) {
                System.out.printf("Введите id клиента, записи про которого хотите удалить:\n");
                id = scanner.nextLine();
                clinic.deleteRecordsById(id);
            }else if (s.equals("delete by name")) {
                System.out.printf("Введите имя питомца, записи про которого хотите удалить:\n");
                name = scanner.nextLine();
                clinic.deleteRecordsByName(name);
            }
            else {
                if (!s.equals("exit"))
                  System.out.printf("Неверно выбрано действие\n");
            }
        }
        scanner.close();
    }
}