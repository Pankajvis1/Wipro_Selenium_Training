package Collection;

import java.util.*;

public class Tree_Set {
    public static void main(String[] args) {

        // elements stored in ascending order
        // follows sorting order
        // null is not allowed
        // duplicate values are not allowed

        Set<String> set = new TreeSet<String>();

        set.add("Orange");
        set.add("Mango");
        set.add("Kiwi");
        set.add("Apple");
        set.add("Apple"); // duplicate not allowed

        // set.add(null); // null not allowed in TreeSet
        // set.add(null);

        System.out.println(set);

        System.out.println(set.equals("Orange")); // false

        set.remove("Kiwi");

        System.out.println(set);

      

        Iterator<String> itr = set.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
           
        }
    }
}