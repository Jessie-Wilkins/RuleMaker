package com.app.rulemakerapp.FormulaCreator;

import java.util.HashMap;

class FormulaQuestionnaire {

    private static HashMap<Integer, String> questionMap = new HashMap<>();

    public enum AnswerType {
        VARIABLE,
        SELECTION,
    }

    public static void retrieveQuestions(HashMap questionMapInput) {
        questionMap = questionMapInput;
    }

    public String getQuestion(int i) {
        return questionMap.get(i);
    }

    public void setQuestionAnswerType(String s) {
    }
}
