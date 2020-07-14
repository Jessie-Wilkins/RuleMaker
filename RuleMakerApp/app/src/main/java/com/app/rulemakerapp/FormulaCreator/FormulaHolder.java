package com.app.rulemakerapp.FormulaCreator;

import java.util.HashMap;
import java.util.Map;

public class FormulaHolder {

    private HashMap<String, FormulaComponents.Operator> variableDictionary = new HashMap<>();

    private HashMap<Integer, String> variableOrder = new HashMap<>();

    private HashMap<String, FormulaComponents.DataType> variableDataType = new HashMap<>();

    private int currentOrder = 0;

    private boolean operatorIsSet = false;

    private boolean dataTypeIsSet = false;

    public void setVariable(String variable) {

        incrementOrderIfOtherComponentsAreSet();

        String temp_variable = variableOrder.get(currentOrder);

        variableOrder.put(currentOrder, variable);

        if(variableDictionary.containsKey(temp_variable) && !variableOrder.containsValue(temp_variable)) {
            setOperator(variableDictionary.get(temp_variable));
        }

        if(variableDataType.containsKey(temp_variable) && !variableOrder.containsValue(temp_variable)) {
            setDataType(variableOrder.get(currentOrder),variableDataType.get(variableOrder.get(currentOrder)));
        }
    }

    @Override
    public String toString() {
        StringBuilder formulaStringBuilder = new StringBuilder();
        buildFormulaString(formulaStringBuilder);
        return formulaStringBuilder.toString();
    }

    public void setOperator(FormulaComponents.Operator operator) {
        variableDictionary.put(variableOrder.get(currentOrder), operator);
        operatorIsSet = true;
    }

    public void setDataType(String variable, FormulaComponents.DataType dataType) {
        if(variableOrder.containsValue(variable)) {
            variableDataType.put(variable, dataType);
            dataTypeIsSet = true;
        }
    }

    //Private Utilities

    private void incrementOrderIfOtherComponentsAreSet() {
        if(operatorIsSet && dataTypeIsSet) {
            currentOrder++;
            operatorIsSet = false;
            dataTypeIsSet = false;
        }
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
