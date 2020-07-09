package com.app.rulemakerapp.FormulaCreator;

class FormulaCreator {

    private FormulaHolder formula = new FormulaHolder();

    public void addVariable(String variable) {
        formula.setVariable(variable);
    }

    public String getFormulaString() {
        return formula.toString();
    }

    public void addOperator(FormulaComponents.Operator operator) {
        formula.setOperator(operator);
    }
}
