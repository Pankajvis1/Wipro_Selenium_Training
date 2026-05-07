package Collection;
import java.util.*;


public class Linked_List {

	public static void main(String[] args) {
		int[] arr = {9,8};
		List<Integer> list = new LinkedList<Integer>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
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
		ListIterator<Integer> it = list.listIterator();
		Iterator<Integer> itr = list.iterator();
		
		while (it.hasNext()) {
			
			System.out.println(it.next());
		}
		
	}

}
