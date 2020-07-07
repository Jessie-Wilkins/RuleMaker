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
        if(formula.charAt(formula.length()-1) != '+') {
            this.formula+="+";
        }
    }
}
