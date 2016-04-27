package edu.javaprog.oop.module1;

public class Engine {
    private double mileage;
    private boolean started;
    private double capacity; //google translated :)
    private double[] consumptionTab;

    private void initConsumptionTab() {
        consumptionTab = new double[2];
        //[0] - economic mode; [1] - full mode
        if (capacity <= 0) {
            //raise exception ??
        } else if (capacity < 2) {
            consumptionTab[0] = 6;
            consumptionTab[1] = 10;
        } else if (capacity < 5) {
            consumptionTab[0] = 10;
            consumptionTab[1] = 20;
        } else {
            consumptionTab[0] = 20;
            consumptionTab[1] = 40;
        }
    }

    public Engine(double mileage, double capacity) {
        this.mileage = mileage;
        this.capacity = capacity;
        initConsumptionTab();
    }

    public double getFuelConsumption(int speed, double distance) {
        if (speed < 0) {
            return -1;
        }
        double rate = 0;
        if ((speed < 40) || (speed > 150)) {
            // max consumption
            rate = consumptionTab[1];
        } else {
            // economic consumption
            rate = consumptionTab[0];
        }
        return rate * distance / 100;
    }

    public double getMileage() {
        return mileage;
    }

    public void addMileage(double mileage) {
        if (started)
            this.mileage += mileage;
    }

    public double getCapacity() {
        return capacity;
    }

    public boolean isStarted() {
        return started;
    }

    public void turnOn() {
        started = true;
    }

    public void turnOff() {
        started = false;
    }
}
