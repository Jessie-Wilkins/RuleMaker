package com.app.rulemakerapp.FormulaCreator;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class FormulaQuestionnaireTest {

    @Before
    public void preparation() {
        HashMap<Integer, String> questionMap = new HashMap<>();
        questionMap.put(0, "Are You Reading This Test Question?");
        questionMap.put(1, "Is this question specific?");
        FormulaQuestionnaire.retrieveQuestions(questionMap);
    }

    @Test
    public void testThatFormulaQuestionnaireCanRetrieveAQuestion() {

        FormulaQuestionnaire formulaQuestionnaire = new FormulaQuestionnaire();

        assertEquals("Are You Reading This Test Question?", formulaQuestionnaire.getQuestion(0));
    }

    @Test
    public void testThatFormulaQuestionnaireCanRetrieveASpecificQuestion() {
        FormulaQuestionnaire formulaQuestionnaire = new FormulaQuestionnaire();

        assertEquals("Is this question specific?", formulaQuestionnaire.getQuestion(1));
    }

   /* @Test
    public void testThatFormulaQuestionnaireCanCreateQuestionProcessingAlgorithmForTypingName() {
        FormulaQuestionnaire formulaQuestionnaire = new FormulaQuestionnaire();

        formulaQuestionnaire.setQuestionAnswerType();

        assertEquals("Is this question specific?", formulaQuestionnaire.getQuestion(1));
    }*/

}