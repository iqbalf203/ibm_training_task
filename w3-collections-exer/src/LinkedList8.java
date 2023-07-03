import java.util.LinkedList;

public class LinkedList8 {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("Green");
		list.add("Blue");
		list.add("Yellow");
		list.add("Red");
		
		list.add(1,"White");
		
		if (list.contains("Blue")) {
		System.out.println("Is present");}
		else System.out.println("Not present");

	}
}
