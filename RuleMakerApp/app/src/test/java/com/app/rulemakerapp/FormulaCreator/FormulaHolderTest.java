package com.app.rulemakerapp.FormulaCreator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class FormulaHolderTest {
    @Test
    public void testThatFormulaHolderCanSetAVariable() {

        FormulaHolder formulaHolder = new FormulaHolder();

        formulaHolder.setVariable("TestVariable");

        assertEquals("TestVariable", formulaHolder.toString());
    }

    @Test
    public void testThatFormulaHolderCanSetAnOperator() {
        FormulaHolder formulaHolder = new FormulaHolder();

        formulaHolder.setVariable("TestVariable");
    }

}