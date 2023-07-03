import java.util.LinkedList;

public class LinkedList5 {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("Green");
		list.add("Blue");
		list.add("Yellow");
		list.add("Red");
		
		list.addAll(1, list);
		System.out.println(list);

	}

	}
