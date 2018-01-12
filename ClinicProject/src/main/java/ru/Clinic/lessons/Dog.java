package ru.Clinic.lessons;

/**
 * Собака
 * Created by suika1 on 07.01.2018.
 */
public class Dog implements Pet {

    private final Animal animal;

    public Dog(final Animal animal){
        this.animal = animal;
    }

    @Override
    public String getName() {
        return this.animal.getName();
    }

    @Override
    public void makeSound(){
        System.out.printf("%s said %s",this.getName(),"Hello, I'm a dog, gav-gav!");
    }

    @Override
    public void setName(String name){
        this.animal.setName(name);
    }
}