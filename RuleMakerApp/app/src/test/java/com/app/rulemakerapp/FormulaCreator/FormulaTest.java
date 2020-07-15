package com.app.rulemakerapp.FormulaCreator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class FormulaTest {
    @Test
    public void testThatFormulaHolderCanSetAVariable() {

        Formula formula = new Formula();

        formula.setVariable("TestVariable");

        assertEquals("TestVariable", formula.toString());
    }

    @Test
    public void testThatFormulaHolderCanSetAnOperator() {
        Formula formula = new Formula();

        formula.setVariable("TestVariable");

        formula.setOperator(FormulaComponents.Operator.ADDITION);

        assertEquals("TestVariable+", formula.toString());
    }

    @Test
    public void testThatFormulaHolderCanSetDataType() {
        Formula formula = new Formula();

        formula.setVariable("TestVariable");

        formula.setOperator(FormulaComponents.Operator.ADDITION);

        formula.setDataType(FormulaComponents.DataType.INTEGER);

        assertEquals("TestVariable[INTEGER]+", formula.toString());
    }

    @Test
    public void testThatFormulaHolderCanSetAnotherVariable() {
        Formula formula = new Formula();

        formula.setVariable("TestVariable");

        formula.setOperator(FormulaComponents.Operator.ADDITION);

        formula.setDataType(FormulaComponents.DataType.INTEGER);

        formula.setVariable("SecondVariable");

        assertEquals("TestVariable[INTEGER]+SecondVariable", formula.toString());
    }

    @Test
    public void testThatFormulaHolderCannotSetTheOperatorBeforeTheVariableHasBeenSet() {
        Formula formula = new Formula();

        formula.setOperator(FormulaComponents.Operator.ADDITION);

        assertEquals("", formula.toString());
    }

    @Test
    public void testThatFormulaHolderCannotSetTheDataTypeBeforeTheVariableHasBeenSet() {
        Formula formula = new Formula();

        formula.setDataType(FormulaComponents.DataType.INTEGER);

        assertEquals("", formula.toString());
    }

    @Test
    public void testThatFormulaHolderOnlySetsTheVariableAfterAttemptsToAddOperatorAndDataTypeBefore() {
        Formula formula = new Formula();

        formula.setDataType(FormulaComponents.DataType.INTEGER);

        formula.setOperator(FormulaComponents.Operator.ADDITION);

        formula.setVariable("SecondVariable");

        assertEquals("SecondVariable+", formula.toString());
    }

    @Test
    public void testThatFormulaHolderSetsTheOperatorAfterFailedAttemptsToAddOperator() {
        Formula formula = new Formula();

        formula.setDataType(FormulaComponents.DataType.INTEGER);

        formula.setOperator(FormulaComponents.Operator.ADDITION);

        formula.setVariable("SecondVariable");
        formula.setOperator(FormulaComponents.Operator.ADDITION);

        assertEquals("SecondVariable+", formula.toString());
    }

    @Test
    public void testThatFormulaHolderSetsTheDataTypeAfterFailedAttemptsToAddDataType() {
        Formula formula = new Formula();

        formula.setDataType(FormulaComponents.DataType.INTEGER);

        formula.setOperator(FormulaComponents.Operator.ADDITION);

        formula.setVariable("SecondVariable");
        formula.setDataType(FormulaComponents.DataType.FLOAT);
        formula.setOperator(FormulaComponents.Operator.SUBTRACTION);

        assertEquals("SecondVariable[FLOAT]-", formula.toString());
    }

    @Test
    public void testThatFormulaHolderCanSetTheSameVariableNameAsTheOneInTheFailedAttemptInAddingDataType() {
        Formula formula = new Formula();

        formula.setDataType(FormulaComponents.DataType.INTEGER);

        formula.setOperator(FormulaComponents.Operator.ADDITION);

        formula.setVariable("TestVariable");

        assertEquals("TestVariable+", formula.toString());
    }

}