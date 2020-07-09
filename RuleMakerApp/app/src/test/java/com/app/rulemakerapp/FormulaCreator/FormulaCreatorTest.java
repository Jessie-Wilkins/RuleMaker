package com.app.rulemakerapp.FormulaCreator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class FormulaCreatorTest {
    @Test
    public void testThatFormulaCreatorCanAddAVariable() {

        FormulaCreator formulaCreator = new FormulaCreator();

        formulaCreator.addVariable("TestVariable");

        assertEquals("TestVariable", formulaCreator.getFormulaString());
    }

    @Test
    public void testThatFormulaCreatorCanAddAnOperator() {

        FormulaCreator formulaCreator = new FormulaCreator();

        formulaCreator.addVariable("TestVariable");

        formulaCreator.addOperator(FormulaComponents.Operator.ADDITION);

        assertEquals("TestVariable+", formulaCreator.getFormulaString());

    }

    @Test
    public void testThatFormulaCreatorCannotAddAnotherOperator() {
        FormulaCreator formulaCreator = new FormulaCreator();

        formulaCreator.addVariable("TestVariable");

        formulaCreator.addOperator(FormulaComponents.Operator.ADDITION);

        formulaCreator.addOperator(FormulaComponents.Operator.SUBTRACTION);

        assertEquals("TestVariable+", formulaCreator.getFormulaString());

    }


}