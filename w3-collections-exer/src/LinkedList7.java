import java.util.LinkedList;

public class LinkedList7 {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("Green");
		list.add("Blue");
		list.add("Yellow");
		list.add("Red");

		System.out.println(list.pop());
		System.out.println(list);

	}

}
