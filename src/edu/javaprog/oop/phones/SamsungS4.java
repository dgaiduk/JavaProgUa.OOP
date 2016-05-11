package edu.javaprog.oop.phones;
/**
 * Создал новый класс, наследник Phone
 * Переопределил метод sendSMS для изменения текста сообщения
 */
public class SamsungS4 extends Phone {

    public SamsungS4(String number) {
        super(number);
        touch = true;
        screenSize = 5;
        hasWifi = true;
        System.out.println("SamsungS4 constructor");
    }

    @Override
    public void sendSMS(String number, String message) {
        //вызываю родительский метод с модификацией текста сообщения
        super.sendSMS(number, "Hello. " + message);
    }
}
