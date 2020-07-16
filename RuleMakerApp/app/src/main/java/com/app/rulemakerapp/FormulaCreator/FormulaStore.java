package com.app.rulemakerapp.FormulaCreator;

import java.util.HashMap;

class FormulaStore {

    private static HashMap<String, Formula> formulaMap = new HashMap<>();

    public static void store(String formulaName, Formula formula) {
        int bracket_counter = 0;
        for(char i : formula.toString().toCharArray()) {
            if(i == '[' || i == ']') {
                bracket_counter++;
            }
        }
        if(bracket_counter >= 4) {
            formulaMap.put(formulaName, formula);
        }

    }

    public static Formula getFormula(String formulaName) {
        if(formulaMap.containsKey(formulaName)) {
            return formulaMap.get(formulaName);
        }
        else {
            return new Formula();
        }
    }

    public static void clearFormulaStore() {
        formulaMap.clear();
    }
}
