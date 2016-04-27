package edu.javaprog.oop.module2;

public class Car {
    private String name;
    private Engine engine; // мотор
    private Climate climate = new Climate(); // климат-контроль
    
    public Car(String name) {
        this.name = name;
        engine = new Engine(0);
    }
    
    public Car(String name, double mileage) {
        this.name = name;
        engine = new Engine(mileage);
    }
    
    public String getName() {
        return name;
    }
    
    public double getMileage() {
        return engine.getMileage();
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
        }
    }
}