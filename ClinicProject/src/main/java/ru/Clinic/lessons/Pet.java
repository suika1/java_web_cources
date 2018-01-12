package ru.Clinic.lessons;

/**
 * Питомец
 * Created by suika1 on 07.01.2018.
 */
public interface Pet {

    /**
     * Получить имя
     * @return поле имя
     */
    public String getName();

    /**
     * Издать звук
     */
    public void makeSound();

    /**
     * Установить имя
     * @param name новое имя
     */
    public void setName(String name);
}