package Collection;

import java.util.*;

public class Linked_HashSet {
    public static void main(String[] args) {

        Set<String> set = new LinkedHashSet<String>();

        set.add("Orange");
        set.add("Mango");
        set.add("Kiwi");
        set.add("Apple");
        set.add("Apple"); // duplicate not allowed
        set.add(null);
        set.add(null);    // only one null allowed

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