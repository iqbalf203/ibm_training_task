import java.util.ArrayList;
import java.util.List;

public class ArrList5 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("Green");
		list.add("Blue");
		list.add("Yellow");
		list.add("Red");
		
		list.set(2, "White");
		
		System.out.println(list);

	}

}
