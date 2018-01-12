package ru.Clinic.lessons;

/**
 * Клиент
 * Created by Suika1 on 07.01.2018.
 */
public class Client {

    private String id;
    private final Pet pet;

    public Client(String id, Pet pet){
        this.id = id;
        this.pet = pet;
    }

    /**
     * Получить Id
     */
    public String getId(){
        return this.id;
    }

    /**
     * Получить Питомца
     */
    public Pet getPet(){
        return this.pet;
    }

    /**
     * Изменить Id
     */
    public void setId(String id){
        this.id = id;
    }
}
