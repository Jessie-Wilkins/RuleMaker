package com.app.rulemakerapp.FormulaCreator;

import java.util.HashMap;
import java.util.Map;

public class FormulaHolder {

    private HashMap<String, FormulaComponents.Operator> variableDictionary = new HashMap<>();

    private HashMap<Integer, String> variableOrder = new HashMap<>();

    private HashMap<String, FormulaComponents.DataType> variableDataType = new HashMap<>();

    private int currentOrder = 0;

    public void setVariable(String variable) {
        variableOrder.put(currentOrder, variable);

    }

    @Override
    public String toString() {
        StringBuilder formulaStringBuilder = new StringBuilder();
        buildFormulaString(formulaStringBuilder);
        return formulaStringBuilder.toString();
    }

    public void setOperator(FormulaComponents.Operator operator) {
        variableDictionary.put(variableOrder.get(currentOrder), operator);
    }

    public void setDataType(String variable, FormulaComponents.DataType dataType) {
        variableDataType.put(variable, dataType);
    }

    private void buildFormulaString(StringBuilder formulaStringBuilder) {
        for(Map.Entry variable:variableOrder.entrySet()) {
            formulaStringBuilder.append(variable.getValue());
            appendDataType(formulaStringBuilder, variable);
            appendOperator(formulaStringBuilder, variable);
        }
    }

    private void appendDataType(StringBuilder formulaStringBuilder, Map.Entry variable) {
        if(variableDataType.containsKey(variable.getValue())) {
            formulaStringBuilder.append('[').append(variableDataType.get(variable.getValue())).append(']');
        }
    }

    private void appendOperator(StringBuilder formulaStringBuilder, Map.Entry variable) {
        if(variableDictionary.containsKey(variable.getValue())) {
            formulaStringBuilder.append(variableDictionary.get(variable.getValue()).toString());
        }
    }
}
