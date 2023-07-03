import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class ArrList9 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("Green");
		list.add("Blue");
		list.add("Yellow");
		list.add("Red");
		
		((ArrayList<String>) list).trimToSize();
		
		System.out.println(list);

	}

}
