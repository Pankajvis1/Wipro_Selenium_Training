package Collection;

import java.util.*;

public class Hash_Set {
    public static void main(String[] args) {

        // elements stored on the basis of hash code value
        // does not follow insertion order
        // single null allowed
        // duplicate values are not allowed

        Set<String> set = new HashSet<String>();

        set.add("Orange");
        set.add("Mango");
        set.add("Kiwi");
        set.add("Apple");
        set.add("Apple"); // duplicate, will not be added
        set.add(null);
        set.add(null);    // only one null allowed

        System.out.println(set);
    }
}