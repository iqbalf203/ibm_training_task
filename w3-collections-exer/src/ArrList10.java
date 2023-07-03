import java.util.ArrayList;
import java.util.List;

public class ArrList10 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("Green");
		list.add("Blue");
		list.add("Yellow");
		list.add("Red");
		
		for (int index=0;index<list.size();index++) {
			System.out.println(index+":"+list.get(index));
			
		}
	}

}
