package edu.javaprog.oop.exceptions;

import java.io.UnsupportedEncodingException;

public class Class1 {
    public static void main(String[] args) {
        try {
            byte b = Byte.parseByte("ss");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("dasd".getBytes("ASCII"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
