import java.util.LinkedList;

public class LinkedList10 {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("Green");
		list.add("Blue");
		list.add("Yellow");
		list.add("Red");
		list.add(1,"White");
		
		System.out.println(list);
		
		list.set(0, "Purple");
		
		System.out.println(list);
		
	}

}
