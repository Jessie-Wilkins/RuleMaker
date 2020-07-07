package com.app.rulemakerapp.FormulaCreator;

public class FormulaHolder {

    private String variable;

    public void setVariable(String variable) {
        this.variable = variable;
    }

    @Override
    public String toString() {
        return variable;
    }
}
