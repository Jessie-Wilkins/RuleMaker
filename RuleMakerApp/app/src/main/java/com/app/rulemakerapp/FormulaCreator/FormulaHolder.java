package com.app.rulemakerapp.FormulaCreator;

import java.util.HashMap;
import java.util.Map;

public class FormulaHolder {

    private HashMap<String, FormulaComponents.Operator> variableDictionary = new HashMap<String, FormulaComponents.Operator>();

    private HashMap<Integer, String> variableOrder = new HashMap<>();

    private int currentOrder = 0;

    public void setVariable(String variable) {
        variableOrder.put(currentOrder, variable);

    }

    @Override
    public String toString() {
        StringBuilder formulaStringBuilder = new StringBuilder();
        for(Map.Entry variable:variableOrder.entrySet()) {
            formulaStringBuilder.append(variable.getValue());
            if(variableDictionary.containsKey(variable.getValue())) {

                formulaStringBuilder.append(variableDictionary.get(variable.getValue()).toString());
            }
        }
        return formulaStringBuilder.toString();
    }

    public void setOperator(FormulaComponents.Operator operator) {
        variableDictionary.put(variableOrder.get(currentOrder), operator);
    }
}
