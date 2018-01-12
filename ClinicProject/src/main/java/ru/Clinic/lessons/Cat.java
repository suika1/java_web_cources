package ru.Clinic.lessons;

/**
 * Кот
 * Created by suika1 on 07.01.2018.
 */
public class Cat implements Pet {

    private final Animal animal;

    public Cat(final Animal animal){
        this.animal = animal;
    }

    @Override
    public String getName() {
        return this.animal.getName();
    }

    @Override
    public void makeSound(){
        System.out.printf("%s said %s",this.getName(),"Hello, I'm cat, meow!");
    }

    @Override
    public void setName(String name){
        this.animal.setName(name);
    }

}