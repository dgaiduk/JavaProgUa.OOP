package edu.javaprog.oop.phones;

/**
 * Добавил только номера телефонов в параметры конструкторов
 */
public class MainClass {

    public static void main(String[] args) {
        // Phone p = new Phone(); ошибка т.к. класс абстрактный
        
        Nokia3310 nokia = new Nokia3310("123-45-67");
        System.out.println("Nokia3310 screent size: " + nokia.getScreenSize());
        nokia.call("123-45-67");
        nokia.sendSMS("567-78-89", "text message");
        
        System.out.println("----------------------------------");
        
        IPhone iphone = new IPhone("567-78-89");
        System.out.println("IPhone screent size: " + iphone.getScreenSize());
        iphone.call("123-45-67");
        iphone.sendSMS("567-78-89", "text message");
        
        System.out.println("----------------------------------");
        
        IPhone5 iphone5 = new IPhone5("234-56-78");
        System.out.println("IPhone screent size: " + iphone5.getScreenSize());
        iphone5.call("123-45-67");
        iphone5.sendSMS("567-78-89", "text message");

        System.out.println("----------------------------------");

        SamsungS4 samsungS4 = new SamsungS4("333-33-33");
        System.out.println("SamsungS4 screen size: " + samsungS4.getScreenSize());
        samsungS4.call("123-45-67");
        samsungS4.sendSMS("567-78-89", "text message");
    }
}
