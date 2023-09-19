package it.gabbo;
import java.util.Scanner;

class Rectangle {
    float b;
    float h;

    public Rectangle(float b, float h) {
        this.b = b;
        this.h = h;
    }

    float calcoloArea(float b, float h) {
        float area = this.b * this.h;
        return area;
    }

    float calcoloPerimetro(float b, float h) {
        float perimetro = (2*this.b) + (2*this.h);
        return perimetro;
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float base;
        float altezza;
        float perimetro, area;


        System.out.println("Base e altezza rettangolo 1: ");
        base = scanner.nextFloat();
        altezza = scanner.nextFloat();
        Rectangle rect1 = new Rectangle(base, altezza);
        System.out.println("Perimetro: " + rect1.calcoloPerimetro(base, altezza));
        System.out.println("Area: " + rect1.calcoloArea(base, altezza));


        System.out.println("Base e altezza rettangolo 2:");
        Rectangle rect2 = new Rectangle(base, altezza);
        base = scanner.nextFloat();
        altezza = scanner.nextFloat();
        System.out.println("Perimetro: " + rect2.calcoloPerimetro(base, altezza));
        System.out.println("Area: " + rect2.calcoloArea(base, altezza));


        System.out.println("Base e altezza rettangolo 3:");
        base = scanner.nextFloat();
        altezza = scanner.nextFloat();
        Rectangle rect3 = new Rectangle(base, altezza);
        System.out.println("Perimetro: " + rect3.calcoloPerimetro(base, altezza));
        System.out.println("Area: " + rect3.calcoloArea(base, altezza));


        area = rect1.calcoloArea(base, altezza) + rect2.calcoloArea(base, altezza) + rect3.calcoloArea(base, altezza);
        System.out.println("Area totale: " + area);
        perimetro = rect1.calcoloPerimetro(base, altezza) + rect2.calcoloPerimetro(base, altezza) + rect3.calcoloPerimetro(base, altezza);
        System.out.println("Perimetro totale: " + perimetro);
    }
}

