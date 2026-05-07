package com.math.operations;

public class Add_Sub {

    public void addition(int a, int b) {
        System.out.println("Addition = " + (a + b));
    }

    public void subtraction(int a, int b) {
        System.out.println("Subtraction = " + (a - b));
    }

    public static void main(String[] args) {
        Add_Sub obj = new Add_Sub();

        obj.addition(20, 10);
        obj.subtraction(20, 10);
    }
}