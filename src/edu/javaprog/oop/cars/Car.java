package edu.javaprog.oop.cars;

public class Car {
    private String name;
    private Engine engine; // мотор
    private Climate climate = new Climate(); // климат-контроль
    private double consumed; //потрачено литров топлива

    public Car(String name) {
        this.name = name;
        engine = new Engine(0, 1.6);
    }

    public Car(String name, double mileage, double capacity) {
        this.name = name;
        engine = new Engine(mileage, capacity);
    }

    public String getName() {
        return name;
    }

    public double getMileage() {
        return engine.getMileage();
    }

    public double getCapacity() {
        return engine.getCapacity();
    }

    public double getConsumed() {
        return consumed;
    }

    // завести мотор
    public void turnOn() {
        engine.turnOn();
        climate.turnOn();
        climate.setTemperature(21);
    }

    // заглушить мотор
    public void turnOff() {
        climate.turnOff();
        engine.turnOff();
    }

    // установить скорость
    public void start(int speed, double hours) {
        if (engine.isStarted()) { // еще не заведен мотор
            // пройденная дистанция
            double distance = hours * speed;
            engine.addMileage(distance);
            //потрачено топлива
            System.out.print(name + " before=" + consumed);
            consumed += engine.getFuelConsumption(speed, distance);
            System.out.println(", after=" + consumed + " speed=" + speed + " distance=" + distance);
        }
    }
}
