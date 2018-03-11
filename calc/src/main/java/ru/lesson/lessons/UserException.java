package ru.lesson.lessons;

/**
 * Класс для ошибок
 * Created by user on 11.01.2018.
 */
public class UserException extends Exception{
    public UserException(final String message){
        super(message);
    }

}
