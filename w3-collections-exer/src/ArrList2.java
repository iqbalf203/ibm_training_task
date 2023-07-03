import java.util.ArrayList;
import java.util.List;

public class ArrList2 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("Green");
		list.add("Blue");
		list.add("Yellow");
		list.add("Red");
		
		for(String i:list) {
			System.out.println(i);
		}
	}

}
