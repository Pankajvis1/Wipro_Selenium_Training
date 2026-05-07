package Collection;
import java.util.*;


public class Collection_practice {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(4);
		list.add(9);
		list.add(0);
		list.add(8);
		list.add(null);
		list.add(null);
		list.add(null);
		list.add(8);
		
		System.out.println(list);
		System.out.println(list.indexOf(8));
		System.out.println(list.contains(9));
		System.out.println(list.isEmpty());
		System.out.println(list.lastIndexOf(null));
		list.remove((Integer)9);
		
		
		System.out.println(list.get(2));
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		list.set(2,10);
		System.out.println(list);
		System.out.println(list.reversed());
	
		
	}

}
