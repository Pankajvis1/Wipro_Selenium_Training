package Queue;

import java.util.*;

public class Prio_Queue_Test {

	public static void main(String[] args) {

		Queue<String> q = new PriorityQueue<String>();

		q.add("Dahod");
		q.add("Chennai");
		q.add("Mumbai");
		q.add("Pune");
		q.add("Bhopal");
		q.add("Ahmedabad");
		
		System.out.println(q);

		q.remove();
		System.out.println(q);

		q.remove();
		System.out.println(q);

		q.remove("Mumbai");
		System.out.println(q);

		System.out.println(q.offer("Alpha")); // adds element
		System.out.println(q);

		System.out.println(q.peek()); // retrieve first element

		System.out.println(q.poll()); // retrieve and remove first element

		System.out.println(q);
	}
}