package ru.Clinic.lessons;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Тест класса описывающего клинику
 * Created by user on 11.01.2018.
 */
public class ClinicTest {

    /**
     * Проверка нахождения клиентов по питомцу
     * Без ошибок
     * @throws Exception
     */
    @Test
    public void findClientsByPetName() throws Exception {
        Clinic clinic = new Clinic(10);
        clinic.addClient(0,new Client("Brown",new Cat(new Animal("Johny"))));
        clinic.addClient(1,new Client("Vika",new Dog(new Animal("Michael"))));
        clinic.addClient(2,new Client("Chrome",new CatDog(new Cat(new Animal("Jack")),new Dog(new Animal("Daniels")))));
        assertEquals("Brown",clinic.findClientsByPetName("Johny")[0].getId());
        assertEquals("Chrome",clinic.findClientsByPetName("JackDaniels")[0].getId());
        assertEquals("Vika",clinic.findClientsByPetName("Michael")[0].getId());
    }

    /**
     * Ожидаем ошибку
     * @throws Exception
     */
    @Test(expected = UserException.class)
    public void findClientsByPetNameExc() throws Exception {
        Clinic clinic = new Clinic(10);
        clinic.addClient(0, new Client("Brown", new Cat(new Animal("Johny"))));
        clinic.addClient(1, new Client("Vika", new Dog(new Animal("Michael"))));
        clinic.addClient(2, new Client("Chrome", new CatDog(new Cat(new Animal("Jack")), new Dog(new Animal("Daniels")))));
        clinic.findClientsByPetName("Jojo");
    }

        /**
         * Проверка нахождения питомцев по клиенту
         * Без ошибок
         * @throws Exception
         */
    @Test
    public void findPetsByClientId() throws Exception {
        Clinic clinic = new Clinic(10);
        clinic.addClient(0,new Client("Brown",new Cat(new Animal("Johny"))));
        clinic.addClient(1,new Client("Vika",new Dog(new Animal("Michael"))));
        clinic.addClient(2,new Client("Chrome",new CatDog(new Cat(new Animal("Jack")),new Dog(new Animal("Daniels")))));
        assertEquals("Michael",clinic.findPetsByClientId("Vika")[0].getName());
        assertEquals("Johny",clinic.findPetsByClientId("Brown")[0].getName());
        assertEquals("JackDaniels",clinic.findPetsByClientId("Chrome")[0].getName());
    }

    /**
     * Ожидаем ошибку
     * @throws Exception
     */
    @Test(expected = UserException.class)
    public void findPetsByClientIdExc() throws Exception {
        Clinic clinic = new Clinic(10);
        clinic.addClient(0, new Client("Brown", new Cat(new Animal("Johny"))));
        clinic.addClient(1, new Client("Vika", new Dog(new Animal("Michael"))));
        clinic.addClient(2, new Client("Chrome", new CatDog(new Cat(new Animal("Jack")), new Dog(new Animal("Daniels")))));
        clinic.findPetsByClientId("Ooo sometimes");
    }

        /**
         * Проверка смены имени питомца
         * Без ошибок
         * @throws Exception
         */
    @Test
    public void changePetName() throws Exception {
        Clinic clinic = new Clinic(10);
        clinic.addClient(0,new Client("Brown",new Cat(new Animal("Johny"))));
        clinic.addClient(1,new Client("Vika",new Dog(new Animal("Michael"))));
        clinic.addClient(2,new Client("Chrome",new CatDog(new Cat(new Animal("Jack")),new Dog(new Animal("Daniels")))));
        clinic.changePetName("Vika","Haru");
        assertEquals("Haru",clinic.findPetsByClientId("Vika")[0].getName());
    }

    /**
     * Ожидаем ошибку
     * @throws Exception
     */
    @Test(expected = UserException.class)
    public void changePetNameExc() throws Exception {
        Clinic clinic = new Clinic(10);
        clinic.addClient(0, new Client("Brown", new Cat(new Animal("Johny"))));
        clinic.addClient(1, new Client("Vika", new Dog(new Animal("Michael"))));
        clinic.addClient(2, new Client("Chrome", new CatDog(new Cat(new Animal("Jack")), new Dog(new Animal("Daniels")))));
        clinic.changePetName("1","vova");
    }

        /**
         * Проверка смены id клиента
         * Без ошибки
         * @throws Exception
         */
    @Test
    public void changeClientId() throws Exception {
        Clinic clinic = new Clinic(10);
        clinic.addClient(0,new Client("Brown",new Cat(new Animal("Johny"))));
        clinic.addClient(1,new Client("Vika",new Dog(new Animal("Michael"))));
        clinic.addClient(2,new Client("Chrome",new CatDog(new Cat(new Animal("Jack")),new Dog(new Animal("Daniels")))));
        clinic.changeClientId("JackDaniels","Firefox");
        assertEquals("Firefox",clinic.findClientsByPetName("JackDaniels")[0].getId());
    }

    /**
     * Ожидаем ошибку
     * @throws Exception
     */
    @Test(expected = UserException.class)
    public void changeClientIdExc() throws Exception {
        Clinic clinic = new Clinic(10);
        clinic.addClient(0, new Client("Brown", new Cat(new Animal("Johny"))));
        clinic.addClient(1, new Client("Vika", new Dog(new Animal("Michael"))));
        clinic.addClient(2, new Client("Chrome", new CatDog(new Cat(new Animal("Jack")), new Dog(new Animal("Daniels")))));
        clinic.changeClientId("h","rika");
    }

    }