package com.app.rulemakerapp.FormulaCreator;

class FormulaCreator {

    private String formula = "";

    public void addVariable(String variable) {
        this.formula+= variable;
    }

    public String getFormulaString() {
        return formula;
    }

    public void addOperator(FormulaComponents.Operator operator) {
         this.formula+="+";
    }
}
