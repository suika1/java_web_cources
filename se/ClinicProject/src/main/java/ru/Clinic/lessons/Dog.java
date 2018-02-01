package ru.Clinic.lessons;

/**
 * Собака
 * Created by suika1 on 07.01.2018.
 */
public class Dog implements Pet {

    private final Animal animal;

    /**
     * Конструктор
     * @param animal объект класса Animal - текущая собака
     */
    public Dog(final Animal animal){
        this.animal = animal;
    }

    /**
     * Получить имя
     * @return имя
     */
    @Override
    public String getName() {
        return this.animal.getName();
    }

    /**
     * Издать звук
     */
    @Override
    public void makeSound(){
        System.out.printf("%s said %s",this.getName(),"Hello, I'm a dog, gav-gav!");
    }

    /**
     * Установить имя
     * @param name новое имя
     */
    @Override
    public void setName(String name){
        this.animal.setName(name);
    }
}