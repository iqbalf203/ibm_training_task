import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrList7 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("Green");
		list.add("Blue");
		list.add("Yellow");
		list.add("Red");
		
		Collections.reverse(list);
		
		System.out.println(list);
	}

}
