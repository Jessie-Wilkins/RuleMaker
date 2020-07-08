package com.app.rulemakerapp.FormulaCreator;

class FormulaComponents {

    public enum Operator {
        MULTIPLICATION ("*") ,
        DIVISION ("/"),
        ADDITION ("+"),
        SUBTRACTION ("-"),
        GREATER_THAN (">"),
        LESS_THAN ("<"),
        EQUAL_TO ("="),
        GREATER_THAN_OR_EQUAL_TO (">="),
        LESS_THAN_OR_EQUAL_TO ("<=");

        private String string_value = "";

        Operator(String string_value) {
            this.string_value = string_value;
        }
        @Override
        public String toString() {
            return this.string_value;
        }
    }

}
