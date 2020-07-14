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

        formulaHolder.setOperator(FormulaComponents.Operator.ADDITION);

        assertEquals("TestVariable+", formulaHolder.toString());
    }

    @Test
    public void testThatFormulaHolderCanSetDataType() {
        FormulaHolder formulaHolder = new FormulaHolder();

        formulaHolder.setVariable("TestVariable");

        formulaHolder.setOperator(FormulaComponents.Operator.ADDITION);

        formulaHolder.setDataType("TestVariable",FormulaComponents.DataType.INTEGER);

        assertEquals("TestVariable[INTEGER]+", formulaHolder.toString());
    }

    @Test
    public void testThatFormulaHolderCanSetAnotherVariable() {
        FormulaHolder formulaHolder = new FormulaHolder();

        formulaHolder.setVariable("TestVariable");

        formulaHolder.setOperator(FormulaComponents.Operator.ADDITION);

        formulaHolder.setDataType("TestVariable",FormulaComponents.DataType.INTEGER);

        formulaHolder.setVariable("SecondVariable");

        assertEquals("TestVariable[INTEGER]+SecondVariable", formulaHolder.toString());
    }

    @Test
    public void testThatFormulaHolderCannotSetTheOperatorBeforeTheVariableHasBeenSet() {
        FormulaHolder formulaHolder = new FormulaHolder();

        formulaHolder.setOperator(FormulaComponents.Operator.ADDITION);

        assertEquals("", formulaHolder.toString());
    }

    @Test
    public void testThatFormulaHolderCannotSetTheDataTypeBeforeTheVariableHasBeenSet() {
        FormulaHolder formulaHolder = new FormulaHolder();

        formulaHolder.setDataType("TestVariable",FormulaComponents.DataType.INTEGER);

        assertEquals("", formulaHolder.toString());
    }

    @Test
    public void testThatFormulaHolderOnlySetsTheVariableAfterAttemptsToAddOperatorAndDataTypeBefore() {
        FormulaHolder formulaHolder = new FormulaHolder();

        formulaHolder.setDataType("TestVariable",FormulaComponents.DataType.INTEGER);

        formulaHolder.setOperator(FormulaComponents.Operator.ADDITION);

        formulaHolder.setVariable("SecondVariable");

        assertEquals("SecondVariable", formulaHolder.toString());
    }

    @Test
    public void testThatFormulaHolderSetsTheOperatorAfterFailedAttemptsToAddOperator() {
        FormulaHolder formulaHolder = new FormulaHolder();

        formulaHolder.setDataType("TestVariable",FormulaComponents.DataType.INTEGER);

        formulaHolder.setOperator(FormulaComponents.Operator.ADDITION);

        formulaHolder.setVariable("SecondVariable");
        formulaHolder.setOperator(FormulaComponents.Operator.ADDITION);

        assertEquals("SecondVariable+", formulaHolder.toString());
    }

    @Test
    public void testThatFormulaHolderSetsTheDataTypeAfterFailedAttemptsToAddDataType() {
        FormulaHolder formulaHolder = new FormulaHolder();

        formulaHolder.setDataType("TestVariable",FormulaComponents.DataType.INTEGER);

        formulaHolder.setOperator(FormulaComponents.Operator.ADDITION);

        formulaHolder.setVariable("SecondVariable");
        formulaHolder.setDataType("SecondVariable",FormulaComponents.DataType.FLOAT);
        formulaHolder.setOperator(FormulaComponents.Operator.SUBTRACTION);

        assertEquals("SecondVariable[FLOAT]-", formulaHolder.toString());
    }

    @Test
    public void testThatFormulaHolderCanSetTheSameVariableNameAsTheOneInTheFailedAttemptInAddingDataType() {
        FormulaHolder formulaHolder = new FormulaHolder();

        formulaHolder.setDataType("TestVariable",FormulaComponents.DataType.INTEGER);

        formulaHolder.setOperator(FormulaComponents.Operator.ADDITION);

        formulaHolder.setVariable("TestVariable");

        assertEquals("TestVariable", formulaHolder.toString());
    }

}