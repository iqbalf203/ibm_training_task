import java.util.Iterator;
import java.util.LinkedList;


public class LinkedList1 {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("Green");
		list.add("Blue");
		list.add("Yellow");
		list.add("Red");
		
		Iterator p= list.listIterator(1); 
		
		while(p.hasNext()) {
			System.out.println(p.next());
		}
		
		

	}

}
