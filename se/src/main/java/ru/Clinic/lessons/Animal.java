package ru.Clinic.lessons;

/**
 * Животное
 * Created by suika1 on 07.01.2018.
 */
public class Animal implements Pet {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        return name != null ? name.equals(animal.name) : animal.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    private String name;

    /**
     * Конструктор
     * @param name Имя
     */
    public Animal(String name){
        this.name = name;
    }

    /**
     * Издать звук
     */
    public void makeSound(){
        System.out.println(String.format("%s said: %s", this.name, "Hello, I'm an animal !"));
    }

    /**
     * Получить имя
     * @return поле имя
     */
    public String getName(){
        return this.name;
    }

    /**
     * Установить имя
     * @param name новое имя
     */
    public void setName(String name){
        this.name = name;
    }
}