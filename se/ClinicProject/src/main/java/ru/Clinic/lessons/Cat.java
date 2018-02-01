package ru.Clinic.lessons;

/**
 * Кот
 * Created by suika1 on 07.01.2018.
 */
public class Cat implements Pet {

    private final Animal animal;

    /**
     * Конструктор
     * @param animal Объект класса Animal - текущий кот
     */
    public Cat(final Animal animal){
        this.animal = animal;
    }

    /**
     * Получить имя
     * @return Имя кота
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
        System.out.printf("%s said %s",this.getName(),"Hello, I'm cat, meow!");
    }

    /**
     * Установить имя
     * @param name новое имя кота
     */
    @Override
    public void setName(String name){
        this.animal.setName(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        return animal != null ? animal.equals(cat.animal) : cat.animal == null;
    }

    @Override
    public int hashCode() {
        return animal != null ? animal.hashCode() : 0;
    }

}