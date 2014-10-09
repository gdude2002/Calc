package me.gserv.Calc;

/**
 * Created by bw5 on 09/10/2014.
 */
public enum Operations {
    PLUS("+"), MINUS("-"), EQUALS("="),
    MULTIPLY("*"), DIVIDE("/"), POWER("^"),
    UNKNOWN("?");

    private final String op;

    private Operations(final String op) {
        this.op = op;
    }

    @Override
    public String toString() {
        return op;
    }

    public static Operations getFromString(String operation) {
        if (operation.equals("+")) {
            return PLUS;
        } else if (operation.equals("-")) {
            return MINUS;
        } else if (operation.equals("=")) {
            return EQUALS;
        } else if (operation.equals("*")) {
            return MULTIPLY;
        } else if (operation.equals("/")) {
            return DIVIDE;
        } else if (operation.equals("^")) {
            return POWER;
        } else {
            return UNKNOWN;
        }
    }
}
