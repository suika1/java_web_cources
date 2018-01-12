package ru.lesson.lessons;


import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Класс-тест для калькулятора
 * Created by user on 11.01.2018.
 */
public class CalculatorTest {

    /**
     * Тест сложения
     * @throws Exception
     */
    @Test
    public void testAdd() throws Exception {
        Calculator calculator = new Calculator();
        calculator.add(1,1);
        assertEquals(2,calculator.getResult());
    }

    /**
     * Тест вычитания
     * @throws Exception
     */
    @Test
    public void testSub() throws Exception {
        Calculator calculator = new Calculator();
        calculator.subtraction(2,1);
        assertEquals(1,calculator.getResult());
    }

    /**
     * Тест деления без аргументов
     * @throws Exception
     */
    @Test(expected = UserException.class)
    public void divException() throws UserException {
        Calculator calculator = new Calculator();
        calculator.division();

    }

    /**
     * Тест деления
     * @throws Exception
     */
    @Test()
    public void div() throws UserException {
        Calculator calculator = new Calculator();
        calculator.division(1,1);
        assertEquals(1,calculator.getResult());
    }

    /**
     * Тест деления на 0
     * @throws Exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void divRuntime() throws UserException {
        Calculator calculator = new Calculator();
        calculator.division(1,0);
    }

    /**
     * Тест умножения
     * @throws Exception
     */
    @Test
    public void testMult() throws Exception {
        Calculator calculator = new Calculator();
        calculator.mult(3,2);
        assertEquals(6,calculator.getResult());
    }

    /**
     * Тест возведения в степень
     * @throws Exception
     */
    @Test
    public void testPow() throws Exception {
        Calculator calculator = new Calculator();
        calculator.pow(4,3);
        assertEquals(64,calculator.getResult());
    }

    /**
     * Тест остатка
     * @throws Exception
     */
    @Test
    public void testMod() throws Exception {
        Calculator calculator = new Calculator();
        calculator.mod(14,3);
        assertEquals(2,calculator.getResult());
    }
}