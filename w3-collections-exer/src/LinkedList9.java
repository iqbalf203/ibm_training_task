import java.util.LinkedList;

public class LinkedList9 {

	public static void main(String[] args) {
		String ans;
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("Green");
		list.add("Blue");
		list.add("Yellow");
		list.add("Red");
		list.add(1,"White");
		
		LinkedList<String> list1 = new LinkedList<String>();
		
		list1.add("Pink");
		list1.add("Blue");
		list1.add("Yellow");
		list1.add("Purple");
		list1.add(1,"White");
		
		for(String e:list)
		{
			ans = list1.contains(e)?"Yes":"No";
			System.out.println(ans);
		}

	}

}
