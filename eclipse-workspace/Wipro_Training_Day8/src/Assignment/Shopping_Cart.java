package Assignment;

import java.util.*;

public class Shopping_Cart {
    public static void main(String[] args) {
        List<String> cart = new ArrayList<>();

        Map<String, Integer> productPrice = new HashMap<>();
        productPrice.put("Laptop", 50000);
        productPrice.put("Mouse", 800);
        productPrice.put("Keyboard", 1500);
        productPrice.put("Headphones", 2000);

        cart.add("Laptop");
        cart.add("Mouse");
        cart.add("Keyboard");

        int total = 0;

        System.out.println("Products in Cart:");
        for (String item : cart) {
            System.out.println(item + " - ₹" + productPrice.get(item));
            total += productPrice.get(item);
        }

        System.out.println("Total Price: ₹" + total);
    }
}