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

        assertEquals("TestVariable-", formulaCreator.getFormulaString());

    }

    @Test
    public void testThatFormulaCreatorCannotAddAnotherVariableBeforeSettingADataType() {
        FormulaCreator formulaCreator = new FormulaCreator();

        formulaCreator.addVariable("TestVariable");

        formulaCreator.addOperator(FormulaComponents.Operator.ADDITION);

        formulaCreator.addOperator(FormulaComponents.Operator.SUBTRACTION);

        formulaCreator.addVariable("TestVariable2");

        assertEquals("TestVariable2-", formulaCreator.getFormulaString());
    }

    @Test
    public void testThatFormulaCreatorCanAddDataTypeToVariable() {
        FormulaCreator formulaCreator = new FormulaCreator();

        formulaCreator.addVariable("TestVariable");

        formulaCreator.addOperator(FormulaComponents.Operator.ADDITION);

        formulaCreator.addOperator(FormulaComponents.Operator.SUBTRACTION);

        formulaCreator.addVariable("TestVariable2");

        formulaCreator.addDataType(FormulaComponents.DataType.INTEGER);

        assertEquals("TestVariable2[INTEGER]-", formulaCreator.getFormulaString());
    }

    @Test
    public void testThatFormulaCreatorCannotAddAnotherDataTypeInAdditionToTheCurrentDataType() {
        FormulaCreator formulaCreator = new FormulaCreator();

        formulaCreator.addVariable("TestVariable");

        formulaCreator.addOperator(FormulaComponents.Operator.ADDITION);

        formulaCreator.addOperator(FormulaComponents.Operator.SUBTRACTION);

        formulaCreator.addVariable("TestVariable2");

        formulaCreator.addDataType(FormulaComponents.DataType.INTEGER);

        formulaCreator.addDataType(FormulaComponents.DataType.FLOAT);

        assertEquals("TestVariable2[FLOAT]-", formulaCreator.getFormulaString());
    }

    @Test
    public void testThatFormulaCanAddAnotherVariableAfterSettingNecessaryComponents() {
        FormulaCreator formulaCreator = new FormulaCreator();

        formulaCreator.addVariable("TestVariable");

        formulaCreator.addOperator(FormulaComponents.Operator.ADDITION);

        formulaCreator.addOperator(FormulaComponents.Operator.SUBTRACTION);

        formulaCreator.addVariable("TestVariable2");

        formulaCreator.addDataType(FormulaComponents.DataType.INTEGER);

        formulaCreator.addDataType(FormulaComponents.DataType.FLOAT);

        formulaCreator.addVariable("TestVariable3");

        assertEquals("TestVariable2[FLOAT]-TestVariable3", formulaCreator.getFormulaString());
    }

    @Test
    public void testThatFormulaCanBeSavedOnceFinished() {
        FormulaCreator formulaCreator = new FormulaCreator();

        formulaCreator.addVariable("TestVariable");

        formulaCreator.addOperator(FormulaComponents.Operator.ADDITION);

        formulaCreator.addOperator(FormulaComponents.Operator.SUBTRACTION);

        formulaCreator.addVariable("TestVariable2");

        formulaCreator.addDataType(FormulaComponents.DataType.INTEGER);

        formulaCreator.addDataType(FormulaComponents.DataType.FLOAT);

        formulaCreator.addVariable("TestVariable3");

        formulaCreator.addDataType(FormulaComponents.DataType.FLOAT);

        formulaCreator.save();
    }

}