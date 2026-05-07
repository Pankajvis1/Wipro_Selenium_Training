package Assignment;

public class Question_1 {


    static void changeValue(int num) {
        System.out.println("Inside method (before change): " + num);
        num = num + 10;  // Attempt to modify
        System.out.println("Inside method (after change): " + num);
    }

    public static void main(String[] args) {
        int value = 5;

        System.out.println("Before method call: " + value);
        changeValue(value);
        System.out.println("After method call: " + value);
    }
}