package ru.Clinic.lessons;

/**
 * Котопёс
 * Created by suika1 on 07.01.2018.
 */
public class CatDog implements Pet{

    private final Pet cat;
    private final Pet dog;

    /**
     * Конструктор котопса
     * @param cat питомец-кот
     * @param dog питомец-собака
     */
    public CatDog(Pet cat, Pet dog){
        this.cat = cat;
        this.dog = dog;
    }

    /**
     * Получаем имя котопса
     * @return Имя кота+Имя пса
     */
    @Override
    public String getName() {
        return String.format("%s%s",this.cat.getName(),this.dog.getName());
    }

    /**
     * Издать звук
     */
    @Override
    public void makeSound() {
        this.cat.makeSound();
        this.dog.makeSound();
    }

    /**
     * Установить имя
     * @param name новое имя котопса
     */
    @Override
    public void setName(String name) {
        this.cat.setName(name);
        this.dog.setName(name);
    }
}