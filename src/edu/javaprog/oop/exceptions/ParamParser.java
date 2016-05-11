package edu.javaprog.oop.exceptions;


class MyParserException extends Exception {

    public MyParserException(String message) {
        super("Parsing error: " + message);
    }
}

public class ParamParser {

    private static void throwParserException(String cause, String value) throws MyParserException {
        throw new MyParserException("Format violated. " + cause + " in: \"" + value + "\"");
    }

    public static void validate(String[] pair, String source) throws MyParserException {
        switch (pair.length) {
            case 0: throwParserException("Param name and value are missing", source);
            case 1: throwParserException("Value expected after '=' symbol", source);
            case 2: break;
            default: throwParserException("'&' symbol expected to divide param-value pairs", source);
        }
        // first part of pair is empty
        if (pair[0].equals("")) {
            throwParserException("Param name expected before '=' symbol", source);
        }
        // second part of pair is empty
        if (pair[1].equals("")) {
            throwParserException("Value expected after '=' symbol", source);
        }
    }

    private static void print (String[][] result) {
        for (String[] pair: result) {
            System.out.println(pair[0] + " : " + pair[1]);
        }
    }

    public static String[][] parse(String paramStr) throws MyParserException {
        System.out.println(paramStr);
        if (paramStr.length() == 0) {
            throwParserException("Empty string!", paramStr);
        }

        String[] split1 = paramStr.split("&");
        String[][] result = new String[split1.length][2];

        for (int i = 0; i < split1.length; i++) {
            String[] split2 = split1[i].split("=");
            validate(split2, split1[i]);
            result[i] = split2;
        }

        return result;
    }

    public static void main(String[] args) {
        String params = "p=1&a=0";
        try {
            String[][] parsedParams = parse(params);
            print(parsedParams);
        } catch (MyParserException e) {
            System.out.println(e);
        }
    }
}
