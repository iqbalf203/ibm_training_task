import java.util.ArrayList;
import java.util.List;

public class ArrList3 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("Green");
		list.add("Blue");
		list.add("Yellow");
		list.add("Red");
		
		System.out.println(list);
		
		list.add(0, "White");
		list.add(5,"Pink");
		list.set(1, "Purple");
		
		System.out.println(list);
	}

}
