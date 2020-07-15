package com.app.rulemakerapp.FormulaCreator;

class FormulaCreator {

    private Formula formula = new Formula();

    public void addVariable(String variable) {
        formula.setVariable(variable);
    }

    public String getFormulaString() {
        return formula.toString();
    }

    public void addOperator(FormulaComponents.Operator operator) {
        formula.setOperator(operator);
    }

    public void addDataType(FormulaComponents.DataType integer) {
        formula.setDataType(integer);
    }

    public void save() {
    }
}
