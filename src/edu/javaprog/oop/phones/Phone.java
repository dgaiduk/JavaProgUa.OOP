package edu.javaprog.oop.phones;

import java.util.Arrays;

/**
 * Добавил private поля callsCount и smsCount - для подсчета звонков и смс
 *      final String number - для read-only хранения своего номера телефона
 *      статический массив Phone[] allPhones - для хранения всех доступных телефонов
 *      phonesCount - счетчик массива
 * Добавил callsCount++; в метод call()
 * Изменил метод sendSMS():
 *      - сделал не абстрактным
 *      - добавил тело, в т.ч. и smsCount++;
 * Добавил публичный метод answer(), который вызывается в методе call();
 *      статический метод getPhoneByNumber() - для поиска объекта телефона по номеру
 */
public abstract class Phone {
    
    protected boolean touch;
    protected boolean hasWifi;
    protected int screenSize;

    private int callsCount = 0;
    private int smsCount = 0;
    private static Phone[] allPhones = new Phone[10];
    private static int phonesCount = 0;
    private final String number;

    public Phone(String number) {
        System.out.println("Phone constructor (number=" + number + ")");
        if (getPhoneByNumber(number) == null ) {
            // добавляем телефон с номером в список только если такого номера еще не было
            this.number = number;
            if (phonesCount == allPhones.length) {
                //расширение массива
                allPhones = Arrays.copyOf(allPhones, allPhones.length + 10);
            }
            allPhones[phonesCount++] = this;
        } else {
            this.number = "";
            System.out.println("Phone with number " + number + " already exists!");
        }
    }

    public static Phone getPhoneByNumber(String number) {
        for (int i = 0; i < phonesCount; i++) {
            if (allPhones[i].number.equals(number)) {
                return allPhones[i];
            }
        }
        return null;
    }

    public boolean isTouch() {
        return touch;
    }
    
    public boolean isHasWifi() {
        return hasWifi;
    }
    
    public int getScreenSize() {
        return screenSize;
    }
    
    public void call(String number) {
        if (this.number.equals(number)) {
            System.out.println("Can not call to myself!");
        } else {
            callsCount++;
            System.out.println("(Call #" + callsCount + "): Phone class is calling " + number);
            Phone abonent = Phone.getPhoneByNumber(number);
            if (abonent != null) {
                abonent.answer();
            } else {
                System.out.println("Abonent can not answer your call");
            }
        }
    }
    
    public void sendSMS(String number, String message) {
        smsCount++;
        System.out.println("(SMS #" + smsCount + ") to <" + number + ">: " + message);
    }

    public void answer() {
        System.out.println(this.getClass() + " " + number + " answer: Hello!");
    }
}
