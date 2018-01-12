package ru.Clinic.lessons;

/**
 * Котопёс
 * Created by suika1 on 07.01.2018.
 */
public class CatDog implements Pet{

    private final Pet cat;
    private final Pet dog;

    public CatDog(Pet cat, Pet dog){
        this.cat = cat;
        this.dog = dog;
    }


    @Override
    public String getName() {
        return String.format("%s%s",this.cat.getName(),this.dog.getName());
    }

    @Override
    public void makeSound() {
        this.cat.makeSound();
        this.dog.makeSound();
    }

    @Override
    public void setName(String name) {
        this.cat.setName(name);
        this.dog.setName(name);
    }
}
