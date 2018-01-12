package ru.lesson.lessons;


import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 11.01.2018.
 */
public class CalculatorTest {
    @Test
    public void testAdd() throws Exception {
        Calculator calculator = new Calculator();
        calculator.add(1,1);
        assertEquals(2,calculator.getResult());
    }

    @Test
    public void testSub() throws Exception {
        Calculator calculator = new Calculator();
        calculator.subtraction(2,1);
        assertEquals(1,calculator.getResult());
    }

    @Test(expected = UserException.class)
    public void divException() throws UserException {
        Calculator calculator = new Calculator();
        calculator.division();

    }

    @Test()
    public void div() throws UserException {
        Calculator calculator = new Calculator();
        calculator.division(1,1);
        assertEquals(1,calculator.getResult());
    }

    @Test(expected = IllegalArgumentException.class)
    public void divRuntime() throws UserException {
        Calculator calculator = new Calculator();
        calculator.division(1,0);
    }

    @Test
    public void testMult() throws Exception {
        Calculator calculator = new Calculator();
        calculator.mult(3,2);
        assertEquals(6,calculator.getResult());
    }

    @Test
    public void testPow() throws Exception {
        Calculator calculator = new Calculator();
        calculator.pow(4,3);
        assertEquals(64,calculator.getResult());
    }

    @Test
    public void testMod() throws Exception {
        Calculator calculator = new Calculator();
        calculator.mod(14,3);
        assertEquals(2,calculator.getResult());
    }
}