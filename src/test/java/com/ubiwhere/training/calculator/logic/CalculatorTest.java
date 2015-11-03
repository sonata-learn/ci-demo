package com.ubiwhere.training.calculator.logic;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class CalculatorTest {

    @Test
    public void SimpleTest() {
        CalculatorLogic sut = new CalculatorLogic();
        Integer result = sut.add(3, 5);
        Integer expected = 8;
        assertEquals(result, expected, "What?? Maths are broken!!!");
    }

    @Test
    public void SimpleFailingTest() {
        CalculatorLogic sut = new CalculatorLogic();
        Integer result = sut.add(3, 5);
        Integer expected = 10;
        assertEquals(result, expected, "Not all test failures are bugs in the main app....");
    }

}
