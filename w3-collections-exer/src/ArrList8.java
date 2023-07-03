import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrList8 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("Green");
		list.add("Blue");
		list.add("Yellow");
		list.add("Red");
		
		Collections.swap(list, 0, 2);
		
		System.out.println(list);

	}

}
