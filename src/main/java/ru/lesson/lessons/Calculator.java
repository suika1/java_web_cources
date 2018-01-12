package ru.lesson.lessons;

import javax.jws.soap.SOAPBinding;

/**
 * Побочный класс
 * @author Suika
 * @since 05.01.2017
 */
public class Calculator{
    private int result;
    private boolean divZer = false;

    /**
     * Прибавление
     * @param args Параметры
     * @throws UserException Ошибка при отсутствии аргументов
     */
    public void add(int ... args)throws UserException{
        if (args.length>0) {
            for (Integer param : args) {
                this.result += param;
            }
        }else{
            throw new UserException("You should enter args!");
        }
    }

    /**
     * Вычитание
     * @param args Параметры
     * @throws UserException Ошибка при отсутствии аргументов
     */
    public void subtraction(int ... args) throws UserException{
        if (args.length>0) {
            this.result = args[0]*2; //тк в цикле 1 раз вычитаем
            for (Integer param : args) {
                this.result -= param;
            }
        }else{
            throw new UserException("You should enter args!");
        }
    }

    /**
     * Деление
     * @param args аргументы
     * @throws UserException При делении на 0, отсутствии аргументов
     */
    public void division(int ... args) throws UserException{
        if (args.length>0){
            this.result = args[0]*args[0];
            for (int params : args){
                if (params == 0){
                    throw new IllegalArgumentException("You tried to divide by 0");
                }
                this.result /= params;
            }
        }else{
            throw new UserException("You should enter args!");
        }
    }

    /**
     * Умножение
     * @param args Параметры
     * @throws UserException Ошибка при отсутствии аргументов
     */
    public void mult(int ... args)throws UserException{
        if (args.length>0){
            this.result = 1;
            for (int params : args){
                this.result *= params;
            }
        }else{
            throw new UserException("You should enter args!");
        }
    }
    /**
     * Остаток
     * @param args Параметры
     * @throws UserException Ошибка при отсутствии аргументов
     */
    public void mod(int ... args) throws UserException{
        if (args.length>0){
            this.result = args[0] % args[1];
        }else{
            throw new UserException("You should enter args!");
        }
    }

    /**
     * Возведение в степень
     * @param args Параметры
     * @throws UserException Ошибка при отсутствии аргументов
     */
    public void pow(int ... args) throws UserException{
        if (args.length>0){
            this.result = (int)Math.pow(args[0],args[1]);
        }else{
            throw new UserException("You should enter args!");
        }
    }

    /**
     * Получить результат
     * @return Результат
     */
    public int getResult(){
        return this.result;
    }

    /**
     * Обнулить результат
     */
    public void cleanResult(){
        this.divZer=false;
        this.result =0;
    }
}