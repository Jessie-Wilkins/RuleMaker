package com.app.rulemakerapp.FormulaCreator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class FormulaStoreTest {
    @Test
    public void testThatFormulaStoreCanSaveAndGetSpecifiedFormula() {

        Formula formula = new Formula();

        formula.setVariable("TestVariable");

        formula.setOperator(FormulaComponents.Operator.ADDITION);

        formula.setDataType(FormulaComponents.DataType.INTEGER);

        formula.setVariable("TestVariable2");

        formula.setDataType(FormulaComponents.DataType.INTEGER);

        FormulaStore.store("Test Formula", formula);

        assertEquals(FormulaStore.getFormula("Test Formula").toString(), formula.toString());
    }

}