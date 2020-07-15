package com.app.rulemakerapp.FormulaCreator;

import java.util.HashMap;

class FormulaStore {

    private static HashMap<String, Formula> formulaMap = new HashMap<>();

    public static void store(String formulaName, Formula formula) {
        formulaMap.put(formulaName, formula);
    }

    public static Formula getFormula(String formulaName) {

        return formulaMap.get(formulaName);
    }
}
