package Assignment;

import java.util.*;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return title + " by " + author;
    }
}

public class Library_Management {
    public static void main(String[] args) {
        Map<Book, Boolean> library = new HashMap<>();

        Book b1 = new Book("Java Basics", "James");
        Book b2 = new Book("Data Structures", "Mark");
        Book b3 = new Book("Operating Systems", "John");

        library.put(b1, true);
        library.put(b2, false);
        library.put(b3, true);

        System.out.println("Library Book Availability:");

        for (Map.Entry<Book, Boolean> entry : library.entrySet()) {
            System.out.println(entry.getKey() + " -> " +
                    (entry.getValue() ? "Available" : "Not Available"));
        }
    }
}