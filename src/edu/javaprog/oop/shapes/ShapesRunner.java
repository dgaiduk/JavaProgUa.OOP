package edu.javaprog.oop.shapes;

import java.util.Random;

abstract class Figure {
    public abstract double getSquare();
}

class Rectangle extends Figure {
    private int h, w;

    public Rectangle (int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public double getSquare() {
        return h * w;
    }

    @Override
    public String toString() {
        return String.format("Rectangle(%d, %d)", h, w);
    }
}

class Triangle extends Figure {
    private int a, b, c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getSquare() {
        double p = (a + b + c) / 2.0;
        //формула Герона (с) http://100formul.ru/55
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String toString() {
        return String.format("Triangle(%d, %d, %d)", a, b, c);
    }
}

class Circle extends Figure {
    private int r;

    public Circle(int radius) {
        this.r = radius;
    }

    @Override
    public double getSquare() {
        return Math.PI * r * r;
    }

    @Override
    public String toString() {
        return String.format("Circle(%d)", r);
    }
}

public class ShapesRunner {

    static Figure getRandomFigure(Random r) {
        switch (r.nextInt(3)) {
            case 0: return new Triangle(r.nextInt(100), r.nextInt(100), r.nextInt(100));
            case 1: return new Rectangle(r.nextInt(100), r.nextInt(100));
            case 2: return new Circle(r.nextInt(100));
        }
        return null;
    }

    private static void print(Figure f) {
        System.out.println(f + " square = " + f.getSquare());
    }

    public static void main(String[] args) {
        Figure f = new Triangle(1, 1, 1);
        print(f);

        f = new Rectangle(10, 20);
        print(f);

        f = new Circle(10);
        print(f);
        /* Построить иерархию классов «Фигуры» с учетом знаний о полиморфизме.
           У каждого класса фигуры должен быть метод подсчета площади.
           Создать список фигур. Вывести площади всех фигур на экран.
        */
        System.out.println("Generating list of shapes:");
        Figure[] list = new Figure[10];
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            list[i] = getRandomFigure(r);
        }
        for (Figure fl: list) {
            print(fl);
        }
    }
}
