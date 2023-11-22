package dz1;


import dz1.Calculator.Calculator;

public class Main {
    public static void main(String[] args) {

        System.out.println("Стоимость товара со скидкой: " +
                Calculator.calculatingDiscount(100,25));
        System.out.println("Стоимость товара со скидкой: " +
                Calculator.calculatingDiscount(-10,10));
        System.out.println("Стоимость товара со скидкой: " +
                Calculator.calculatingDiscount(100,28));
    }
}