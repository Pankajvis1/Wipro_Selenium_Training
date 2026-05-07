package Assignment;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        String str = "programming";
        String result = removeDuplicates(str);
        System.out.println(result);
    }

    public static String removeDuplicates(String str) {
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (!set.contains(ch)) {
                set.add(ch);
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}